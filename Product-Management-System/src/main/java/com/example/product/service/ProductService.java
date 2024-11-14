package com.example.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.product.entity.ProductEntity;
import com.example.product.repository.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	public void addProduct(ProductEntity product) {
		
		productRepository.addProduct(product);
		
	}

	public List<ProductEntity> findAllProduct() {
		
		return productRepository.findAllProducts();
	}

	public void deleteProduct(int productId) {
		productRepository.deleteProduct(productId);
		
	}

	public ProductEntity findProduct(int productId) {
	
	return productRepository.findProduct(productId);
		
	}

	public void finalUpdate(ProductEntity product) {
		
		productRepository.finalUpdate(product);
		
	}

}
