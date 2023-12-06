package refactoring;


public class Circle {
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
        return this.center.distanceTo(point) <= radius.value();
    }

    public void moveTo(Point newCenter) {
        this.center = newCenter;
    }

    public void resize(Radius newRadius) {
        this.radius = newRadius;
    }

    public String format() {
        return "circle: {" +
                "\n\tcenter: " + center.format() + " " +
                "\n\tradius: " + radius.format() +
                "\n\tcolor: " + this.color.getColorAsText()
                + "\n}";
    }

}
