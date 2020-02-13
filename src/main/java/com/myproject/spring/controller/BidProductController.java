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

import com.myproject.spring.model.BidProduct;
import com.myproject.spring.service.BidProductService;

@RestController
public class BidProductController {
	@Autowired
	private BidProductService bidProductServiceObj;

	@GetMapping("/api/bidproduct/{id}")
	public ResponseEntity<BidProduct> get(@PathVariable("id") String id) {
		BidProduct product = bidProductServiceObj.get(id);

		return ResponseEntity.ok().body(product);
	}

	@GetMapping("/api/bidproduct")
	public ResponseEntity<List<BidProduct>> getAll() {
		List<BidProduct> list = bidProductServiceObj.getAll();

		return ResponseEntity.ok().body(list);
	}

	@PostMapping("/api/bidproduct")
	public ResponseEntity<?> save(@RequestBody BidProduct bid) {
		String id = bidProductServiceObj.save(bid);

		return ResponseEntity.ok().body("Bid created with id: " + id);
	}

	@PutMapping("/api/bidproduct/{id}")
	public ResponseEntity<?> update(@PathVariable("id") String id, @RequestBody BidProduct bid) {
		bidProductServiceObj.update(bid, id);

		return ResponseEntity.ok().body("Bid has been updated");
	}

	@DeleteMapping("/api/bidproduct/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		bidProductServiceObj.delete(id);

		return ResponseEntity.ok().body("Bid has been deleted");
	}
}