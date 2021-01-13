package img.service;

import java.util.ArrayList;

import img.dao.Dao;
import img.dao.DaoImpl;
import model.Img;

public class ServiceImpl implements Service {

	private Dao dao;

	public ServiceImpl() {
		dao = new DaoImpl();
	}

	public void addImg(Img img) {
		// TODO Auto-generated method stub
		dao.insert(img);
	}

	public ArrayList<Img> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll(); 
	}

	@Override
	public int makeNum() {
		// TODO Auto-generated method stub
		return dao.makeNum();
	}

	@Override
	public Img getImg(int num) {
		// TODO Auto-generated method stub
		return dao.select(num);
	}

	@Override
	public int delImg(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

}
