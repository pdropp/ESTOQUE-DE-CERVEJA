package one.digitalinnovation.EstoqueCerveja.REPOSITORY;

import one.digitalinnovation.EstoqueCerveja.ENTITY.Cerveja;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CervejaRepository extends JpaRepository<Cerveja, Long> {

    Optional<Cerveja> FindByName(String nome);

}
