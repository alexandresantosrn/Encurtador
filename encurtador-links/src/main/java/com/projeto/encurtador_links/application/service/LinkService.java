package com.projeto.encurtador_links.application.service;

import com.projeto.encurtador_links.domain.model.Link;
import com.projeto.encurtador_links.domain.port.in.LinkUseCase;
import com.projeto.encurtador_links.domain.port.out.LinkRepositoryPort;

import java.time.LocalDateTime;
import java.util.UUID;

public class LinkService implements LinkUseCase {

    private final LinkRepositoryPort linkRepository;

    public LinkService(LinkRepositoryPort linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public Link encurtarLink(String originalUrl) {
        String shortCode = UUID.randomUUID().toString().substring(0, 6);
        Link link = new Link(null, originalUrl, shortCode, LocalDateTime.now());
        return linkRepository.salvar(link);
    }

    @Override
    public String buscarOriginalUrl(String shortUrl) {
        return linkRepository.buscarPorShortUrl(shortUrl)
                .map(Link::getOriginalUrl)
                .orElseThrow(() -> new RuntimeException("Link não encontrado"));
    }
}
