package com.twentyfive.twentyfivelyapilayer.controllers;

import com.twentyfive.authorizationcontroller.services.AuthenticationService;
import com.twentyfive.twentyfivelyapilayer.clients.InternalShortenLinkController;
import com.twentyfive.twentyfivemodel.dto.twentyfiveLyDto.RequestValue;
import com.twentyfive.twentyfivemodel.dto.twentyfiveLyDto.ResponseValue;
import com.twentyfive.twentyfivemodel.models.twentyfiveLyModels.ShortenLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/shorten-link")
@CrossOrigin(origins = "*")
public class ShortenLinkController {
    @Autowired
    private InternalShortenLinkController internalLinkController;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/generate")
    public ResponseEntity<Object> generateShortenLink(@RequestBody RequestValue requestValue) throws URISyntaxException, MalformedURLException {
        String username = authenticationService.getUsername();
        String urlRegex = "^((https?://)?(www\\.)?)?([\\da-z.-]+)\\.([a-z.]{2,6})(?::[0-9]{1,5})?(/[\\-a-zA-Z0-9@:%._+~#=]*)*(/[\\w/]*)*(\\?[;&a-zA-Z0-9%_.~+=-]*)?(#[\\-\\w]*)?$";
        if (!requestValue.getUrl().matches(urlRegex)) {
            return ResponseEntity.badRequest().body("Invalid URL");
        }
        //don't remove it!!!! it's for URL validation
        //URI uri = new URI(requestValue.getUrl());
        requestValue.setUrl(requestValue.getUrl());
        ResponseValue result = internalLinkController.generateShortenLink(requestValue);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/get-complete-link/{shortUrl}")
    public ResponseEntity<String> getCompleteShortenLink(@PathVariable String shortUrl) {
        String username = authenticationService.getUsername();
        String result = internalLinkController.getCompleteShortenLink(shortUrl);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<Object> getAllLinksForUserId(@PathVariable String userId) {
        String username = authenticationService.getUsername();
        List<ShortenLink> result = internalLinkController.getAllLinksForUserId(userId);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteLink(@PathVariable String id) {
        String username = authenticationService.getUsername();
        ResponseValue result = internalLinkController.deleteLink(id);
        return ResponseEntity.ok().body(result);
    }
}
