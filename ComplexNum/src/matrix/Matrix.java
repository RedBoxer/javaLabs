package matrix;

import java.util.ArrayList;
import java.util.Random;

public class Matrix<P> {
	private ArrayList<ArrayList<P>> matrix = new ArrayList<ArrayList<P>>();
	private int hight;
	private int length;
	
	public void setHight(int hight) {this.hight = hight;};
	public void setLength(int length) {this.length = length;};
	
	public int getHight() {return this.hight;};
	public int getLength() {return this.length;};
	
	public Matrix(int hight, int length) {
		this.hight = hight;
		this.length = length;
		for(int i = 0; i < hight; i++) {
			getMatrix().add(new ArrayList<P>());
			for(int i2 = 0; i2 < length; i2++) {
				getMatrix().get(i).add(null);
			}
		}
	}
	
	
	
	public void transp() {
		P temp;
		int curPos = 0;
		for(int i = 0 + curPos; i < hight; i++) {
			for(int i2 = 0 + curPos; i2 < length; i2++) {
				temp = this.getMatrix().get(i).get(i2);
				this.getMatrix().get(i).set(i2, this.getMatrix().get(i2).get(i));
				this.getMatrix().get(i2).set(i, temp);
			}
			curPos++;
		}
	}
	public ArrayList<ArrayList<P>> getMatrix() {
		return matrix;
	}
	public void setMatrix(ArrayList<ArrayList<P>> matrix) {
		this.matrix = matrix;
	}
	
	public String toString() {
	StringBuilder temp = new StringBuilder();
	for(int i = 0; i < hight; i++) {
		for(int i2 = 0; i2 < length; i2++) {
			temp.append(matrix.get(i).get(i2));
			temp.append(" ");
		}
		temp.append("\n");
	}
	return temp.toString();
}/*
	public void randFill () {
		Random r = new Random();
		for(int i = 0; i < hight; i++) {
			for(int i2 = 0; i2 < length; i2++) {
				this.matrix.get(i).set(i2, r.nextInt() % 100);
			}
		}
	}*/
}
