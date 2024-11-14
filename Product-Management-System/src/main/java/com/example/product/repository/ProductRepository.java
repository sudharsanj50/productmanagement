package com.example.product.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.product.entity.ProductEntity;

@Repository
public class ProductRepository {

	private final EntityManagerFactory factory;

	public ProductRepository(EntityManagerFactory factory) {
		super();
		this.factory = factory;
	}

	public void addProduct(ProductEntity product) {
		EntityManager manager=factory.createEntityManager();

		EntityTransaction transaction= manager.getTransaction();

		transaction.begin();
		manager.persist(product);
		transaction.commit();

		manager.close();

	}

	public List<ProductEntity> findAllProducts() {
		EntityManager manager=factory.createEntityManager();

//		EntityTransaction transaction= manager.getTransaction();

		TypedQuery<ProductEntity> query= manager.createQuery("FROM ProductEntity",ProductEntity.class);
        List<ProductEntity> list=query.getResultList();
		manager.close();
		
		return list;
	}

	public void deleteProduct(int productId) {
		EntityManager manager=factory.createEntityManager();
		
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.remove(manager.find(ProductEntity.class, productId));
		transaction.commit();
		manager.close();
	}

	public ProductEntity findProduct(int productId) {
		
		EntityManager manager=factory.createEntityManager();

		EntityTransaction transaction= manager.getTransaction();

		transaction.begin();
		ProductEntity product=  manager.find(ProductEntity.class,productId);
		transaction.commit();

		manager.close();
		return product;

	}

	public void finalUpdate(ProductEntity products) {
		EntityManager manager=factory.createEntityManager();

		EntityTransaction transaction= manager.getTransaction();

		transaction.begin();
		manager.merge(products);
		transaction.commit();

		manager.close();

		
	}

}
