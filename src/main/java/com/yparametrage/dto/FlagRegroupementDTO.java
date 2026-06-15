package com.yparametrage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlagRegroupementDTO {
    private Integer id;
    @NotBlank(message = "nom is required")
    @Size(max = 20)
    private String nom;
    @Size(max = 200)
    private String libelle;
}