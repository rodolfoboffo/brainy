package brainy.activation;

import brainy.data.NumericType;

public class ReLu extends ActivationFunc {
	
	@Override
	public NumericType apply(NumericType v) {
		return v.le(NumericType.valueOf(0)) ? NumericType.valueOf(0) : v.copyOf();
	}

}
