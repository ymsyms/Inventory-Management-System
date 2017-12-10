package edu.iss.inventory.service;

import java.util.ArrayList;
import java.util.HashMap;

import edu.iss.inventory.exception.DuplicatePartNumException;
import edu.iss.inventory.exception.MismatchPartNumException;
import edu.iss.inventory.model.OrderDetail;
import edu.iss.inventory.model.Product;
import edu.iss.inventory.model.ProductSupplier;

public interface OrderService {
	public HashMap<Product, ArrayList<ProductSupplier>> getToOrderMap();

	public HashMap<Product, ArrayList<ProductSupplier>> addPartToOrder(Product product,
			HashMap<Product, ArrayList<ProductSupplier>> toOrderMap) throws DuplicatePartNumException;

	public OrderDetail computeQty(Product product, ProductSupplier productSupplier) throws MismatchPartNumException;

	public HashMap<Product, OrderDetail> getAllOrderLowPrice(HashMap<Product, ArrayList<ProductSupplier>> toOrderMap)
			throws MismatchPartNumException;
}
