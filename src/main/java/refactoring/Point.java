package refactoring;

public record Point(int x, int y) {
    public String format() {
        return "(" + x() + "," + y() + ")";
    }

    public double distanceTo(Point point) {
        var deltaX = point.x() - this.x();
        var deltaY = point.y() - this.y();
        return Math.sqrt(Maths.square(deltaX) + Maths.square(deltaY));
    }
}
