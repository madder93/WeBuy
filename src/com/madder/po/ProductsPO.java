package com.madder.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class ProductsPO implements Serializable{

	private static final long serialVersionUID = 7984253137976457130L;

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name = "name")
	private String name;
	
//	@Column(name = "type")
//	private Integer type;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "keyword")
	private String keyword;
	
	@Column(name = "phone_password")
	private String phonePassword;
	
	@Column(name = "img")
	private String img;
	
	@Column(name = "add_time")
	private Date addTime;
	
	@Column(name = "status")
	private Integer status;
	
	@ManyToOne(fetch = FetchType.LAZY)  //fetch=FetchType.LAZY属性表示在多的那一方通过延迟加载的方式加载对象(默认不是延迟加载)
	@JoinColumn(name = "type")   //通过 JoinColumn 的name属性指定了外键的名称 (注意：如果我们不通过JoinColum来指定外键的名称，系统会给我们声明一个名称)
	private CategoryPO category;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Integer getType() {
//		return type;
//	}
//
//	public void setType(Integer type) {
//		this.type = type;
//	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getPhonePassword() {
		return phonePassword;
	}

	public void setPhonePassword(String phonePassword) {
		this.phonePassword = phonePassword;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public CategoryPO getCategory() {
		return category;
	}

	public void setCategory(CategoryPO category) {
		this.category = category;
	}
}
