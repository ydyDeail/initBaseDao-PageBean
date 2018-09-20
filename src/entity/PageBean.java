package entity;

import java.util.List;

public class PageBean<T> {
	private int pageNo=1;
	private int pageSize=2;
	private int count;
	private int shuJu;
	private List<T> list;
	
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBean(int pageNo, int pageSize) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		if(pageNo<1){
			pageNo=1;
		}
		if(pageNo>getCount()){
			pageNo=getCount();
		}
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getShuJu() {
		shuJu=count%pageSize==0?count/pageSize:count/pageSize+1;
		return shuJu;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
