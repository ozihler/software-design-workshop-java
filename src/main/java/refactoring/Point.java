package refactoring;

public record Point(int x, int y) {
	public String format() {
		return "(" + x() + "," + y() + ")";
	}
}
