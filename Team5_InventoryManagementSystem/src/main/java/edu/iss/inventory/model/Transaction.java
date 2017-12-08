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
@Table(name = "transaction")
public class Transaction {
	@Id
	@Column(name = "transactionId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	@Temporal(TemporalType.DATE)
	@Column(name = "transactionDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date transactionDate;
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	@Column(name = "customerName")
	private String customerName;

	public Transaction() {
		super();
	}

	public Transaction(int transactionId, Date transactionDate, User user, String customerName) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.user = user;
		this.customerName = customerName;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Transaction other = (Transaction) obj;
		if (transactionId != other.transactionId)
			return false;
		return true;
	}

}
