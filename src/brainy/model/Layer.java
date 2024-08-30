package brainy.model;

import java.util.function.Function;

import brainy.data.NumericType;

public class Layer {

	private NumericType weights[];
	private NumericType bias;
	private Function<NumericType, NumericType> activationFunction;
	
	public Layer(NumericType[] weights, NumericType bias) {
		this(weights, bias, null);
	}
	
	public Layer(NumericType[] weights, NumericType bias, Function<NumericType, NumericType> activationFunction) {
		super();
		this.weights = weights;
		this.bias = bias;
		this.activationFunction = activationFunction;
	}

	public NumericType evaluate(NumericType[] input) {
		if (input.length != weights.length) {
			throw new RuntimeException("Input length does not match with layer length.");
		}
		NumericType result = bias.copyOf();
		for (int i = 0; i < weights.length; i++) {
			result = result.add(input[i].mul(weights[i]));
		}
		if (this.activationFunction != null) {
			result = this.activationFunction.apply(result);
		}
		return result;
	}
	
}
