package org.comit.course.bean;

public class Shop {
	
	int idProduct;
	String photoName;
	String name;
	String price;
	String description;
	String company;
	String status;
	
	public Shop() {
		
	}
	
	public Shop(int idProduct, String photoName, String name, String price, String description, String company, String status) {
		super();
		this.idProduct = idProduct;
		this.photoName = photoName;
		this.name = name;
		this.price = price;
		this.description = description;
		this.company = company;
		this.status = status;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shop other = (Shop) obj;
		if (idProduct != other.idProduct)
			return false;
		return true;
		
	}

	@Override
	public String toString() {
		return "Shop [idProduct=" + idProduct + ", photoName=" + photoName + ", name=" + name + ", price=" + price
				+ ", description=" + description + ", company=" + company + ", status=" + status + "]";
	}
	
	

}
