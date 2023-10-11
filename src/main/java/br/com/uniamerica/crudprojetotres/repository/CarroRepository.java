package br.com.uniamerica.crudprojetotres.repository;

import br.com.uniamerica.crudprojetotres.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
