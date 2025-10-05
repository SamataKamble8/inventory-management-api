package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Products;

@Repository
public interface ProductsRepo extends JpaRepository<Products,Integer> {

	//native query
	@Query(value = "SELECT * FROM products WHERE stock_quantity < :threshold", nativeQuery = true)
	List<Products> findLowStock(@Param("threshold") int threshold);
}
