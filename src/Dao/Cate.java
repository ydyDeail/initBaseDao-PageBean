package Dao;

import java.util.List;

import entity.Category;

public interface Cate {
	public int findAll();
	public List<Category> findAllType(int pageNo,int pageSize);
	int AddFindById(Category cg);
}
