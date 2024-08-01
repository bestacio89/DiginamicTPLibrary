package Diginamic.TP2JPA.Entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompoId implements Serializable {
    private int idLiv;
    private int idEmp;

    // Getters and setters
    public int getIdLiv() {
        return idLiv;
    }

    public void setIdLiv(int idLiv) {
        this.idLiv = idLiv;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    // Override equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompoId compoId = (CompoId) o;
        return idLiv == compoId.idLiv && idEmp == compoId.idEmp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLiv, idEmp);
    }
}
