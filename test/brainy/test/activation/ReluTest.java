package brainy.test.activation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import brainy.activation.ActivationFunc;
import brainy.activation.ReLu;
import brainy.data.NumericType;

public class ReluTest {

	ActivationFunc f = new ReLu();
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testRelu1() {
		assertEquals(f.apply(NumericType.valueOf(-3)), NumericType.valueOf(0));
		assertEquals(f.apply(NumericType.valueOf(6.2f)), NumericType.valueOf(6.2f));
	}
	
}
