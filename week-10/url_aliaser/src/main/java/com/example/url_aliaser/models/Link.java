package com.example.url_aliaser.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Link {

    @Id
    @GeneratedValue
    private Long id;
    private String url;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "link", fetch = FetchType.EAGER)
    private List<Alias> aliasList = new ArrayList<>();

    public Link(String url) {
        this.url = url;
    }
}
