package refactoring;

public record Radius(int value) {
	public Radius {
		if (value <= 0) {
			throw new RuntimeException("Radius needs to be larger 0");
		}
	}

	public int format() {
		return value();
	}
}
