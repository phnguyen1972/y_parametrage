package com.yparametrage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "PINTERCO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pinterco {
    @Id
    @Column(name = "idf", length = 20)
    private String idf;
    @Column(name = "partenaire", length = 20, nullable = false)
    private String partenaire;
    @Column(name = "code_client", length = 20, nullable = false)
    private String codeClient;
    @Column(name = "code_appli_client", length = 20, nullable = false)
    private String codeAppliClient;
    @Column(name = "delai_conservation_fichier")
    private Integer delaiConservationFichier;
    @Column(name = "workflow_yeti", length = 30)
    private String workflowYeti;
}