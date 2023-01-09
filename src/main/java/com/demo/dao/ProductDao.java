package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> viewProducts();

	boolean addProduct(int pid, String pname, int qty, double price);

	Product getProduct(int pid);

	boolean deleteProduct(int pid);

	

}
