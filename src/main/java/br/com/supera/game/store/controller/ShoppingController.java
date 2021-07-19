package br.com.supera.game.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.supera.game.store.model.ShoppingCart;
import br.com.supera.game.store.model.dto.ProductDto;
import br.com.supera.game.store.repository.ShoppingCartRepository;
import br.com.supera.game.store.services.AplicacaoService;

@RestController
@RequestMapping("/checkout")
public class ShoppingController {

	@Autowired
	public AplicacaoService appService;

	public ShoppingCart shoppingCart;

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

//	@GetMapping
//	public ResponseEntity<List<ShoppingCart>> findAll(@RequestParam(required = false) String sortAttribute) {
//		List<ShoppingCart> list = shoppingCartRepository.findAll();
//		return ResponseEntity.ok().body(list);
//	}
	
	@GetMapping
    public ResponseEntity<?> itemsCart(){
        return new ResponseEntity<>(appService.startCart(), HttpStatus.OK);
    }

    @PostMapping("/checkout")
    public ResponseEntity<?> addProductOnCart(@RequestBody ProductDto productDto) {
    	appService.addProductInCart(productDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//	@RequestMapping(value = "/checkout/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
//	public String deletaDoCarrinho(@PathVariable (value ="id") Long id) {
//		appService.deleteItemCart(id);
//		return "checkout";
//		
//	}

}
