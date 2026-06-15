package com.yparametrage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ENVELOPPE_JDE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnveloppeJde {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "libelle", length = 200)
    private String libelle;
    @Column(name = "format", length = 20)
    private String format;
    @Column(name = "reference", length = 50)
    private String reference;
    @Column(name = "poids")
    private Integer poids;
    @Column(name = "debut_validite", nullable = false)
    private LocalDateTime debutValidite;
    @Column(name = "fin_validite")
    private LocalDateTime finValidite;
    @PrePersist
    protected void onCreate() {
        if (debutValidite == null) debutValidite = LocalDateTime.now();
    }
}