package com.projeto.encurtador_links.infrastructure.web;

import com.projeto.encurtador_links.application.service.LinkService;
import com.projeto.encurtador_links.domain.model.Link;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/links")
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping
    public Link encurtarLink(@RequestBody String originalUrl) {
        return linkService.encurtarLink(originalUrl);
    }

    @GetMapping("/{shortUrl}")
    public String buscarOriginalUrl(@PathVariable String shortUrl) {
        return linkService.buscarOriginalUrl(shortUrl);
    }
}
