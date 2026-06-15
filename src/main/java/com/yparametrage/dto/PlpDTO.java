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
public class PlpDTO {
    private Integer id;
    @NotBlank(message = "plpLibelle is required")
    @Size(max = 50)
    private String plpLibelle;
    @NotBlank(message = "typeCompteur is required")
    @Size(max = 20)
    private String typeCompteur;
    @NotBlank(message = "repOut is required")
    @Size(max = 20)
    private String repOut;
    @NotBlank(message = "plpTop is required")
    @Size(max = 250)
    private String plpTop;
    @NotBlank(message = "commentaire is required")
    @Size(max = 250)
    private String commentaire;
    private LocalDateTime dateCreation;
    private LocalDateTime dateModification;
}