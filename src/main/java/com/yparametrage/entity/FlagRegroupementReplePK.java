package com.yparametrage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlagRegroupementReplePK implements Serializable {
    @Column(name = "flag_regroupement_id")
    private Integer flagRegroupementId;
    @Column(name = "cle", length = 50)
    private String cle;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlagRegroupementReplePK that = (FlagRegroupementReplePK) o;
        return Objects.equals(flagRegroupementId, that.flagRegroupementId) &&
               Objects.equals(cle, that.cle);
    }
    @Override
    public int hashCode() {
        return Objects.hash(flagRegroupementId, cle);
    }
}