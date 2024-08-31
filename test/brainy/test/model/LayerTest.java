package brainy.test.model;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import brainy.activation.ReLu;
import brainy.data.NumericType;
import brainy.model.Layer;

public class LayerTest {

	private Layer l1;
	
	@BeforeEach
	public void setUp() {
		l1 = new Layer(NumericType.matrixOf(new float[][] {{3, 2, 1, 4}, {0, 3, 1, 2}}), NumericType.arrayOf(new float[] {0, 1, 2, 3}), new ReLu());
	}
	
	@Test
	public void testEvaluateSuccess() {
		NumericType[] input = NumericType.arrayOf(new float[] {1, 2});
		NumericType[] result = l1.evaluate(input);
		assertArrayEquals(result, NumericType.arrayOf(new float[] {3, 9, 5, 11}));
	}
	
	@Test
	public void testEvaluateSizeMismatch() {
		NumericType[] input = NumericType.arrayOf(new float[] {2});
		assertThrows(RuntimeException.class, () -> l1.evaluate(input));
	}

}
