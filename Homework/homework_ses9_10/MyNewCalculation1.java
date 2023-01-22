package homework_ses9_10;

public class MyNewCalculation1 extends MyCalculation1 {

	public static void main(String[] arg) {
		
		int x = 4;
		int y = 3;
		
		MyNewCalculation1 object1 = new MyNewCalculation1();
		object1.Distraction(x, y);
		object1.Multiplication(x, y);
		object1.Sum(x, y);
		object1.Division(x, y);
		
	}
	
	public void Division(int x, int y) {
		z = x/y;
		System.out.println("x/y = " + z);
	}
}
