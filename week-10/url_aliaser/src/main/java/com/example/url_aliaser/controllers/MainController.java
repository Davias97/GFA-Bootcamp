package com.example.url_aliaser.controllers;

import com.example.url_aliaser.models.Alias;
import com.example.url_aliaser.models.Link;
import com.example.url_aliaser.services.AliasService;
import com.example.url_aliaser.services.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class MainController {

    LinkService linkService;
    AliasService aliasService;

    public MainController(LinkService linkService, AliasService aliasService) {
        this.linkService = linkService;
        this.aliasService = aliasService;
    }

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("aliasList", aliasService.findAll());

        return "index";
    }

    @PostMapping("/save-link")
    public String saveLink(Optional<String> url, Optional<String> alias, RedirectAttributes ra) {

        if (url.isPresent() && alias.isPresent() &&
                aliasService.findByAlias(alias.get()) == null) {
            if (url.get().isBlank() || alias.get().isBlank()) {
                ra.addFlashAttribute("error", "You have to fill url and alias!");
                return "redirect:/";
            }

            Link link = new Link(url.get());
            Alias alias1 = new Alias(alias.get());
            alias1.setLink(link);
            link.getAliasList().add(alias1);
            linkService.save(link);
            ra.addFlashAttribute("succes", "Your url has been aliased to " + alias.get() + " and your secret code is " + alias1.getSecretCode() + ".");
            ra.addFlashAttribute("aliasList", aliasService.findAll());
            return "redirect:/";
        }
        ra.addFlashAttribute("error", "Your alias is already in use");
        ra.addFlashAttribute("aliasList", aliasService.findAll());
        ra.addFlashAttribute("url", url.get());
        ra.addFlashAttribute("alias", alias.get());
        return "redirect:/";
    }

    @GetMapping("/a/{alias}")
    public String incrementHitCount(@PathVariable String alias) {
        Alias optionalAlias = aliasService.findByAlias(alias);

        if (optionalAlias == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
        aliasService.increment(optionalAlias);
        aliasService.save(optionalAlias);
        return "redirect:" +optionalAlias.getLink().getUrl();
    }
}
