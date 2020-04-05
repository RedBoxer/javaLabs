package complexNum;

public class complexNum {
	//complexNum = a + b*i
	private double a;
	private double b;
	
	public complexNum(double a, double b){
		this.a = a;
		this.b = b;
	}
	
	public void setA(double a) {this.a = a;}
	public double getA() {return this.a;}
	
	public void setB(double b) {this.b = b;}
	public double getB() {return this.b;}
	
	public complexNum sum(complexNum secondNum) {
		return new complexNum(this.getA() + secondNum.getA(),
							this.getB() + secondNum.getB());
	}
	
	public complexNum sub(complexNum secondNum) {
		return new complexNum(this.getA() - secondNum.getA(),
							this.getB() - secondNum.getB());
	}
	
	public complexNum mul(complexNum secondNum) {
		return new complexNum(this.getA() * secondNum.getA() + 
								this.getB() * secondNum.getB() * -1,
								this.getA() * secondNum.getB() + 
								this.getB() * secondNum.getA());
	}
	
	public complexNum div(complexNum secondNum) {
		complexNum temp = new complexNum(secondNum.getA(), secondNum.getB() * -1);
		complexNum upper = this.mul(temp);
		complexNum lower = secondNum.mul(temp);
		return new complexNum(upper.getA()/lower.getA(), upper.getB()/lower.getA());
	}
	
	public String toString() {
		if(this.getB() == 0) {
			return Double.toString(this.getA());
		}
		if(this.getB()> 0) {
			return this.getA() + "+" + this.getB() + "i";
		}else{
			return Double.toString(this.getA()) + this.getB() + "i";
		}
	}
	
	public String toStringTri() {
		//r = |complexNum|
		double r = Math.sqrt(this.getA() * this.getA() + this.getB() * this.getB());
		double fi = Math.atan(this.getB() / this.getA());
		return r + "(cos(" + fi + ") + isin(" + fi +"))";  
		
	}
	
}
