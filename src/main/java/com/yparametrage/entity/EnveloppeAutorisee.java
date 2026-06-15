package com.yparametrage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "ENVELOPPE_AUTORISEE_PLP")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnveloppeAutorisee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plp_id", nullable = false)
    private Plp plp;
    @Column(name = "code_pays", nullable = false)
    @Enumerated(EnumType.STRING)
    private CodePays codePays;
    @Column(name = "format", length = 5)
    private String format;
    @Column(name = "poids_min", nullable = false)
    private Integer poidsMin;
    @Column(name = "poids_max")
    private Integer poidsMax;
    public enum CodePays {
        FR, GP, MQ, GF, RE, YT, PM, BL, MF, WF, PF, NC, XX
    }
}