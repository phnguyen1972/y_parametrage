package com.yparametrage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JdeDTO {
    private Integer id;
    @Size(max = 200)
    private String libelle;
    @Size(max = 50)
    private String reference;
    private Integer poids;
    @Size(max = 20)
    private String format;
    private LocalDateTime debutValidite;
    private LocalDateTime finValidite;
}