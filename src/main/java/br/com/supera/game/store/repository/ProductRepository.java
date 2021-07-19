package br.com.supera.game.store.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.supera.game.store.model.Product;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findById(long id);
}