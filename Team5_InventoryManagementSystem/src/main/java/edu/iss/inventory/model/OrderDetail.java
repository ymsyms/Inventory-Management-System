package edu.iss.inventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orderdetail")
public class OrderDetail implements Serializable{
	@Id
	@Column(name="orderId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	@Id
	@Column(name="partNo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String partNo;
	@Column(name="transactionQty")
	private int transactionQty;

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(int orderId, String partNo, int transactionQty) {
		super();
		this.orderId = orderId;
		this.partNo = partNo;
		this.transactionQty = transactionQty;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
		result = prime * result + orderId;
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
		OrderDetail other = (OrderDetail) obj;
		if (partNo == null) {
			if (other.partNo != null)
				return false;
		} else if (!partNo.equals(other.partNo))
			return false;
		if (orderId != other.orderId)
			return false;
		return true;
	}

}
