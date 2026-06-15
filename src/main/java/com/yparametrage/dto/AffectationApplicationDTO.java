package com.yparametrage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AffectationApplicationDTO {
    private Integer id;
    @NotNull(message = "plpId is required")
    private Integer plpId;
    @NotBlank(message = "codeAppli is required")
    @Size(max = 20)
    private String codeAppli;
    @NotBlank(message = "codeClientOrigine is required")
    @Size(max = 8)
    private String codeClientOrigine;
    private Boolean apa;
    private LocalDateTime dateCreation;
    private LocalDateTime dateModification;
}