package com.yparametrage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PesFichierClientDTO {
    @NotBlank(message = "codeClient is required")
    @Size(max = 20)
    private String codeClient;
    @NotBlank(message = "codeAppliClient is required")
    @Size(max = 20)
    private String codeAppliClient;
    private Integer es;
    private Integer seuil;
    @Size(max = 2)
    private String unite;
    private Integer heureLimiteReception;
}