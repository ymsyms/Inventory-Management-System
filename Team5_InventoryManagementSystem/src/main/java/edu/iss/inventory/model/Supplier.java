package edu.iss.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier {
	@Id
	@Column(name = "supplieeId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplierId;
	@Column(name = "supplierName")
	private String supplierName;
	@Column(name = "supplierContactNo")
	private String supplierContactNo;

	
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supplier(int supplierId, String supplierName, String supplierContactNo) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierContactNo = supplierContactNo;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierContactNo() {
		return supplierContactNo;
	}

	public void setSupplierContactNo(String supplierContactNo) {
		this.supplierContactNo = supplierContactNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + supplierId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supplier other = (Supplier) obj;
		if (supplierId != other.supplierId)
			return false;
		return true;
	}

}
