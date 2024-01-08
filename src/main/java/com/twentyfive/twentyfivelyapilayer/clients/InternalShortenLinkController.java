package com.twentyfive.twentyfivelyapilayer.clients;

import com.twentyfive.twentyfivemodel.dto.twentyfiveLyDto.RequestValue;
import com.twentyfive.twentyfivemodel.dto.twentyfiveLyDto.ResponseValue;
import com.twentyfive.twentyfivemodel.models.twentyfiveLyModels.ShortenLink;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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
