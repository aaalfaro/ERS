package com.revature.model;

import java.io.Serializable;
import java.util.Arrays;

public class Reimbursement implements Serializable {
	
	private static final long serialVersionUID = 330071914846302198L;
	private int id;
	private int e_id;
	private int fm_id;
	private float amount;
	private String recieved;
	private String resolved;
	private String category;
	private String status;
	private byte[] image;
	

	public Reimbursement() {}
	
	public Reimbursement(int id, int e_id) {
		this.id = id;
		this.e_id = e_id;
	}
	
	public Reimbursement(int id, float amount, String category, String status) {
		super();
		this.id = id;
		this.amount = amount;
		this.category = category;
		this.status = status;
	}

	public Reimbursement(int id, int e_id, int m_id, float amount, String recieved, String resolved, String category, String status) {
		super();
		this.id = id;
		this.e_id = e_id;
		this.fm_id = m_id;
		this.amount = amount;
		this.recieved = recieved;
		this.resolved = resolved;
		this.category = category;
		this.status = status;
	}
	
	
	
	public Reimbursement(int id, int e_id, int fm_id, float amount, String recieved, String resolved, String category,
			String status, byte[] image) {
		super();
		this.id = id;
		this.e_id = e_id;
		this.fm_id = fm_id;
		this.amount = amount;
		this.recieved = recieved;
		this.resolved = resolved;
		this.category = category;
		this.status = status;
		this.image = image;
	}

	public Reimbursement(int int1, String date, String date2, float float1, String string, String string2) {
		this.id = int1;
		this.recieved = date;
		this.resolved = date2;
		this.amount = float1;
		this.category = string;
		this.status = string2;
	}
	
	

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getRecieved() {
		return recieved;
	}

	public void setRecieved(String recieved) {
		this.recieved = recieved;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}

	public void setFm_id(int fm_id) {
		this.fm_id = fm_id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public Integer getFm_id() {
		return fm_id;
	}

	public void setFm_id(Integer fm_id) {
		this.fm_id = fm_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + e_id;
		result = prime * result + fm_id;
		result = prime * result + id;
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + ((recieved == null) ? 0 : recieved.hashCode());
		result = prime * result + ((resolved == null) ? 0 : resolved.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (e_id != other.e_id)
			return false;
		if (fm_id != other.fm_id)
			return false;
		if (id != other.id)
			return false;
		if (!Arrays.equals(image, other.image))
			return false;
		if (recieved == null) {
			if (other.recieved != null)
				return false;
		} else if (!recieved.equals(other.recieved))
			return false;
		if (resolved == null) {
			if (other.resolved != null)
				return false;
		} else if (!resolved.equals(other.resolved))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", e_id=" + e_id + ", fm_id=" + fm_id + ", amount=" + amount + ", recieved="
				+ recieved + ", resolved=" + resolved + ", category=" + category + ", status=" + status + ", image="
				+ Arrays.toString(image) + "]";
	}
	
	
	
	
}
