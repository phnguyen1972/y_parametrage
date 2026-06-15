package com.yparametrage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FLAG_REGROUPEMENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlagRegroupement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nom", length = 20, unique = true)
    private String nom;
    @Column(name = "libelle", length = 200)
    private String libelle;
    @OneToMany(mappedBy = "flagRegroupement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FlagRegroupementRegle> regles;
}