package com.example.url_aliaser.DTOs;

import com.example.url_aliaser.models.Alias;

public record AliasDTO(String url, String alias, Long id, int hitCount) {
    public AliasDTO(Alias alias){
        this(alias.getLink().getUrl(), alias.getAlias(),alias.getId(),alias.getHitCount());
    }

}
