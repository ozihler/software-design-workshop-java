package refactoring;


public class Circle extends Shape {
	private int x;
	private int y;
	private int r;
	private Color color = new Color("Green");
	private int numberOfContainedPoints;

	public Circle(int x, int y, int r) {
		if (r <= 0) {
			throw new RuntimeException("Radius needs to be larger 0");
		}
		this.x = x;
		this.y = y;
		this.r = r;
	}

	public int countContainedPoints(int[] xCords, int[] yCords) {
		this.numberOfContainedPoints = 0;
		if (xCords == null || xCords.length == 0) {
			throw new RuntimeException("x coordinates are empty");
		}
		if (yCords == null || yCords.length == 0) {
			throw new RuntimeException("y coordinates are empty");
		}
		if (xCords.length != yCords.length) {
			throw new RuntimeException("Not every provided x coordinate has a matching y coordinate");
		}
		for (int i = 0; i < xCords.length; ++i) {
			contains(xCords, yCords, i);
		}
		return numberOfContainedPoints;
	}

	public boolean contains(int[] xCords, int[] yCords, int i) {
		var deltaX = xCords[i] - this.x;
		var deltaY = yCords[i] - this.y;
		var result = square(deltaX) + square(deltaY) <= square(r);
		if (result) {
			this.numberOfContainedPoints++;
		}
		return result;
	}

	private int square(int value) {
		return value * value;
	}

	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void resize(int r) {
		this.r = r;
	}

	@Override
	public String format() {
		return "circle: {" +
				"\n\tcenter: (" + this.x + "," + this.y + ") " +
				"\n\tradius: " + this.r +
				"\n\tcolor: " + this.color.getColorFormatted(false)
				+ "\n}";
	}

}
