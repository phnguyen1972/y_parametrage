package com.yparametrage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopDiagDTO {
    @NotNull(message = "id is required")
    private Integer id;
    @NotNull(message = "plpId is required")
    private Integer plpId;
    @NotBlank(message = "topArchiver is required")
    @Size(max = 250)
    private String topArchiver;
    @NotBlank(message = "topNettoyer is required")
    @Size(max = 250)
    private String topNettoyer;
    @NotBlank(message = "topNettoyerManu is required")
    @Size(max = 250)
    private String topNettoyerManu;
    @NotBlank(message = "topChangerDateLiberation is required")
    @Size(max = 250)
    private String topChangerDateLiberation;
    @NotBlank(message = "topCalculerTachesPlanifiees is required")
    @Size(max = 250)
    private String topCalculerTachesPlanifiees;
    @NotBlank(message = "topIntegrer is required")
    @Size(max = 250)
    private String topIntegrer;
    @NotBlank(message = "topRegrouper is required")
    @Size(max = 250)
    private String topRegrouper;
    @NotBlank(message = "topLiberer is required")
    @Size(max = 250)
    private String topLiberer;
    @NotBlank(message = "topExtraire is required")
    @Size(max = 250)
    private String topExtraire;
    @NotBlank(message = "topMassifier is required")
    @Size(max = 250)
    private String topMassifier;
}