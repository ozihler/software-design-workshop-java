package refactoring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoundShapeTest {

	@Test
	void should_always_have_a_radius_larger_0() {
		assertThrows(RuntimeException.class, () -> new RoundShape(0, 0, 0));
		assertThrows(RuntimeException.class, () -> new RoundShape(0, 0, -1));
	}

	@Test
	void should_handle_coordinates_of_unequal_length() {
		RoundShape roundShape = new RoundShape(0, 0, 2);

		int[] xCoordinates = new int[]{2, 3, 4, -12, -20};
		int[] yCoordinates = new int[]{8, 20, 15, -4,};

		assertThrows(RuntimeException.class, () -> roundShape.cntPts(xCoordinates, yCoordinates));
	}

	@Test
	void should_handle_empty_x_coordinates() {
		RoundShape roundShape = new RoundShape(0, 0, 2);
		int[] yCoordinates = new int[]{8, 20, 15, -4,};

		assertThrows(RuntimeException.class, () -> roundShape.cntPts(null, yCoordinates));
		assertThrows(RuntimeException.class, () -> roundShape.cntPts(new int[0], yCoordinates));
	}

	@Test
	void should_handle_empty_y_coordinates() {
		RoundShape roundShape = new RoundShape(0, 0, 2);
		int[] xCoordinates = new int[]{8, 20, 15, -4,};

		assertThrows(RuntimeException.class, () -> roundShape.cntPts(xCoordinates, null));
		assertThrows(RuntimeException.class, () -> roundShape.cntPts(xCoordinates, new int[0]));
	}

	@Test
	void should_count_contained_points() {
		RoundShape roundShape = new RoundShape(5, -5, 10);
		int[] xCoordinates = new int[]{2, 1, 3, 8, 4, -12, -20, -4};
		int[] yCoordinates = new int[]{8, 1, 20, -4, 15, -4, -20, -4};
		assertEquals(3, roundShape.cntPts(xCoordinates, yCoordinates));
	}

	@Test
	void should_count_contained_points_when_moved_to_new_location() {
		RoundShape RoundShape = new RoundShape(0, 0, 20);
		int[] xCoordinates = new int[]{2, 3, 4, -12, -20};
		int[] yCoordinates = new int[]{8, 20, 15, -4, -20};
		assertEquals(3, RoundShape.cntPts(xCoordinates, yCoordinates));

		RoundShape.mv(-30, -30);

		assertEquals(1, RoundShape.cntPts(xCoordinates, yCoordinates));
	}

	@Test
	void should_count_contained_points_when_resized_for_new_area() {
		RoundShape RoundShape = new RoundShape(0, 0, 20);
		int[] xCoordinates = new int[]{2, 3, 4, -12, -20};
		int[] yCoordinates = new int[]{8, 20, 15, -4, -20};
		assertEquals(3, RoundShape.cntPts(xCoordinates, yCoordinates));

		RoundShape.rs(40);
		assertEquals(5, RoundShape.cntPts(xCoordinates, yCoordinates));

		RoundShape.rs(1);
		assertEquals(0, RoundShape.cntPts(xCoordinates, yCoordinates));
	}

	@Test
	void should_format_location_and_radius_as_string() {
		RoundShape roundShape = new RoundShape(1, 4, 7);
		assertEquals("(1, 4), 7", roundShape.ft());
	}
}
