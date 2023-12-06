package refactoring;

import static java.lang.Math.sqrt;
import static refactoring.Maths.square;

public record Point(int x, int y) {
	public String format() {
		return "(" + x() + "," + y() + ")";
	}

	public double distanceTo(Point point) {
		var deltaX = point.x() - this.x();
		var deltaY = point.y() - this.y();
		return sqrt(square(deltaX) + square(deltaY));
	}
}
