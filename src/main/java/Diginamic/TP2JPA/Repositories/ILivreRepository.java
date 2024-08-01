package Diginamic.TP2JPA.Repositories;

import Diginamic.TP2JPA.Entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILivreRepository extends JpaRepository<Livre, Integer> {
}