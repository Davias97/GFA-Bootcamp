package com.example.url_aliaser;

import com.example.url_aliaser.models.Alias;
import com.example.url_aliaser.models.Link;
import com.example.url_aliaser.services.AliasService;
import com.example.url_aliaser.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class UrlAliaserApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UrlAliaserApplication.class, args);
    }

    @Autowired
    AliasService aliasService;
    @Autowired
    LinkService linkService;

    @Override
    public void run(String... args) throws Exception {
        Alias alias1 = new Alias("dabu");
        Alias alias2 = new Alias("dabuu");
        Alias alias3 = new Alias("dabuuu");
        Link link1 = new Link("https://www.youtube.com");
        Link link2 = new Link("https://www.videacesky.cz");
        Link link3 = new Link("https://www.reddit.com");
        linkService.save(link1);
        linkService.save(link2);
        linkService.save(link3);
        alias1.setHitCount(12);
        alias2.setHitCount(122);
        alias3.setHitCount(121);
        alias1.setLink(link1);
        alias2.setLink(link2);
        alias3.setLink(link3);

        aliasService.save(alias1);
        aliasService.save(alias2);
        aliasService.save(alias3);
    }
}
