package br.com.uniamerica.crudprojetotres.service;

import br.com.uniamerica.crudprojetotres.dto.PessoaDTO;
import br.com.uniamerica.crudprojetotres.entity.Pessoa;
import br.com.uniamerica.crudprojetotres.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaDTO> listAll(){
        List<Pessoa> lista = pessoaRepository.findAll();
        List<PessoaDTO> listaDTO = new ArrayList<>();

        for (int i = 0; i<lista.size(); i++)
            listaDTO.add(this.toPessoaDTO(lista.get(i)));

        return listaDTO;
    }

    public PessoaDTO save(PessoaDTO pessoaDTO){
        Pessoa pessoa = this.toPessoa(pessoaDTO);

        Pessoa pessoasalva = pessoaRepository.save(pessoa);

        return this.toPessoaDTO(pessoasalva);
    }


    private PessoaDTO toPessoaDTO(Pessoa pessoa) {
        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setId(pessoa.getId());
        pessoaDTO.setNome(pessoa.getNome());
        pessoaDTO.setIdade(pessoa.getIdade());
        return pessoaDTO;
    }

    private Pessoa toPessoa(PessoaDTO pessoaDTO) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(pessoaDTO.getId());
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setIdade(pessoaDTO.getIdade());
        return pessoa;
    }
}
