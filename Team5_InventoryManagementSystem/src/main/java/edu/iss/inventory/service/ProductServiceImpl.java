package edu.iss.inventory.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.inventory.model.Product;
import edu.iss.inventory.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductRepository prdRepo;

	@Override
	@Transactional
	public ArrayList<Product> findAllProducts() {
		ArrayList<Product> l = (ArrayList<Product>) prdRepo.findAll();
		return l;
	}

	@Override
	@Transactional
	public Product findProducts(String id) {
		Product l = prdRepo.findProductByPartNo(id);
		return l;
	}

	@Override
	@Transactional
	public Product createProduct(Product prd) {
		return prdRepo.saveAndFlush(prd);
	}

	@Override
	@Transactional
	public Product changeProduct(Product prd) {
		return prdRepo.saveAndFlush(prd);
	}

	@Override
	@Transactional
	public void removeProduct(Product prd) {
		prdRepo.delete(prd);
	}

	@Override
	@Transactional
	public ArrayList<Product> searchProduct(Product product) {
		ArrayList<Product> l = new ArrayList<Product>();
		if (product.getPartNo() != null) {
			l.add(prdRepo.findProductByPartNo(product.getPartNo()));
		} else if (product.getCarDealer() != null && product.getColor() != null) {
			l.add(prdRepo.findProductByDealerNColor(product.getColor(), product.getCarDealer()));
		} else {
			l.add(prdRepo.findProductByCarDealer(product.getCarDealer()));
		}
		return l;
	}

}
