package com.example.eshop.controller;

import com.example.eshop.model.ShopItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class ShopItemController {

    private List<ShopItem> itemsList = new ArrayList<>();

    public ShopItemController() {

        itemsList.add(new ShopItem("Running Shoes", "Nike running shoes for every day sport", 1000.0, 5));
        itemsList.add(new ShopItem("Printer", "Some HP printer that will print pages", 3000.0, 2));
        itemsList.add(new ShopItem("Coca Cola", "0.5l standard coke", 25.0, 0));
        itemsList.add(new ShopItem("Wokin", "Chicken with fried rice and WOKIN sauce", 119.0, 100));
        itemsList.add(new ShopItem("T-shirt", "Blue with a corgi on a bike", 300.0, 1));
    }

    @GetMapping("/webshop")
    public String showContent(Model model) {

        model.addAttribute("shopItemList", itemsList);

        return "table";
    }

    @GetMapping("/only-available")
    public String showAvailable(Model model) {

        itemsList.removeIf(item -> item.getQuantityOfStock() == 0);

        model.addAttribute("shopItemList", itemsList);

        return "table";
    }

    @GetMapping("/cheapest")
    public String showCheapest(Model model) {

        List<ShopItem> cheapestList = itemsList.stream()
                .sorted(Comparator.comparing(ShopItem::getPrice))
                .collect(Collectors.toList());

        model.addAttribute("shopItemList", cheapestList);

        return "table";
    }

    @GetMapping("/nike")
    public String showNike(Model model) {

        itemsList.removeIf(item -> !item.getName().contains("Nike") && !item.getDescription().contains("Nike"));

        model.addAttribute("shopItemList", itemsList);

        return "table";
    }

    @GetMapping("/average-stock")
    public String showAverageStock(Model model) {

        double averageStock = itemsList.stream()
                .mapToDouble(item -> item.getQuantityOfStock())
                .average()
                .orElse(0.0);
        model.addAttribute("averageStockHeader", "Average stock: ");
        model.addAttribute("averageStock", averageStock);

        return "one-line";
    }

    @GetMapping("/most-expensive")
    public String showMostExpensive(Model model) {

        Optional<ShopItem> mostExpensiveItem = itemsList.stream()
                .max(Comparator.comparing(ShopItem::getPrice));

        model.addAttribute("mostExpensiveHeader", "Most expensive item: ");
        model.addAttribute("mostExpensive", mostExpensiveItem.get().getName());

        return "one-line";
    }
}