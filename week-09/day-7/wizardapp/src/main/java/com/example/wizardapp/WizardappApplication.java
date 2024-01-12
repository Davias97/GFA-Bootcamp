package com.example.wizardapp;

import com.example.wizardapp.models.MagicalItem;
import com.example.wizardapp.models.Wizard;
import com.example.wizardapp.services.MagicalItemService;
import com.example.wizardapp.services.WizardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class WizardappApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WizardappApplication.class, args);
    }

    @Autowired
    private WizardService wizardService;
    @Autowired
    private MagicalItemService magicalItemService;

    @Override
    public void run(String... args) throws Exception {

        Wizard wizard1 = new Wizard("Dobroděj", 328);
        Wizard wizard2 = new Wizard("Jaina", 178);
        Wizard wizard3 = new Wizard("Kaelthas", 228);

        wizardService.saveWizard(wizard1);
        wizardService.saveWizard(wizard2);
        wizardService.saveWizard(wizard3);

        MagicalItem magicalItem1 = new MagicalItem("Staff of the Kirin Tor", 1500);
        MagicalItem magicalItem2 = new MagicalItem("Dragonwrath", 4000);
        MagicalItem magicalItem3 = new MagicalItem("Dreambinder", 2000);
        MagicalItem magicalItem4 = new MagicalItem("Dabunas Revenge", 9999);

        magicalItem1.setWizard(wizard2);
        magicalItem2.setWizard(wizard1);
        magicalItem3.setWizard(wizard3);
        magicalItem4.setWizard(wizard1);

        magicalItemService.saveMagicalItem(magicalItem1);
        magicalItemService.saveMagicalItem(magicalItem2);
        magicalItemService.saveMagicalItem(magicalItem3);
        magicalItemService.saveMagicalItem(magicalItem4);
    }
}
