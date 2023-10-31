package refactoring;

public class Color {

	private String colorAsHex;
	private final String colorAsText;
	private String colorAsRGB_Red;
	private String colorAsRGB_Green;
	private String colorAsRGB_Blue;
	private String errorMessage;

	public Color(String colorAsText) {
		this.colorAsText = colorAsText;
		convertTextValueToRGBAndHex();
	}

	private void convertTextValueToRGBAndHex() {
		errorMessage = "";
		// set to Red
		if ("Red".equals(colorAsText)) {
			colorAsRGB_Red = "255";
			colorAsRGB_Blue = "0";
			colorAsRGB_Green = "0";
			colorAsHex = "#FF0000";
		} else if ("Blue".equals(colorAsText)) {
			// set to Blue
			colorAsRGB_Red = "0";
			colorAsRGB_Blue = "255";
			colorAsRGB_Green = "0";
			colorAsHex = "#00FF00";
		} else if ("Green".equals(colorAsText)) {
			// set to Green
			colorAsRGB_Red = "0";
			colorAsRGB_Blue = "0";
			colorAsRGB_Green = "255";
			colorAsHex = "#0000FF";
		} else {
			errorMessage = "Color not recognized";
		}
	}

	public String getColorFormatted(boolean includeHexAndRGB) {
		if (includeHexAndRGB) {
			return colorAsText + " " + colorAsHex + " " + colorAsRGB_Red + ":" + colorAsRGB_Green + ":" + colorAsRGB_Blue;
		} else {
			return colorAsText;
		}
	}
}
