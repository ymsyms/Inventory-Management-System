package edu.iss.inventory.service;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

import edu.iss.inventory.model.ProductSupplier;

public interface ProductSupplierService {

	ArrayList<ProductSupplier> findAllProductSuppliers();

	ProductSupplier findProductSupplier(Integer pNo);

	ProductSupplier createProductSupplier(ProductSupplier prd);

	ProductSupplier changeProductSupplier(ProductSupplier prd);

	void removeProductSupplier(ProductSupplier prd);

}