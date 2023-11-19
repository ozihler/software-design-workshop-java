package refactoring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CircleTest {

	@Test
	void should_always_have_a_radius_larger_0() {
		assertThrows(RuntimeException.class, () -> new Circle(new Point(0, 0), new Radius(0)));
		assertThrows(RuntimeException.class, () -> new Circle(new Point(0, 0), new Radius(-1)));
	}

	@Test
	void should_handle_coordinates_of_unequal_length() {
		Circle circle = new Circle(new Point(0, 0), new Radius(2));

		int[] xCoordinates = new int[]{2, 3, 4, -12, -20};
		int[] yCoordinates = new int[]{8, 20, 15, -4,};

		assertThrows(RuntimeException.class, () -> circle.countContainedPoints(Points.from(xCoordinates, yCoordinates)));
	}

	@Test
	void should_handle_empty_x_coordinates() {
		Circle circle = new Circle(new Point(0, 0), new Radius(2));
		int[] yCoordinates = new int[]{8, 20, 15, -4,};

		assertThrows(RuntimeException.class, () -> circle.countContainedPoints(Points.from(null, yCoordinates)));
		assertThrows(RuntimeException.class, () -> {
			int[] xCords = new int[0];
			circle.countContainedPoints(Points.from(xCords, yCoordinates));
		});
	}

	@Test
	void should_handle_empty_y_coordinates() {
		Circle circle = new Circle(new Point(0, 0), new Radius(2));
		int[] xCoordinates = new int[]{8, 20, 15, -4,};

		assertThrows(RuntimeException.class, () -> circle.countContainedPoints(Points.from(xCoordinates, null)));
		assertThrows(RuntimeException.class, () -> {
			int[] yCords = new int[0];
			circle.countContainedPoints(Points.from(xCoordinates, yCords));
		});
	}

	@Test
	void should_count_contained_points() {
		Circle circle = new Circle(new Point(5, -5), new Radius(10));
		int[] xCoordinates = new int[]{2, 1, 3, 8, 4, -12, -20, -4};
		int[] yCoordinates = new int[]{8, 1, 20, -4, 15, -4, -20, -4};
		assertEquals(3, circle.countContainedPoints(Points.from(xCoordinates, yCoordinates)));
	}

	@Test
	void should_count_contained_points_when_moved_to_new_location() {
		Circle circle = new Circle(new Point(0, 0), new Radius(20));
		int[] xCoordinates = new int[]{2, 3, 4, -12, -20};
		int[] yCoordinates = new int[]{8, 20, 15, -4, -20};
		assertEquals(3, circle.countContainedPoints(Points.from(xCoordinates, yCoordinates)));

		circle.moveTo(new Point(-30, -30));

		assertEquals(1, circle.countContainedPoints(Points.from(xCoordinates, yCoordinates)));
	}

	@Test
	void should_count_contained_points_when_resized_for_new_area() {
		Circle circle = new Circle(new Point(0, 0), new Radius(20));
		int[] xCoordinates = new int[]{2, 3, 4, -12, -20};
		int[] yCoordinates = new int[]{8, 20, 15, -4, -20};
		assertEquals(3, circle.countContainedPoints(Points.from(xCoordinates, yCoordinates)));

		circle.resize(new Radius(40));
		assertEquals(5, circle.countContainedPoints(Points.from(xCoordinates, yCoordinates)));

		circle.resize(new Radius(1));
		assertEquals(0, circle.countContainedPoints(Points.from(xCoordinates, yCoordinates)));
	}

	@Test
	void should_format_location_and_radius_as_string() {
		Circle circle = new Circle(new Point(1, 4), new Radius(7));
		assertEquals("""
				circle: {
				\tcenter: (1,4)\s
				\tradius: 7
				\tcolor: Green
				}""", circle.format());
	}
}
