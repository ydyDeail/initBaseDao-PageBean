package entity;

import java.sql.Timestamp;


public class Category {
	private int id;
	private String name;
	private Timestamp createDate;
	private String pic;
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Category(int id, String name, Timestamp createDate, String pic) {
		super();
		this.id = id;
		this.name = name;
		this.createDate = createDate;
		this.pic = pic;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
}
