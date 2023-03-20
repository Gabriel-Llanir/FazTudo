package br.com.fiap.appservico.Controllers;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.appservico.Models.Prestador;
import br.com.fiap.appservico.Utils.Verifica;

// classe de controle para teste da classe Prestador
@RestController
public class PrestadorController extends Verifica {

    // construção de um array de Prestadores
    ArrayList<Prestador> prestadores = new ArrayList<Prestador>();

    // construção de um log
    Logger log = new LoggerFactory.getLogger(PrestadorController.class);

    //---------------------------------
// função de mapeamento para colocar, na aplicação, uma página que exibe o perfil do usuário
    @GetMapping("/Perfil/{id}")
    public ResponseEntity<Prestador> perfil(@PathVariable Long id){
        var prestador = prestadores
                .stream()
                .filter(d -> d.getId().equals(id))
                .findFirst();

        if(prestador.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prestador.get());
    }

    // função de mapeamento para colocar, na aplicação, uma função para atualizar o perfil do usuário
    @PutMapping("/Perfil/{id}")
    public ResponseEntity<Prestador> perfilPut(@PathVariable Long id, @RequestBody Prestador prestador) {
        var prestadorExistente = prestadores
                .stream()
                .filter(d -> d.getId().equals(id))
                .findFirst();

        if(prestadorExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        prestador.setId(id);
        prestadores.remove(prestadorExistente.get());
        prestadores.add(prestador);

        return ResponseEntity.ok(prestador);
    }

    // função de mapeamento para colocar, na aplicação, uma função que deleta o perfil do usuário
    @DeleteMapping("/Perfil/{id}")
    public ResponseEntity<Prestador> perfilDel(@PathVariable Long id){
        var prestador = prestadores
                .stream()
                .filter(d -> d.getId().equals(id))
                .findFirst();

        if(prestador.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        prestadores.remove(prestador.get());
        return ResponseEntity.noContent().build();
    }

    //---------------------------------

    // função de mapeamento para colocar, na aplicação, uma página de login do usuário
    @GetMapping("/Login/{id}")
    public ResponseEntity<Prestador> login(@PathVariable Long id){
        var prestador = prestadores
                .stream()
                .filter(d -> d.getId().equals(id))
                .findFirst();

        if(prestador.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(prestador.get());
    }

    // função de mapeamento para colocar, na aplicação, uma página de registro do usuário
    @PostMapping("/Registro")
    public ResponseEntity<Prestador> registro(@RequestBody Prestador prestador){
        if (verficacpf(prestador.getcpf()) && verificaIdade(prestador.getIdade())){
            log.info("Registrando usuário: "+prestador);
            prestadores.add(prestador);
            return ResponseEntity.status(HttpStatus.CREATED).body(prestador);
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }


}
