package br.com.uniamerica.crudprojetotres.repository;

import br.com.uniamerica.crudprojetotres.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
