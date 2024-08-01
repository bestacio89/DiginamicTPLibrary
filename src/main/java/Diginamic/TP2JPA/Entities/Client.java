package Diginamic.TP2JPA.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "client")
    List<Emprunt> emprunts = new ArrayList<Emprunt>();

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Emprunt> getEmprunt() {
        return emprunts;
    }

    public void setCompos(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }
}
