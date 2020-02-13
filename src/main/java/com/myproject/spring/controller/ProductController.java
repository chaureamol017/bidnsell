package com.myproject.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.spring.model.Product;
import com.myproject.spring.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productServiceObj;

	@GetMapping("/api/product/{id}")
	public ResponseEntity<Product> get(@PathVariable("id") String id) {
		Product product = productServiceObj.get(id);

		return ResponseEntity.ok().body(product);
	}

	@GetMapping("/api/product")
	public ResponseEntity<List<Product>> getAll() {
		List<Product> list = productServiceObj.getAll();

		return ResponseEntity.ok().body(list);
	}

	@PostMapping("/api/product")
	public ResponseEntity<?> save(@RequestBody Product product) {
		String id = productServiceObj.save(product);

		return ResponseEntity.ok().body("Product created with id: " + id);
	}

	@PutMapping("/api/product/{id}")
	public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody Product product) {
		productServiceObj.update(product, id);

		return ResponseEntity.ok().body("Product has been updated");
	}

	@DeleteMapping("/api/product/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		productServiceObj.delete(id);

		return ResponseEntity.ok().body("Product has been deleted");
	}
}