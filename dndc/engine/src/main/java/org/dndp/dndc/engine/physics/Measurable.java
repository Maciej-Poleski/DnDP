/**
 * 
 */
package org.dndp.dndc.engine.physics;

/**
 * [PL] Interfejs dla wszystkich klas mierzalnych
 * 
 * @author evil
 * 
 */
interface Measurable {
	/**
	 * [PL] Oblicza odległość między punktami korzystając z danej implementacji.
	 * 
	 * @param a
	 * @param b
	 * @return Odległość między punktami.
	 */
	public abstract double measure(Point a, Point b);
}
