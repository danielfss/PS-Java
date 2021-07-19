package br.com.supera.game.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.supera.game.store.model.Product;
import br.com.supera.game.store.model.ShoppingCart;
import br.com.supera.game.store.model.dto.ProductDto;
import br.com.supera.game.store.repository.ProductRepository;
import br.com.supera.game.store.repository.ShoppingCartRepository;


@Service
public class AplicacaoService {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@Autowired
	private ProductRepository productRepository;

	private ShoppingCart shoppingCart;

	@Autowired
	public AplicacaoService(ProductRepository repository) {
		this.productRepository = repository;
		this.shoppingCart = new ShoppingCart();
	}

	// PRODUTO

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public void addProduct(Product product) {
		productRepository.save(product);
	}

	// CARRINHO
	public ShoppingCart startCart() {
		return this.shoppingCart = new ShoppingCart();
	}

	public ProductDto addProductInCart(ProductDto productDto) {
		validateProduct(productDto);
		shoppingCart.addItem(productDto.toProduct());
		shoppingCart.calcFrete();
		shoppingCart.calcTotal();
		return productDto;
	}
	
	public void validateProduct(ProductDto productDto) {
        Optional<Product> validateProducts = productRepository.findById(productDto.getId());
        if (validateProducts.equals(Optional.ofNullable(null))){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
    }

//	public void addItemCart(ShoppingCart shoppingCart) {
//		shoppingCartRepository.save(shoppingCart);
//	}

	public void deleteItemCart(Long id) {
		shoppingCartRepository.deleteById(id);
	}

}
