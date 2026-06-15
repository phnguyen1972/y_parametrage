package com.yparametrage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "FLAG_REGROUPEMENT_REGLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlagRegroupementRegle {
    @EmbeddedId
    private FlagRegroupementReplePK id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flag_regroupement_id", insertable = false, updatable = false)
    private FlagRegroupement flagRegroupement;
    @Column(name = "valeur", length = 200)
    private String valeur;
}