package Diginamic.TP2JPA.Entities;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livre")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titre;
    private String auteur;

    @OneToMany(mappedBy = "livre")
    private List<Compo> compos = new ArrayList<>();

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public List<Compo> getCompos() {
        return compos;
    }

    public void setCompos(List<Compo> compos) {
        this.compos = compos;
    }
}
