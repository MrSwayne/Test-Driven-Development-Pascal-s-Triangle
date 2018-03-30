import java.math.BigInteger;

public class PascalsTriangle {

	private int rows;
	
	public PascalsTriangle(int r) {
		this.rows = r;
	}
	
	public PascalsTriangle(String r) throws NumberFormatException {
		this.rows = Integer.parseInt(r);
	}
	
	public void display() {
		String display = "";
		for(int row = 0;row < rows;row++) {
			display += ("row " + (row + 1) + ": ");
			for(int col = 0;col <= row;col++)
				display += (choose(row, col) + " ");
			display += "\n";
		}
		System.out.print(display);
	}
	
	public static BigInteger choose(int n, int k) {
		return (factorial(n).divide((factorial(k).multiply(factorial((n - k))))));
	}
	
	public static BigInteger factorial(int x) {
		if(x < 0) throw new RuntimeException();
		if(x == 0)	return BigInteger.valueOf(1);
		else 		return BigInteger.valueOf(x).multiply(factorial(x - 1));
	}
	
	public void setRow(int r) {
		this.rows = r;
	}
}
