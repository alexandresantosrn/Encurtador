package com.projeto.encurtador_links.domain.port.out;

import com.projeto.encurtador_links.domain.model.Link;

import java.util.Optional;

public interface LinkRepositoryPort {
    Link salvar(Link link);
    Optional<Link> buscarPorShortUrl(String shortUrl);
}
