package br.com.impacta.lab.controller;

import br.com.impacta.lab.models.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    //http://localhost:8080/produtos
    public static List<Produto> bancoDeDados = new ArrayList<>();

    @PostMapping("")
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        bancoDeDados.add(produto);

        return ResponseEntity.ok(produto);
    }

    @GetMapping("")
    public ResponseEntity<List<Produto>> consultarProdutos() {
        return ResponseEntity.ok(bancoDeDados);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Produto> alterarProduto(@PathVariable("codigo") int codigo,
                                                       @RequestBody Produto newProduto) {

        for (int contador = 0; contador < bancoDeDados.size(); contador++) {
            Produto produto = bancoDeDados.get(contador);
            if (produto.getCodigo() == codigo) {
                produto.setValor(newProduto.getValor());
                produto.setDescricao(newProduto.getDescricao());

                return ResponseEntity.ok(produto);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Produto> deletarProduto(@PathVariable("codigo") int codigo) {

        for (int contador = 0; contador < bancoDeDados.size(); contador++) {
            Produto produto = bancoDeDados.get(contador);
            if (produto.getCodigo() == codigo) {
                bancoDeDados.remove(contador);
                return ResponseEntity.ok(produto);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> consultarProdutoPorCodigo(@PathVariable("codigo") int codigo) {

        for (int contador = 0; contador < bancoDeDados.size(); contador++) {
            Produto produto = bancoDeDados.get(contador);
            if (produto.getCodigo() == codigo) {
                return ResponseEntity.ok(produto);
            }
        }
        return ResponseEntity.noContent().build();

    }

}
