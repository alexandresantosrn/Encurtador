package com.projeto.encurtador_links.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShortLink {
    private String id;
    private String originalUrl;
    private String shortenedUrl;
    private LocalDateTime createdAt;
}
