package com.yparametrage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "PLP")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "plp_libelle", length = 50, nullable = false)
    private String plpLibelle;
    @Column(name = "type_compteur", length = 20, nullable = false)
    private String typeCompteur;
    @Column(name = "rep_out", length = 20, nullable = false)
    private String repOut;
    @Column(name = "plp_top", length = 250, nullable = false)
    private String plpTop;
    @Column(name = "commentaire", length = 250, nullable = false)
    private String commentaire;
    @Column(name = "date_creation", nullable = false, updatable = false)
    private LocalDateTime dateCreation;
    @Column(name = "date_modification")
    private LocalDateTime dateModification;
    @OneToMany(mappedBy = "plp", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AffectationApplication> affectationApplications;
    @OneToMany(mappedBy = "plp", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnveloppeAutorisee> enveloppeAutorisees;
    @PrePersist
    protected void onCreate() {
        dateCreation = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate() {
        dateModification = LocalDateTime.now();
    }
}