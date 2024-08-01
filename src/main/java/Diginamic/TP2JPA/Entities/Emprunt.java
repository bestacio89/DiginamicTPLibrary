package Diginamic.TP2JPA.Entities;



import jakarta.persistence.*;


import java.time.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "emprunt")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    @OneToMany(mappedBy = "emprunt")
    private List<Compo> compos = new ArrayList<>();

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Compo> getCompos() {
        return compos;
    }

    public void setCompos(List<Compo> compos) {
        this.compos = compos;
    }
}
