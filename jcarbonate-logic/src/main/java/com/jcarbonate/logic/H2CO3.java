package com.jcarbonate.logic;

/**
 * The {@code H2CO3} class represents the concentration of carbonic acid (H2CO3)
 * in a solution, typically measured in units such as mmol/L. Carbonic acid is a
 * crucial intermediate in the carbon cycle, particularly in aquatic
 * environments and biological systems.
 *
 * <p>
 * In aqueous environments, carbonic acid is in equilibrium with dissolved
 * carbon dioxide (CO2aq), bicarbonate (HCO3⁻), and carbonate (CO3²⁻), forming a
 * significant part of the carbonate buffering system. This system plays an
 * essential role in regulating pH levels in natural waters and biological
 * fluids, such as blood. Accurate representation of carbonic acid concentration
 * is important for understanding acid-base balance, ocean acidification, and
 * respiratory physiology.
 * </p>
 *
 * <p>
 * This class is immutable, ensuring that once an instance is created with a
 * specific carbonic acid concentration, that value cannot be changed. The class
 * is also thread-safe.
 * </p>
 *
 * <p>
 * For more information on carbonic acid, refer to the
 * <a href="https://en.wikipedia.org/wiki/Carbonic_acid">Carbonic Acid Wikipedia
 * page</a>.
 * </p>
 *
 * <p>
 * Usage example:
 *
 * <pre>
 * {@code
 * H2CO3 carbonicAcidConcentration = new H2CO3.H2CO3Builder().value(1.2).build();
 * Double concentration = carbonicAcidConcentration.getValue();
 * }
 * </pre>
 * </p>
 */
public final class H2CO3 extends Specie {

	/**
	 * Constructs a {@code H2CO3} instance using the provided {@link H2CO3Builder}.
	 *
	 * @param builder the {@link H2CO3Builder} used to build the {@code H2CO3}
	 */
	private H2CO3(final H2CO3Builder builder) {
		super(builder);
	}

	/**
	 * Returns a new {@link H2CO3Builder} instance for constructing {@code H2CO3}
	 * objects.
	 *
	 * @return a new instance of {@link H2CO3Builder}
	 */
	public static H2CO3Builder builder() {
		return new H2CO3Builder();
	}

	/**
	 * Builder class for creating instances of {@code H2CO3}.
	 * <p>
	 * This class extends {@link SpecieBuilder} and provides the implementation for
	 * building {@code H2CO3} instances.
	 * </p>
	 */
	public static final class H2CO3Builder extends SpecieBuilder<H2CO3Builder> {

		/**
		 * Builds a new {@code H2CO3} instance using the current builder state.
		 *
		 * @return a new {@code H2CO3} instance
		 */
		@Override
		public H2CO3 build() {
			return new H2CO3(this);
		}

		@Override
		protected H2CO3Builder self() {
			return this;
		}
	}
}
