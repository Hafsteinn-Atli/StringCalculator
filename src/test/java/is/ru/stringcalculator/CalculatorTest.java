package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

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
}