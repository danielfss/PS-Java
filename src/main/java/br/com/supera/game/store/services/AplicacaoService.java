package br.com.supera.game.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public ProductDto addProductInCart(ProductDto productDto) {
		shoppingCart.addItem(productDto.toProduct());
		return productDto;
	}

	public void addItemCart(ShoppingCart shoppingCart) {
		shoppingCartRepository.save(shoppingCart);
	}

	public void deleteItemCart(Long id) {
		shoppingCartRepository.deleteById(id);
	}

}
