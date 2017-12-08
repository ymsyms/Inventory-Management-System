package edu.iss.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transactiondetails")
public class TransactionDeatils {
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

	public TransactionDeatils() {
		super();
	}

	public TransactionDeatils(int transactionId, String partNo, int transactionQty) {
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
		TransactionDeatils other = (TransactionDeatils) obj;
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
