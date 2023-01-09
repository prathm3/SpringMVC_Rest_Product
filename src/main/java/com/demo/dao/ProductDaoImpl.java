package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Product> viewProducts() {
		List<Product> plist = jdbcTemplate.query("select * from product", BeanPropertyRowMapper.newInstance(Product.class));
		return plist;
	}

	public boolean addProduct(int pid, String pname, int qty, double price) {
		int n1 = jdbcTemplate.update("delete from product where pid=?" , new Object[] {pid});
		int n = jdbcTemplate.update("insert into product values(?,?,?,?)",
				new Object[] {pid,pname,qty,price});
		return n > 0;
	}

	public Product getProduct(int pid) {
		Product p = jdbcTemplate.queryForObject("select * from product where pid=?", new Object[] {pid}, BeanPropertyRowMapper.newInstance(Product.class));
		return p;
	}

	public boolean deleteProduct(int pid) {
		int n = jdbcTemplate.update("delete from product where pid=?" , new Object[] {pid});
		return n>0;
	}
	

}
