package refactoring;


public class Circle extends Shape {
	private Point center;
	private Radius radius;
	private Color color = new Color("Green");

	public Circle(Point center, Radius radius) {
		this.center = center;
		this.radius = radius;
	}

	public int countContainedPoints(Points points) {
		return (int) points.asList()
				.stream()
				.filter(this::contains)
				.count();
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
