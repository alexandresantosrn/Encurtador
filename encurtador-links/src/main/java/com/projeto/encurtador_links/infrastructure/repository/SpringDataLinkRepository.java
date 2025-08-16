package com.projeto.encurtador_links.infrastructure.repository;

import com.projeto.encurtador_links.infrastructure.persistence.LinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataLinkRepository extends JpaRepository<LinkEntity, Long> {
    LinkEntity findByShortUrl(String shortUrl);
}
