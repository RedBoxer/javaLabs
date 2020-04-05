package main;

import complexMatrix.ComplexMatrix;
import complexNum.complexNum;
import matrix.IntMatrix;
import matrix.Matrix;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		complexNum a = new complexNum(1, 0);
		complexNum b = new complexNum(7, -6);
		complexNum c = a.div(b);
		System.out.println(a.toString());
		System.out.println(a.toStringTri());
		IntMatrix u = new IntMatrix(4, 4);
		u.randFill();
		System.out.println(u.toString());
		u.transp();
		System.out.println(u.toString());
		ComplexMatrix r = new ComplexMatrix(4,4);
		r.randFill();
		System.out.println(r.toString());
		r.transp();
		System.out.println(r.toString());
	}
}
