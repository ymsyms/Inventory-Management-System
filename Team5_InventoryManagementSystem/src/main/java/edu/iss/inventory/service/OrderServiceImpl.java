package edu.iss.inventory.service;


import java.util.ArrayList;
import java.util.HashMap;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.iss.inventory.exception.DuplicatePartNumException;
import edu.iss.inventory.model.OrderDetail;
import edu.iss.inventory.model.Product;
import edu.iss.inventory.repository.OrderRepository;
import edu.iss.inventory.repository.ProductRepository;


@Service
public class OrderServiceImpl /* implements OrderService*/{
	
	@Resource
	private OrderRepository orderRepository;
	@Resource
	private ProductRepository productRepository;

	//Update HashMap of order details with another orderDetail
	@Transactional
	public HashMap<Product,Integer> AddPartOrder(Product product,HashMap<Product,Integer> orderDetailMap ) throws DuplicatePartNumException {
		if(orderDetailMap.get(product) != null) {
			throw new DuplicatePartNumException();
		}
		else {
			orderDetailMap.put(product, 0);
		}
		return orderDetailMap;
	}
	
	/*@Transactional
	public HashMap<String,Integer> getOrderDetailMap(){
		HashMap<String,Integer> orderDetail = new HashMap<String,Integer>();
		ArrayList<Product> prodList = productRepository.findProductsToReorder();
		if(!prodList.isEmpty())
		for (Product x : prodList) {
			for(int i= x.)
			orderDetail.put(x.getPartNo(), x.)
		}
	}*/
}


