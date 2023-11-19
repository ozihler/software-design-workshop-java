package refactoring;

import java.util.List;
import java.util.stream.IntStream;

public class Points {
    private final List<Point> points;

    private Points(List<Point> points) {
        this.points = points;
    }

    static Points from(int[] xCords, int[] yCords) {
        validateCoordinates(xCords, yCords);

        return fromCoordinates(xCords, yCords);
    }

    private static Points fromCoordinates(int[] xCords, int[] yCords) {
        var points = IntStream.range(0, xCords.length)
                .mapToObj(i -> new Point(xCords[i], yCords[i]))
                .toList();

        return new Points(points);
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

    public List<Point> asList() {
        return points;
    }
}
