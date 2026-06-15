package com.yparametrage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "COMPTEUR")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "type", length = 20, nullable = false)
    private String type;
    @Column(name = "code", length = 20, nullable = false)
    private String code;
    @Column(name = "deposant", length = 20, nullable = false)
    private String deposant;
    @Column(name = "defaut")
    private Boolean defaut;
    @Column(name = "nature", length = 50)
    private String nature;
    @Column(name = "debut")
    private Long debut;
    @Column(name = "courant")
    private Long courant;
    @Column(name = "fin")
    private Long fin;
    @Column(name = "debut_reserve")
    private Long debutReserve;
    @Column(name = "courant_reserve")
    private Long courantReserve;
    @Column(name = "fin_reserve")
    private Long finReserve;
    @Column(name = "seuil")
    private Long seuil;
    @Column(name = "raz_bouclant")
    private Boolean razBouclant;
    @Column(name = "raz_annee")
    private Boolean razAnnee;
    @Column(name = "annee_init")
    private Integer anneeInit;
    @Column(name = "commentaire", length = 250, nullable = false)
    private String commentaire;
    @Column(name = "date_creation", nullable = false, updatable = false)
    private LocalDateTime dateCreation;
    @Column(name = "date_modification")
    private LocalDateTime dateModification;
    @Column(name = "login_creation", length = 50, nullable = false)
    private String loginCreation;
    @Column(name = "login_modification", length = 50, nullable = false)
    private String loginModification;
    @PrePersist
    protected void onCreate() {
        dateCreation = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate() {
        dateModification = LocalDateTime.now();
    }
}