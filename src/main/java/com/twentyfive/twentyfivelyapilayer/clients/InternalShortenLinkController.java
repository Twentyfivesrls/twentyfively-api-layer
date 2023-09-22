package com.twentyfive.twentyfivelyapilayer.clients;

import com.twentyfive.twentyfivemodel.dto.twentyfiveLyDto.RequestValue;
import com.twentyfive.twentyfivemodel.dto.twentyfiveLyDto.ResponseValue;
import com.twentyfive.twentyfivemodel.models.twentyfiveLyModels.ShortenLink;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "InternalShortenLinkController",
        url = "http://tomcat-twentyfive-db:8091/twentyfive-db/shorten-link")
public interface InternalShortenLinkController {

    @RequestMapping(method = RequestMethod.POST, value="/generate")
    ResponseValue generateShortenLink(@RequestBody RequestValue requestValue, @RequestParam("username") String username);

    @RequestMapping(method = RequestMethod.GET, value="/get-complete-link/{shortUrl}")
    List<ShortenLink> getCompleteShortenLink(@PathVariable String shortUrl);

    @RequestMapping(method = RequestMethod.GET, value="/list/{userId}")
    List<ShortenLink> getAllLinksForUserId(@PathVariable String userId);

    @RequestMapping(method = RequestMethod.GET, value="/delete/{id}")
    ResponseValue deleteLink(@PathVariable String id);
}
