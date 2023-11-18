package refactoring;


public class Circle extends Shape {
    private int x;
    private int y;
    private int r;
    private Color color = new Color("Green");

    public Circle(int x, int y, int r) {
        if (r <= 0) {
            throw new RuntimeException("Radius needs to be larger 0");
        }
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public int countContainedPoints(int[] xCords, int[] yCords) {
        validateCoordinates(xCords, yCords);

        int numberOfContainedPoints = 0;
        for (int i = 0; i < xCords.length; ++i) {
            if (contains(xCords, yCords, i)) {
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

    public boolean contains(int[] xCords, int[] yCords, int i) {
        var deltaX = xCords[i] - this.x;
        var deltaY = yCords[i] - this.y;
        return square(deltaX) + square(deltaY) <= square(r);
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
