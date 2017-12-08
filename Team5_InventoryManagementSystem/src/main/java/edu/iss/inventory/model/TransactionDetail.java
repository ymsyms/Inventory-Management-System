package edu.iss.inventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(TransactionDetailId.class)
@Table(name = "transactiondetail")
public class TransactionDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "transactionId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	@Id
	@Column(name = "partNo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String partNo;
	@Column(name = "transactionQty")
	private int transactionQty;

	public TransactionDetail() {
		super();
	}

	public TransactionDetail(int transactionId, String partNo, int transactionQty) {
		super();
		this.transactionId = transactionId;
		this.partNo = partNo;
		this.transactionQty = transactionQty;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getPartNo() {
		return partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public int getTransactionQty() {
		return transactionQty;
	}

	public void setTransactionQty(int transactionQty) {
		this.transactionQty = transactionQty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partNo == null) ? 0 : partNo.hashCode());
		result = prime * result + transactionId;
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
		TransactionDetail other = (TransactionDetail) obj;
		if (partNo == null) {
			if (other.partNo != null)
				return false;
		} else if (!partNo.equals(other.partNo))
			return false;
		if (transactionId != other.transactionId)
			return false;
		return true;
	}

}
