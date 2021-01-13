package img.dao;

import java.util.ArrayList;

import model.Img;

public interface Dao {
	int makeNum();
	void insert(Img img);
	ArrayList<Img> selectAll();
	Img select(int num);
	int delete(int num);
}
