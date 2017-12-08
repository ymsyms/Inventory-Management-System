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

	/* (non-Javadoc)
	 * @see edu.iss.inventory.service.ProductService#findAllProducts()
	 */
	@Override
	@Transactional
	public ArrayList<Product> findAllProducts() {
		ArrayList<Product> l = (ArrayList<Product>) prdRepo.findAll();
		return l;
	}
	
	/* (non-Javadoc)
	 * @see edu.iss.inventory.service.ProductService#findProduct(java.lang.Integer)
	 */
	@Override
	@Transactional
	public Product findProduct(Integer pNo) {
		return prdRepo.findOne(pNo);
	}
	
	/* (non-Javadoc)
	 * @see edu.iss.inventory.service.ProductService#createProduct(edu.iss.inventory.model.Product)
	 */
	@Override
	@Transactional
	public Product createProduct(Product prd) {
		return prdRepo.saveAndFlush(prd);
	}
	
	/* (non-Javadoc)
	 * @see edu.iss.inventory.service.ProductService#changeProduct(edu.iss.inventory.model.Product)
	 */
	@Override
	@Transactional
	public Product changeProduct(Product prd) {
		return prdRepo.saveAndFlush(prd);
	}
	
	/* (non-Javadoc)
	 * @see edu.iss.inventory.service.ProductService#removeProduct(edu.iss.inventory.model.Product)
	 */
	@Override
	@Transactional
	public void removeProduct(Product prd) {
		prdRepo.delete(prd);
	}

}
