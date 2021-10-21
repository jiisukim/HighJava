package homework;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Testtt test = new Testtt("zz", "zz");
		
		System.out.println(test);
	}

}

class Testtt{
	private String a;
	private String  b;
	
	public Testtt(String a, String b) {
		super();
		this.a = a;
		this.b = b;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	@Override
	public String toString() {
		return "Testtt [a=" + a + ", b=" + b + "]";
	}
}