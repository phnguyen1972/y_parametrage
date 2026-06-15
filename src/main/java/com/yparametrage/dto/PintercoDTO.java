package com.yparametrage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PintercoDTO {
    @NotBlank(message = "idf is required")
    @Size(max = 20)
    private String idf;
    @NotBlank(message = "partenaire is required")
    @Size(max = 20)
    private String partenaire;
    @NotBlank(message = "codeClient is required")
    @Size(max = 20)
    private String codeClient;
    @NotBlank(message = "codeAppliClient is required")
    @Size(max = 20)
    private String codeAppliClient;
    private Integer delaiConservationFichier;
    @Size(max = 30)
    private String workflowYeti;
}