package com.projeto.encurtador_links.infrastructure.persistence;

import com.projeto.encurtador_links.domain.model.Link;
import com.projeto.encurtador_links.domain.port.out.LinkRepositoryPort;
import com.projeto.encurtador_links.infrastructure.repository.SpringDataLinkRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LinkRepositoryAdapter implements LinkRepositoryPort {

    private final SpringDataLinkRepository springDataLinkRepository;

    public LinkRepositoryAdapter(SpringDataLinkRepository springDataLinkRepository) {
        this.springDataLinkRepository = springDataLinkRepository;
    }

    @Override
    public Link salvar(Link link) {
        LinkEntity entity = new LinkEntity();
        entity.setOriginalUrl(link.getOriginalUrl());
        entity.setShortUrl(link.getShortUrl());
        entity.setCreatedAt(link.getCreatedAt());
        LinkEntity savedEntity = springDataLinkRepository.save(entity);
        return new Link(savedEntity.getId(), savedEntity.getOriginalUrl(), savedEntity.getShortUrl(),
                savedEntity.getCreatedAt());
    }

    @Override
    public Optional<Link> buscarPorShortUrl(String shortUrl) {
        return null;
        /*return springDataLinkRepository.findByShortUrl(shortUrl)
                .map(entity -> new Link(entity.getId(), entity.getOriginalUrl(), entity.getShortUrl(),
                        entity.getCreatedAt()));*/
    }
}
