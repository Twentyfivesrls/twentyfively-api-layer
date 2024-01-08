package com.twentyfive.twentyfivelyapilayer.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BasicRedirectController {

    private final ShortenLinkController shortenLinkController;

    public BasicRedirectController(ShortenLinkController shortenLinkController) {
        this.shortenLinkController = shortenLinkController;
    }

    @GetMapping("/{shortenUrl}")
    public String redirect(@PathVariable String shortenUrl, Model model){
        ResponseEntity<String> destinationUrl = shortenLinkController.getCompleteShortenLink(shortenUrl);
        if(destinationUrl == null){
            return "redirect:/";
        }else{
            return "redirect:" + destinationUrl.getBody();
        }
    }
}
