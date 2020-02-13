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

import com.myproject.spring.model.ProductCategory;
import com.myproject.spring.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryServiceObj;

	@GetMapping("/api/productcategory/{id}")
	public ResponseEntity<ProductCategory> get(@PathVariable("id") String id) {
		ProductCategory category = categoryServiceObj.get(id);

		return ResponseEntity.ok().body(category);
	}

	@GetMapping("/api/productcategory")
	public ResponseEntity<List<ProductCategory>> getAll() {
		List<ProductCategory> list = categoryServiceObj.getAll();

		return ResponseEntity.ok().body(list);
	}

	@PostMapping("/api/productcategory")
	public ResponseEntity<?> save(@RequestBody ProductCategory category) {
		String id = categoryServiceObj.save(category);

		return ResponseEntity.ok().body("Product Category created with id: " + id);
	}

	@PutMapping("/api/productcategory/{id}")
	public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody ProductCategory category) {
		categoryServiceObj.update(category, id);

		return ResponseEntity.ok().body("Product Category has been updated");
	}

	@DeleteMapping("/api/productcategory/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		categoryServiceObj.delete(id);

		return ResponseEntity.ok().body("Product Category has been deleted");
	}
}