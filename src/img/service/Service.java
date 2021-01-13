package img.service;

import java.util.ArrayList;

import model.Img;

public interface Service {
	void addImg(Img img);
	ArrayList<Img> getAll();
	int makeNum();
	Img getImg(int num);
	int delImg(int num);
}
