package br.com.uniamerica.crudprojetotres.service;

import br.com.uniamerica.crudprojetotres.dto.LivroDTO;
import br.com.uniamerica.crudprojetotres.entity.Livro;
import br.com.uniamerica.crudprojetotres.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroDTO> listAll(){
        List<Livro> lista = livroRepository.findAll();
        List<LivroDTO> listaDTO = new ArrayList<>();

        for (int i = 0; i<lista.size(); i++)
            listaDTO.add(this.toLivroDTO(lista.get(i)));

        return listaDTO;
    }

    public LivroDTO save(LivroDTO livroDTO){
        Livro livro = this.toLivro(livroDTO);
        Livro livrosalvo = livroRepository.save(livro);

        return this.toLivroDTO(livrosalvo);
    }

    private LivroDTO toLivroDTO(Livro livro){
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(livro.getId());
        livroDTO.setAutor(livro.getAutor());
        livroDTO.setTitulo(livro.getTitulo());
        return livroDTO;
    }

    private Livro toLivro(LivroDTO livroDTO){
        Livro livro = new Livro();
        livro.setId(livroDTO.getId());
        livro.setAutor(livroDTO.getAutor());
        livro.setTitulo(livroDTO.getTitulo());
        return livro;
    }

    public void excluirLivro(final long id){
        final Livro livroBanco = this.livroRepository.findById(id).orElse(null);

        this.livroRepository.delete(livroBanco);
    }

}
