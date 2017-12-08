package edu.iss.inventory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "order")
public class Order {
	@Id
	@Column(name = "orderId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@Temporal(TemporalType.DATE)
	@Column(name = "orderDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;
	@ManyToOne
	@JoinColumn(name = "userId")
	private  User user;
	@ManyToOne
	@JoinColumn(name = "supplierId")
	private Supplier supplier;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, Date orderDate, User user, Supplier supplier) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.user = user;
		this.supplier = supplier;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Order other = (Order) obj;
		if (orderId != other.orderId)
			return false;
		return true;
	}

}
