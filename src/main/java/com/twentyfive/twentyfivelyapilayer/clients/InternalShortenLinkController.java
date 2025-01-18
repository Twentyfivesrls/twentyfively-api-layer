package com.twentyfive.twentyfivelyapilayer.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import twentyfive.twentyfiveadapter.dto.twlyDto.RequestValue;
import twentyfive.twentyfiveadapter.dto.twlyDto.ResponseValue;
import twentyfive.twentyfiveadapter.models.twlyModels.ShortenLink;

import java.util.List;

@FeignClient(name = "InternalShortenLinkController",
        url = "${twentyfive.db.url}/shorten-link")
public interface InternalShortenLinkController {

    @RequestMapping(method = RequestMethod.POST, value="/generate")
    ResponseValue generateShortenLink(@RequestBody RequestValue requestValue);

    @RequestMapping(method = RequestMethod.GET, value="/get-complete-link/{shortUrl}")
    String getCompleteShortenLink(@PathVariable String shortUrl);

    @RequestMapping(method = RequestMethod.GET, value="/list/{userId}")
    List<ShortenLink> getAllLinksForUserId(@PathVariable String userId);

    @RequestMapping(method = RequestMethod.DELETE, value="/delete/{id}")
    ResponseValue deleteLink(@PathVariable String id);
}
