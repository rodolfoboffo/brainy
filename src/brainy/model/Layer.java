package brainy.model;

import java.util.function.Function;

import brainy.data.NumericType;

public class Layer {

	private NumericType weightsMatrix[][];
	private NumericType biasArray[];
	private Integer layerSize;
	private Function<NumericType, NumericType> activationFunction;
	
	public Layer(NumericType[][] weights, NumericType[] bias) {
		this(weights, bias, null);
	}
	
	public Layer(NumericType[][] weights, NumericType[] bias, Function<NumericType, NumericType> activationFunction) {
		if (weights.length == 0)
			throw new RuntimeException("Invalid layer size.");
		this.weightsMatrix = weights;
		this.biasArray = bias;
		this.layerSize = this.biasArray.length;
		this.activationFunction = activationFunction;
	}

	public NumericType[] evaluate(NumericType[] input) {
		if (input.length != weightsMatrix.length) {
			throw new RuntimeException("Input length does not match with layer length.");
		}
		NumericType[] result = NumericType.zeroes(this.layerSize);
		for (int j = 0; j < this.layerSize; j++) {
			result[j] = result[j].add(this.biasArray[j]);
			for (int i = 0; i < weightsMatrix.length; i++) {
				result[j] = result[j].add(input[i].mul(weightsMatrix[i][j]));
			}
			if (this.activationFunction != null) {
				result[j] = this.activationFunction.apply(result[j]);
			}
		}
		return result;
	}
	
}
