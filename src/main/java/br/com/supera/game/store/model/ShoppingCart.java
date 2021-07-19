package br.com.supera.game.store.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private double shipping;
	private double subtotal;
	private double total;

	@OneToMany()
	private List<Product> products = new ArrayList<>();

	public ShoppingCart() {
		this.products = new ArrayList<>();
		this.shipping = 0.0;
		this.subtotal = 0.0;
		this.total = 0.0;
	}
	
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getShipping() {
		return shipping;
	}

	public void setShipping(double shipping) {
		this.shipping = shipping;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
