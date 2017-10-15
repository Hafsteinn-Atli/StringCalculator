package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest{

	@Test
	public void emptyString(){
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void oneNumber(){
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void twoNumbers(){
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void manyNumbers(){
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void allowNewLine(){
		assertEquals(6, Calculator.add("1\n2,3"));
	}


	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void noNegatives1() throws IllegalArgumentException{
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Negatives not allowed: -1");
    	Calculator.add("-1\n-2,3");
	}

	@Test
	public void noNegatives2() throws IllegalArgumentException{
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Negatives not allowed: -2, -3");
    	Calculator.add("1\n-2,-3");
	}


}