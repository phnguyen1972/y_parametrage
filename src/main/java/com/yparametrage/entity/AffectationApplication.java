package com.yparametrage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "AFFECTATION_APPLICATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AffectationApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plp_id", nullable = false)
    private Plp plp;
    @Column(name = "code_appli", length = 20, nullable = false)
    private String codeAppli;
    @Column(name = "code_client_origine", length = 8, nullable = false)
    private String codeClientOrigine;
    @Column(name = "apa")
    private Boolean apa;
    @Column(name = "date_creation", nullable = false, updatable = false)
    private LocalDateTime dateCreation;
    @Column(name = "date_modification")
    private LocalDateTime dateModification;
    @PrePersist
    protected void onCreate() {
        dateCreation = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate() {
        dateModification = LocalDateTime.now();
    }
}