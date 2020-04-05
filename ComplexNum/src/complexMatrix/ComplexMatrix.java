package complexMatrix;

import java.util.Random;

import complexNum.complexNum;
import matrix.Matrix;

public class ComplexMatrix extends Matrix<complexNum>{
	
	public ComplexMatrix(int hight, int length) {
		super(hight, length);
		// TODO Auto-generated constructor stub
	}

	public void randFill () {
		Random r = new Random();
		for(int i = 0; i < this.getHight(); i++) {
			for(int i2 = 0; i2 < this.getLength(); i2++) {
				this.getMatrix().get(i).set(i2, new complexNum(r.nextDouble() % 100.0, r.nextDouble() % 100.0));
			}
		}
	}
}
