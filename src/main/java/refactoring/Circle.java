package refactoring;


import java.util.ArrayList;

public class Circle extends Shape {
	private Point center;
	private Radius radius;
	private Color color = new Color("Green");

	public Circle(Point center, Radius radius) {
		this.center = center;
		this.radius = radius;
	}

	public int countContainedPoints(int[] xCords, int[] yCords) {
		validateCoordinates(xCords, yCords);

		return countPointsFor(xCords, yCords);
	}

	private int countPointsFor(int[] xCords, int[] yCords) {
		var points = new ArrayList<Point>();

		for (int i = 0; i < xCords.length; ++i) {
			var point = new Point(xCords[i], yCords[i]);
			points.add(point);
		}

		int numberOfContainedPoints = 0;
		for (Point point : points) {
			if (contains(point)) {
				numberOfContainedPoints++;
			}
		}
		return numberOfContainedPoints;
	}

	private static void validateCoordinates(int[] xCords, int[] yCords) {
        if (isEmpty(xCords)) {
            throw new RuntimeException("x coordinates are empty");
        }
        if (isEmpty(yCords)) {
            throw new RuntimeException("y coordinates are empty");
        }
        if (differInLength(xCords, yCords)) {
            throw new RuntimeException("Not every provided x coordinate has a matching y coordinate");
        }
    }

    private static boolean differInLength(int[] xCords, int[] yCords) {
        return xCords.length != yCords.length;
    }

    private static boolean isEmpty(int[] coordinates) {
        return coordinates == null || coordinates.length == 0;
    }


	public boolean contains(Point point) {
		var deltaX = point.x() - this.center.x();
		var deltaY = point.y() - this.center.y();
		return square(deltaX) + square(deltaY) <= square(radius.value());
	}

	private int square(int value) {
		return value * value;
	}

	public void moveTo(Point newCenter) {
		this.center = newCenter;
	}

	public void resize(Radius newRadius) {
		this.radius = newRadius;
	}

	@Override
	public String format() {
		return "circle: {" +
				"\n\tcenter: " + center.format() + " " +
				"\n\tradius: " + radius.format() +
				"\n\tcolor: " + this.color.getColorFormatted(false)
				+ "\n}";
	}

}
