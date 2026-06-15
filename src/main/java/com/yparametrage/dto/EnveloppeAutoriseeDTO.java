package com.yparametrage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnveloppeAutoriseeDTO {
    private Integer id;
    @NotNull(message = "plpId is required")
    private Integer plpId;
    @NotNull(message = "codePays is required")
    private String codePays;
    @Size(max = 5)
    private String format;
    @NotNull(message = "poidsMin is required")
    private Integer poidsMin;
    private Integer poidsMax;
}