package br.com.uniamerica.crudprojetotres.controller;

import br.com.uniamerica.crudprojetotres.dto.LivroDTO;
import br.com.uniamerica.crudprojetotres.dto.PessoaDTO;
import br.com.uniamerica.crudprojetotres.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livro")
@CrossOrigin(origins = "http://localhost:4200")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    private ResponseEntity<List<LivroDTO>> listAll(){
        try {
            List<LivroDTO> lista = livroService.listAll();
            return new ResponseEntity<>(lista,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    private ResponseEntity<LivroDTO> save(@RequestBody LivroDTO livroDTO){
        try {
            LivroDTO livroSalvo = livroService.save(livroDTO);
            return new ResponseEntity<>(livroSalvo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping
    private ResponseEntity<HttpStatus> delete(@RequestParam("id") final Long id){
        try {
            this.livroService.excluirLivro(id);
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
