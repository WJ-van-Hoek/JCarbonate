package com.jcarbonate.logic;

/**
 * The {@code pH} class represents the pH value of a solution, a measure of the
 * hydrogen ion concentration, typically expressed on a scale from 0 to 14. The
 * pH scale is a critical parameter in chemistry, biology, environmental
 * science, and various industrial processes.
 *
 * <p>
 * pH is a key indicator of acidity or alkalinity in a solution, and it
 * influences the solubility and biological availability of chemical species. In
 * natural and biological systems, pH plays a crucial role in maintaining
 * homeostasis, regulating enzymatic activity, and determining the chemical
 * forms of nutrients and contaminants. Understanding pH is essential for
 * processes such as acid-base balance in the body, soil chemistry, water
 * quality, and industrial operations.
 * </p>
 *
 * <p>
 * This class is immutable, ensuring that once an instance is created with a
 * specific pH value, that value cannot be changed. The class is also
 * thread-safe.
 * </p>
 *
 * <p>
 * For more information on pH, refer to the
 * <a href="https://en.wikipedia.org/wiki/PH">pH Wikipedia page</a>.
 * </p>
 *
 * <p>
 * Usage example:
 *
 * <pre>
 * {@code
 * PH phValue = new pH(7.4);
 * Double value = phValue.getValue();
 * }
 * </pre>
 * </p>
 */
public final class PH {
	/**
	 * The pH value of the solution, representing the acidity or alkalinity on a
	 * scale from 0 (most acidic) to 14 (most alkaline).
	 */
	private final double _value;

	/**
	 * Constructs a {@code pH} instance with the specified pH value.
	 *
	 * @param value the pH value of the solution
	 */
	public PH(final double value) {
		if (value < 0.0 || value > 14.0) {
			throw new IllegalArgumentException("pH value must be between 0 and 14.");
		}
		_value = value;
	}

	/**
	 * Returns the pH value of this {@code pH} instance.
	 *
	 * @return the pH value
	 */
	public double getValue() {
		return _value;
	}
}
