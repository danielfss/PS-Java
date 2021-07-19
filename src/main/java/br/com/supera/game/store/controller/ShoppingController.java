package br.com.supera.game.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.supera.game.store.model.ShoppingCart;
import br.com.supera.game.store.repository.ShoppingCartRepository;

@RestController
@RequestMapping("/checkout")
public class ShoppingController {

//	@Autowired
//	public AppService appService;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
    
    @GetMapping
    public ResponseEntity<List<ShoppingCart>> findAll(@RequestParam(required = false) String sortAttribute) {
        List<ShoppingCart> list = shoppingCartRepository.findAll();
        return ResponseEntity.ok().body(list);
    }
    
}
