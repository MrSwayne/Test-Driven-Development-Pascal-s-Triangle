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
	
	public static int choose(int n, int k) {
		return (factorial(n) / (factorial(k) * factorial((n - k))));
	}
	
	public static int factorial(int x) {
		if(x < 0) throw new RuntimeException();
		if(x == 0)	return 1;
		else 		return x * (factorial(x - 1));
	}
}
