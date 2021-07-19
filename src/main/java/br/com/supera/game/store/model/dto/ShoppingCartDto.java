package br.com.supera.game.store.model.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.supera.game.store.model.Product;

public class ShoppingCartDto {

	private Long id;
	private double shipping;
	private double total;
	private double subtotal;
	private Integer productQuantity = 0;

	private List<ProductDto> products = new ArrayList<>();

	public void addItem(Product item) {
		this.subtotal += item.getPrice();
		this.shipping = this.calcFrete();
		this.total = this.calcTotal();
	}

	private double calcTotal() {
		return this.subtotal + this.shipping;
	}

	private double calcFrete() {
		if (this.subtotal >= 250)
			return 0;
		else
			return this.products.size() * 10;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getShipping() {
		return shipping;
	}

	public void setShipping(double shipping) {
		this.shipping = shipping;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	public List<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}

}
