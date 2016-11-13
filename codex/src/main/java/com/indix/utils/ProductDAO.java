package com.indix.utils;

import java.util.List;

import com.indix.Model.Product;

/**
 * Defines DAO operations for the contact model.
 * 
 * @author www.codejava.net
 *
 */
public interface ProductDAO {

	
	public Product get(int pid);

	public List<Product> list();
}