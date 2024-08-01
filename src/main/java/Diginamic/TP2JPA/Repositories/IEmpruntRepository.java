package Diginamic.TP2JPA.Repositories;

import Diginamic.TP2JPA.Entities.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpruntRepository extends JpaRepository<Emprunt, Integer> {
}
