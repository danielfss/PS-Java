package br.com.supera.game.store.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.repository.ProductRepository;

@RestController
@RequestMapping
public class ProductController {

//	@Autowired
//	public AppService service;
	
	@Autowired
	public ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> buscarTodos() {
        Iterable<Product> todos = productRepository.findAll();
        return toList(todos);
    }

    public <E> List<E> toList(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
    }

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Optional<Product>> findById(@PathVariable Long id) {
//        Optional<Product> obj = productRepository.findById(id);
//        return ResponseEntity.ok().body(obj);
//    }
    
    
}
