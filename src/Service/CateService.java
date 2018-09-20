package Service;

import java.util.List;

import entity.Category;

public interface CateService {
	public int findAll(int size);
	public List<Category> findAllType(int pageNo,int pageSize);
	int AddFindById(Category cg);
}
