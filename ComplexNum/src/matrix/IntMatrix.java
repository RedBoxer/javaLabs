package matrix;

import java.util.Random;

import complexNum.complexNum;

public class IntMatrix extends Matrix<Integer> {

	public IntMatrix(int hight, int length) {
		super(hight, length);
		// TODO Auto-generated constructor stub
	}

	public void randFill () {
		Random r = new Random();
		for(int i = 0; i < getHight(); i++) {
			for(int i2 = 0; i2 < getLength(); i2++) {
				this.getMatrix().get(i).set(i2, r.nextInt() % 100);
			}
		}
	}
}
