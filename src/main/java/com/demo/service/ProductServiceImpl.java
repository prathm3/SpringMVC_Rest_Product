package com.demo.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
   private ProductDao pdao;

	public List<Product> viewProducts() {
		// TODO Auto-generated method stub
		return pdao.viewProducts();
	}

	public boolean addProduct(int pid, String pname, int qty, double price) {
		// TODO Auto-generated method stub
		return pdao.addProduct(pid, pname, qty, price);
	}

	public Product getProduct(int pid) {
		// TODO Auto-generated method stub
		return pdao.getProduct(pid);
	}

	public boolean deleteProduct(int pid) {
		// TODO Auto-generated method stub
		return pdao.deleteProduct(pid);
	}
   

}
