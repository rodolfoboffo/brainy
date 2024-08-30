package brainy.test.model;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import brainy.activation.ReLu;
import brainy.data.NumericType;
import brainy.model.Layer;

public class LayerTest {

	private Layer l1;
	
	@BeforeEach
	public void setUp() {
		l1 = new Layer(NumericType.arrayOf(new float[] {1, 1.5f, 2}), NumericType.valueOf(3), new ReLu());
	}
	
	@Test
	public void testEvaluateSuccess() {
		NumericType[] input = NumericType.arrayOf(new float[] {2, 4, 5});
		assertTrue(l1.evaluate(input).equals(NumericType.valueOf(21)));
	}
	
	@Test
	public void testEvaluateSizeMismatch() {
		NumericType[] input = NumericType.arrayOf(new float[] {2, 5});
		assertThrows("", RuntimeException.class, () -> l1.evaluate(input));
	}

}
