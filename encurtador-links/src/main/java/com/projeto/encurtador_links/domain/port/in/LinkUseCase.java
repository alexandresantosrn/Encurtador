package com.projeto.encurtador_links.domain.port.in;

import com.projeto.encurtador_links.domain.model.Link;

public interface LinkUseCase {
    Link encurtarLink(String originalUrl);
    String buscarOriginalUrl(String shortUrl);
}
