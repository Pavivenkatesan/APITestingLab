package LearnApiTesting;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExampleTest {
	private int a1;
	private int b2;
	private int sum;

	@Before
	public void setup() {
		a1 = 5;
		b2 = 8;
		sum = 13;

	}

	@Test
	public void testSum() {
		Example exp=new Example();
		int actual= exp.add(a1, b2);
		Assert.assertEquals("Expected is not equal to actual", sum, actual);

	}
	@After
	public void tearDown() {
		a1=0;
		b2=0;
		sum=0;
		Assert.assertEquals("not destroyed", 0, a1);
		Assert.assertEquals("not destroyed", 0,b2);
		Assert.assertEquals("not destroyed",0, sum);
		
	}

}
