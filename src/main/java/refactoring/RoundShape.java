package refactoring;

public class RoundShape {

	private int x;
	private int y;
	private int r;

	public RoundShape(int x, int y, int r) {
		if (r <= 0) {
			throw new RuntimeException("Radius needs to be larger 0");
		}
		this.x = x;
		this.y = y;
		this.r = r;
	}

	public int cntPts(int[] xCords, int[] yCords) {
		int nrPts = 0;
		if (xCords != null && xCords.length > 0) {
            if (yCords != null && yCords.length > 0) {
                if (xCords.length == yCords.length) {
                    for (int i = 0; i < xCords.length; ++i) {
                        if ((xCords[i] - this.x) * (xCords[i] - this.x) + (yCords[i] - this.y) * (yCords[i] - this.y) <= r * r) {
                            nrPts++;
                        }
                    }
                } else {
                    throw new RuntimeException("Not every provided x coordinate has a matching y coordinate");
                }
            } else {
                throw new RuntimeException("y coordinates are empty");
            }
		} else {
            throw new RuntimeException("x coordinates are empty");
		}
		return nrPts;
	}


	public void mv(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void rs(int r) {
		this.r = r;
	}

	public String ft() {
		return "(" + x + ", " + y + "), " + r;
	}

}
