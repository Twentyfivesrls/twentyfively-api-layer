package com.twentyfive.twentyfivelyapilayer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BasicRedirectController {

    @Autowired
    private ShortenLinkController shortenLinkController;
    @GetMapping("/{shortenUrl}")
    public String redirect(@PathVariable String shortenUrl, Model model){
        String destinationUrl = String.valueOf(shortenLinkController.getCompleteShortenLink(shortenUrl));
        System.out.println("ciao");
        return "redirect:" + destinationUrl;
    }
}
