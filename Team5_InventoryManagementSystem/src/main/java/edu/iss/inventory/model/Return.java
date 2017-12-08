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
@Table(name = "return")
public class Return {
	@Id
	@Column(name = "returnId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int returnId;
	@ManyToOne
	@JoinColumn(name = "partNo")
	private String partNo;
	@Column(name = "returnQty")
	private int returnQty;
	@Temporal(TemporalType.DATE)
	@Column(name = "returnDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date returnDate;

	public Return() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Return(int returnId, String partNo, int returnQty, Date returnDate) {
		super();
		this.returnId = returnId;
		this.partNo = partNo;
		this.returnQty = returnQty;
		this.returnDate = returnDate;
	}

	public int getReturnId() {
		return returnId;
	}

	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}

	public String getPartNo() {
		return partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public int getReturnQty() {
		return returnQty;
	}

	public void setReturnQty(int returnQty) {
		this.returnQty = returnQty;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + returnId;
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
		Return other = (Return) obj;
		if (returnId != other.returnId)
			return false;
		return true;
		
	}

}
