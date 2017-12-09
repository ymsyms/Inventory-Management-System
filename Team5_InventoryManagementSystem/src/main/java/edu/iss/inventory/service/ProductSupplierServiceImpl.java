package edu.iss.inventory.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.inventory.model.ProductSupplier;
import edu.iss.inventory.repository.ProductSupplierRepository;


@Service
public class ProductSupplierServiceImpl implements ProductSupplierService {

	@Resource
	private ProductSupplierRepository prdSupRepo;
	
	/* (non-Javadoc)
	 * @see edu.iss.inventory.service.ProductSupplierService#findAllProductSuppliers()
	 */
	@Override
	@Transactional
	public ArrayList<ProductSupplier> findAllProductSuppliers() {
		ArrayList<ProductSupplier> l = (ArrayList<ProductSupplier>) prdSupRepo.findAll();
		return l;
	}
	
	/* (non-Javadoc)
	 * @see edu.iss.inventory.service.ProductSupplierService#findProductSupplier(java.lang.Integer)
	 */
	@Override
	@Transactional
	public ProductSupplier findProductSupplier(String pNo) {
		return prdSupRepo.findProductSupplierByProductId(pNo);
	}
	
	/* (non-Javadoc)
	 * @see edu.iss.inventory.service.ProductSupplierService#createProductSupplier(edu.iss.inventory.model.ProductSupplier)
	 */
	@Override
	@Transactional
	public ProductSupplier createProductSupplier(ProductSupplier prd) {
		return prdSupRepo.saveAndFlush(prd);
	}
	
	/* (non-Javadoc)
	 * @see edu.iss.inventory.service.ProductSupplierService#changeProductSupplier(edu.iss.inventory.model.ProductSupplier)
	 */
	@Override
	@Transactional
	public ProductSupplier changeProductSupplier(ProductSupplier prd) {
		return prdSupRepo.saveAndFlush(prd);
	}
	
	/* (non-Javadoc)
	 * @see edu.iss.inventory.service.ProductSupplierService#removeProductSupplier(edu.iss.inventory.model.ProductSupplier)
	 */
	@Override
	@Transactional
	public void removeProductSupplier(ProductSupplier prd) {
		prdSupRepo.delete(prd);
	}
}
