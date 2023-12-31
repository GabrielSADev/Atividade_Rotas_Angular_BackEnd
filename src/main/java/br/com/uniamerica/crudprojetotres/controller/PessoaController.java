package br.com.uniamerica.crudprojetotres.controller;
import br.com.uniamerica.crudprojetotres.dto.PessoaDTO;
import br.com.uniamerica.crudprojetotres.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
@CrossOrigin(origins = "http://localhost:4200")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    private ResponseEntity<List<PessoaDTO>> listAll(){
        try {
            List<PessoaDTO> lista = pessoaService.listAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    private ResponseEntity<PessoaDTO> save(@RequestBody PessoaDTO pessoaDTO){
        try {
            PessoaDTO pessoaSalva = pessoaService.save(pessoaDTO);
            return new ResponseEntity<>(pessoaSalva, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    private ResponseEntity<HttpStatus> delete(@RequestParam("id") final Long id){
        try {
                this.pessoaService.excluirPessoa(id);
                return ResponseEntity.ok(HttpStatus.OK);
        }
        catch (Exception e){
                return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("erro")
    private ResponseEntity<List<PessoaDTO>> exemploErro(){
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
