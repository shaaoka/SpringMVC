package tw.team6.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table(name = "delivery")
public class Delivery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "cname")
	private String cname;
	
	@Column(name = "phone", unique = true)
	private String phone;
	
	@Column(name = "product")
	private String product;
	
	@Column(name = "num")
	private Integer num;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "ename")
	private String	ename;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "time")
	private Integer time;

	public Delivery() {
	}
	
	public Delivery(Integer id, String cname, String phone, String product, Integer price, String address) {
		this.id = id;
		this.cname = cname;
		this.phone = phone;
		this.product = product;
		this.price = price;
		this.address = address;
	}

	public Delivery(String cname, String phone, String product, Integer num, Integer price, String ename,
			String address, Integer time) {
			this.cname = cname;
			this.phone = phone;
			this.product = product;
			this.num = num;
			this.price = price;
			this.ename = ename;
			this.address = address;
			this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}
	
}
