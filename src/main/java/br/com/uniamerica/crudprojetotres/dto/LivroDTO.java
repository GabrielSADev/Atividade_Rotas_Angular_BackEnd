package br.com.uniamerica.crudprojetotres.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroDTO {
    private Long id;
    private String titulo;
    private String autor;
}
