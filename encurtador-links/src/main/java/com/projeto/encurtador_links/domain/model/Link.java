package com.projeto.encurtador_links.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private String id;
    private String originalUrl;
    private String shortUrl;
    private LocalDateTime createdAt;
}
