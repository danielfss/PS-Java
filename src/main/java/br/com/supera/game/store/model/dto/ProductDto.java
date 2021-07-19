package br.com.supera.game.store.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.supera.game.store.model.Product;

public class ProductDto {

	private Long id;

	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	@NotEmpty
	private double price;

	@NotNull
	@NotEmpty
	private short score;

	@NotNull
	@NotEmpty
	private String image;

	public ProductDto() {
	}

	public ProductDto(Long id, String name, double price, short score, String image) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.score = score;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public short getScore() {
		return score;
	}

	public void setScore(short score) {
		this.score = score;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public Product toProduct(){
        Product p = new Product();
        p.getId();
        p.getName();
        p.getPrice();
        p.getScore();
        p.getImage();
        return p;
    }


}
