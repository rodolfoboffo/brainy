package brainy.data;

public class NumericType {
	
	private final float value;

	public NumericType(float value) {
		this.value = value;
	}
	
	public static NumericType valueOf(int v) {
		return new NumericType(v);
	}
	
	public static NumericType valueOf(float v) {
		return new NumericType(v);
	}
	
	public NumericType mul(NumericType v2) {
		return new NumericType(this.value * v2.value);
	}
	
	public NumericType add(NumericType v2) {
		return new NumericType(this.value + v2.value);
	}
	
	public NumericType sub(NumericType v2) {
		return new NumericType(this.value - v2.value);
	}
	
	public NumericType div(NumericType v2) {
		return new NumericType(this.value / v2.value);
	}
	
	public NumericType copyOf() {
		return new NumericType(this.value);
	}
	
	public static NumericType[] arrayOf(float v[]) {
		NumericType array[] = new NumericType[v.length];
		for (int i = 0; i < v.length; i++) {
			array[i] = NumericType.valueOf(v[i]);
		}
		return array;
	}

	public boolean lt(NumericType v1) {
		return this.value < v1.value;
	}
	
	public boolean le(NumericType v1) {
		return this.value <= v1.value;
	}
	
	public boolean gt(NumericType v1) {
		return this.value > v1.value;
	}
	
	public boolean ge(NumericType v1) {
		return this.value >= v1.value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NumericType other = (NumericType) obj;
		return Float.floatToIntBits(value) == Float.floatToIntBits(other.value);
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.value);
	}
	
}
