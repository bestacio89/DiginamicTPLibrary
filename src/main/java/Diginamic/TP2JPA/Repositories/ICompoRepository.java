package Diginamic.TP2JPA.Repositories;
import Diginamic.TP2JPA.Entities.Compo;
import Diginamic.TP2JPA.Entities.CompoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompoRepository extends JpaRepository<Compo, CompoId> {
}