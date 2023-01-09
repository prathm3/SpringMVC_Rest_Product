package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.Product;
import com.demo.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public ResponseEntity<List<Product>> viewProducts() {
		
		List<Product> plist = productService.viewProducts();
		
		
		return  ResponseEntity.ok(plist);
	}
	@PostMapping("/add")
	public ResponseEntity<String> addProduct(@RequestParam("pid") int pid, @RequestParam("pname") String pname, @RequestParam("qty") int qty, @RequestParam("price") double price) {
		boolean added = productService.addProduct(pid, pname, qty, price);
		if(added) {
			return new ResponseEntity(HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/editProduct/{pid}")
	public ResponseEntity<Product> updateProduct(@PathVariable("pid") int pid) {
		Product p = productService.getProduct(pid);
		if(p != null) {
			return  ResponseEntity.ok(p);
		}
		return null;
	
	}
	@GetMapping("/deleteProduct/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable("pid") int pid) {
		boolean p = productService.deleteProduct(pid);
		if(p) {
			return new ResponseEntity(HttpStatus.OK);
		}else {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	

}
