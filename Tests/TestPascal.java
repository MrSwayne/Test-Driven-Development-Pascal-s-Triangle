import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import java.math.BigInteger;

public class TestPascal {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	//Setup so I can test output of triangle
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}
	
	@After
	public void restoreStreams() {
		System.setOut(System.out);
		System.setErr(System.err);
	}
	
	
	@Test
	public void whenIntIsSuppliedDuringInitialisationTheTriangleIsCreated() {
		PascalsTriangle triangle = new PascalsTriangle(5);
		Assert.assertTrue(true);
	}
	
	@Test(expected = RuntimeException.class)
	public void inFactorialMethodIfNumberSuppliedIsNegativeThenExceptionIsThrown() {
		PascalsTriangle.factorial(-5);
		Assert.assertTrue(true);
	}
	
	@Test
	public void inFactorialMethodIfNumberSuppliedFactorialOfThatNumberIsReturned() {
		Assert.assertEquals(BigInteger.valueOf(120), PascalsTriangle.factorial(5));
	}
	
	@Test
	public void inChooseMethodNChooseKShouldBeReturned() {
		Assert.assertEquals(BigInteger.valueOf(1), PascalsTriangle.choose(0,0));
		Assert.assertEquals(BigInteger.valueOf(3), PascalsTriangle.choose(3, 2));
		Assert.assertEquals(BigInteger.valueOf(4), PascalsTriangle.choose(4, 1));
	}
	
	@Test
	public void whenStringIsSuppliedDuringInitialisationThenStringShouldBeParsedToInt() {
		PascalsTriangle triangle = new PascalsTriangle("5");
		Assert.assertTrue(true);
	}
	
	@Test(expected = NumberFormatException.class)
	public void whenStringIsSuppliedDuringInitialisationIfStringCantBeParsedIllegalArgumentIsThrown() {
		PascalsTriangle triangle = new PascalsTriangle("hello");
		Assert.assertTrue(true);
	}
	
	@Test
	public void callingDisplayShouldDisplayAllRowsUpToRowSuppliedDuringInitialisation() {
		
		//The correct output when generating up to the 5th row of Pascal's Triangle
		String row = "row 1: 1 \n" + 
				     "row 2: 1 1 \n" + 
				     "row 3: 1 2 1 \n" + 
				     "row 4: 1 3 3 1 \n" + 
				     "row 5: 1 4 6 4 1 \n";
		
		PascalsTriangle triangle = new PascalsTriangle(5);
		
		triangle.display();
		Assert.assertEquals(row, outContent.toString());
	}	
	
	@Test
	public void callingSetRowMethodShouldChangeMaxRowOfTheTriangle() {
		
		String row = "row 1: 1 \n" +
					 "row 2: 1 1 \n" +
					 "row 3: 1 2 1 \n";
		
		PascalsTriangle triangle = new PascalsTriangle(5);
		triangle.setRow(3);
		
		triangle.display();
		Assert.assertEquals(row, outContent.toString());
	}
	
	@Test
	public void triangleShouldDisplayUpTo100Rows() {
		PascalsTriangle triangle = new PascalsTriangle(100);
		
		triangle.display();
		Assert.assertTrue(true);
	}
}
