package Diginamic.TP2JPA.Entities;



import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "compo")
public class Compo {
    @EmbeddedId
    private CompoId id;
    private Timestamp delai;

    @ManyToOne
    @MapsId("idLiv")
    @JoinColumn(name = "idLiv")
    private Livre livre;

    @ManyToOne
    @MapsId("idEmp")
    @JoinColumn(name = "idEmp")
    private Emprunt emprunt;

    // Getters and setters
    public CompoId getId() {
        return id;
    }

    public void setId(CompoId id) {
        this.id = id;
    }

    public Timestamp getDelai() {
        return delai;
    }

    public void setDelai(Timestamp delai) {
        this.delai = delai;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Emprunt getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Emprunt emprunt) {
        this.emprunt = emprunt;
    }
}
