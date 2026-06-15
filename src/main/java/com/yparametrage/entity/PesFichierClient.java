package com.yparametrage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "PES_FICHIER_CLIENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PesFichierClient {
    @Id
    @Column(name = "code_client", length = 20)
    private String codeClient;
    @Column(name = "code_appli_client", length = 20, nullable = false)
    private String codeAppliClient;
    @Column(name = "es")
    private Integer es;
    @Column(name = "seuil")
    private Integer seuil;
    @Column(name = "unite", length = 2)
    private String unite;
    @Column(name = "heure_limite_reception")
    private Integer heureLimiteReception;
}