package com.yparametrage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "TOP_DIAG")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopDiag {
    @Id
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plp_id", nullable = false)
    private Plp plp;
    @Column(name = "top_archiver", length = 250, nullable = false)
    private String topArchiver;
    @Column(name = "top_nettoyer", length = 250, nullable = false)
    private String topNettoyer;
    @Column(name = "top_nettoyer_manu", length = 250, nullable = false)
    private String topNettoyerManu;
    @Column(name = "top_changer_date_liberation", length = 250, nullable = false)
    private String topChangerDateLiberation;
    @Column(name = "top_calculer_taches_planifiees", length = 250, nullable = false)
    private String topCalculerTachesPlanifiees;
    @Column(name = "top_integrer", length = 250, nullable = false)
    private String topIntegrer;
    @Column(name = "top_regrouper", length = 250, nullable = false)
    private String topRegrouper;
    @Column(name = "top_liberer", length = 250, nullable = false)
    private String topLiberer;
    @Column(name = "top_extraire", length = 250, nullable = false)
    private String topExtraire;
    @Column(name = "top_massifier", length = 250, nullable = false)
    private String topMassifier;
}