package Diginamic.TP2JPA.Repositories;

import Diginamic.TP2JPA.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository extends JpaRepository<Client, Integer> {
}
