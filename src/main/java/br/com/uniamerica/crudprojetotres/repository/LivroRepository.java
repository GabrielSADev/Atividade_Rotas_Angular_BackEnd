package br.com.uniamerica.crudprojetotres.repository;

import br.com.uniamerica.crudprojetotres.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
