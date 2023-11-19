package refactoring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorTest {

	@Test
	void should_format_color_as_text() {
		var red = new Color("Red");

		var colorFormatted = red.getColorAsText();

		assertEquals("Red", colorFormatted);
	}

	@Test
	void should_format_color_as_text_and_hex_and_rgb() {
		var red = new Color("Red");

		var colorFormatted = red.getColorFormatted();

		assertEquals("Red #FF0000 255:0:0", colorFormatted);
	}

	@Test
	void should_format_green_as_hex_and_rgb() {
		var green = new Color("Green");

		var colorFormatted = green.getColorFormatted();

		assertEquals("Green #0000FF 0:255:0", colorFormatted);
	}

	@Test
	void should_format_blue_as_hex_and_rgb() {
		var blue = new Color("Blue");

		var colorFormatted = blue.getColorFormatted();

		assertEquals("Blue #00FF00 0:0:255", colorFormatted);
	}
}
