/**
 * 
 */
package org.dndp.dndc.engine.physics;

/**
 * This abstract class represent sing point in 3-Dimension space.
 * 
 * @author evil
 * 
 */
public class Point {

	private double x, y, z;
	public static Measurable length = new Measurable() {

		/**
		 * [PL] Zwraca długość (oś x)
		 */
		@Override
		public double measure(Point a, Point b) {
			return Math.abs(b.x - a.x);
		}
	};
	public static Measurable width = new Measurable() {

		/**
		 * [PL] Zwraca szerokość (oś y)
		 */
		@Override
		public double measure(Point a, Point b) {
			return Math.abs(b.y - a.y);
		}
	};
	public static Measurable height = new Measurable() {

		/**
		 * [PL] Zwraca wysokość (oś z)
		 */
		@Override
		public double measure(Point a, Point b) {
			return Math.abs(b.z - a.z);
		}
	};

	/**
	 * Initialize the Point by coordination.
	 */
	public Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static double distanceBetween(Point a, Point b, Measurable measure) {
		return measure.measure(a, b);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(java.lang.Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) {
			return false;
		}
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)) {
			return false;
		}
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * @return the z
	 */
	public double getZ() {
		return z;
	}

	/**
	 * @param z
	 *            the z to set
	 */
	public void setZ(double z) {
		this.z = z;
	}

}
