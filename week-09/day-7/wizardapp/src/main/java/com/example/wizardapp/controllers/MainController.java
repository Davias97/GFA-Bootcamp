package com.example.wizardapp.controllers;

import com.example.wizardapp.DTOs.ErrorDTO;
import com.example.wizardapp.models.MagicalItem;
import com.example.wizardapp.models.Wizard;
import com.example.wizardapp.services.MagicalItemService;
import com.example.wizardapp.services.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/wizardapp")
public class MainController {

    @Autowired
    private WizardService wizardService;
    @Autowired
    private MagicalItemService magicalItemService;

    @GetMapping("/wizards")
    public String getlistAllWizards(Model model) {
        if (wizardService.listWizards().isEmpty()) {
            ErrorDTO errorDTO = new ErrorDTO("wizard list");
            model.addAttribute("error", errorDTO);
            return "404";
        }

        model.addAttribute("wizards", wizardService.listWizards());

        return "wizards";
    }

    @PostMapping("/wizards")
    public String postlistAllWizards(Model model) {
        if (wizardService.listWizards().isEmpty()) {
            ErrorDTO errorDTO = new ErrorDTO("wizard list");
            model.addAttribute("error", errorDTO);
            return "404";
        }

        model.addAttribute("wizards", wizardService.listWizards());

        return "wizards";
    }

    @PutMapping("/wizards")
    public String putlistAllWizards(Model model) {
        model.addAttribute("items", magicalItemService.listMagicalItems());
        return "items";
    }

    @GetMapping("/wizards/{id}")
    public String wizardDetail(Model model, @PathVariable Long id) {
        Optional<Wizard> optionalWizard = wizardService.findById(id);

        if (optionalWizard.isPresent()) {
            Wizard wizard = optionalWizard.get();
            model.addAttribute("wizard", wizard);
            return "wizarddetail";
        }
        ErrorDTO errorDTO = new ErrorDTO("wizard");
        model.addAttribute("error", errorDTO);
        return "404";
    }

    @GetMapping("/addWizard")
    public String getAddWizard(Model model) {
        Wizard wizard = new Wizard();
        model.addAttribute("wizard", wizard);
        return "addwizard";
    }

    @PostMapping("/addWizard")
    public String postAddWizard(@ModelAttribute Wizard wizard) {

        wizardService.saveWizard(wizard);

        return "redirect:/wizardapp/wizards";
    }

    @GetMapping("/addMagicalitem")
    public String getAddMagicalItem(Model model) {
        MagicalItem magicalItem = new MagicalItem();
        model.addAttribute("item", magicalItem);
        return "additem";
    }

    @PostMapping("/addMagicalitem")
    public String postAddMagicalItem(@ModelAttribute MagicalItem magicalItem, Model model) {
        if (magicalItem.getPowerLevel() < 0) {
            ErrorDTO errorDTO = new ErrorDTO("Please provide a non-negative power level");
            model.addAttribute("error", errorDTO);
            return "invalidinput";
        }
        magicalItemService.saveMagicalItem(magicalItem);
        return "redirect:/wizardapp/wizards";
    }
}