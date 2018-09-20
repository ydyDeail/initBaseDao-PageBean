package ServiceImpl;

import java.util.List;

import entity.Category;
import Dao.Cate;
import DaoImpl.CateImpl;
import Service.CateService;

public class CateServiceImpl implements CateService{
	Cate c=new CateImpl();
	public int findAll(int size) {
		// TODO Auto-generated method stub
		int count=c.findAll();
		return count%size==0?count/size:count/size+1;
	}
	public List<Category> findAllType(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return c.findAllType(pageNo, pageSize);
	}
	public int AddFindById(Category cg) {
		// TODO Auto-generated method stub
		return c.AddFindById(cg);
	}

}
