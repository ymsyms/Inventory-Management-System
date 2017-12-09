package edu.iss.inventory.service;


import java.util.ArrayList;
import java.util.HashSet;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.iss.inventory.exception.DuplicatePartNumException;
import edu.iss.inventory.exception.MismatchPartNumException;
import edu.iss.inventory.model.OrderDetail;
import edu.iss.inventory.model.Product;
import edu.iss.inventory.model.ProductSupplier;
import edu.iss.inventory.repository.OrderRepository;
import edu.iss.inventory.repository.ProductRepository;
import edu.iss.inventory.repository.ProductSupplierRepository;


@Service
public class OrderServiceImpl /* implements OrderService*/{
	
	@Resource
	private OrderRepository orderRepository;
	@Resource
	private ProductRepository productRepository;
	@Resource
	private ProductSupplierRepository productSupplierRepository;

	//Update HashMap with another product and Productsupplier
	@Transactional
	public HashMap<Product,ArrayList<ProductSupplier>> AddPartToOrder(Product product,HashMap<Product,ArrayList<ProductSupplier>> toOrderMap ) throws DuplicatePartNumException {
		if(toOrderMap.get(product) != null) {
			throw new DuplicatePartNumException();
		}
		else {
			toOrderMap.put(product, productSupplierRepository.findProductSupplierByProductId(product.getPartNo()));
		}
		return toOrderMap;
	}

	@Transactional
	public HashMap<Product,ArrayList<ProductSupplier>> getToOrderMap(){
		HashMap<Product,ArrayList<ProductSupplier>> toOrderMap = new HashMap<Product,ArrayList<ProductSupplier>>();
		ArrayList<Product> prodList = productRepository.findProductsToReorder();
		if(!prodList.isEmpty())
		for (Product x : prodList) {
			ArrayList<ProductSupplier> psList = productSupplierRepository.findProductSupplierByProductId(x.getPartNo());
			toOrderMap.put(x,psList);
		}
		return toOrderMap;
	}
	@Transactional
	public OrderDetail computeQty(Product product, ProductSupplier productSupplier) throws MismatchPartNumException {
		if(product.getPartNo().equalsIgnoreCase(productSupplier.getPartNo())) {
			throw new MismatchPartNumException();
		}
		int toOrderQty=0;
		if(product.getAvailableQty()<product.getReorderLevel()) {
			if((productSupplier.getMinimumReorderQty()+product.getAvailableQty())>product.getReorderLevel()) {
				toOrderQty=productSupplier.getMinimumReorderQty()+product.getAvailableQty();
			}
			else {
				toOrderQty=product.getReorderLevel()-product.getAvailableQty()+1;
			}
		}
		OrderDetail a = new OrderDetail(0,product.getPartNo(),toOrderQty);
		return a;
}


