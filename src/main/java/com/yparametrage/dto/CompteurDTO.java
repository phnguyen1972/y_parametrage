package com.yparametrage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteurDTO {
    private Integer id;
    @NotBlank(message = "type is required")
    @Size(max = 20)
    private String type;
    @NotBlank(message = "code is required")
    @Size(max = 20)
    private String code;
    @NotBlank(message = "deposant is required")
    @Size(max = 20)
    private String deposant;
    private Boolean defaut;
    private String nature;
    private Long debut;
    private Long courant;
    private Long fin;
    private Long debutReserve;
    private Long courantReserve;
    private Long finReserve;
    private Long seuil;
    private Boolean razBouclant;
    private Boolean razAnnee;
    private Integer anneeInit;
    @NotBlank(message = "commentaire is required")
    @Size(max = 250)
    private String commentaire;
    @NotBlank(message = "loginCreation is required")
    @Size(max = 50)
    private String loginCreation;
    @NotBlank(message = "loginModification is required")
    @Size(max = 50)
    private String loginModification;
    private LocalDateTime dateCreation;
    private LocalDateTime dateModification;
}