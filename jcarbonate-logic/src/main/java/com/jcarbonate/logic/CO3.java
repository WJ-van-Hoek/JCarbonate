package com.jcarbonate.logic;

/**
 * The {@code CO3} class represents the concentration of carbonate (CO3²⁻) in a solution, typically measured in units
 * such as mmol/L. Carbonate is an essential component of the carbonate buffering system, which plays a crucial role in
 * regulating pH levels in natural waters and biological systems, such as blood.
 *
 * <p>
 * In aqueous environments, carbonate is in equilibrium with dissolved carbon dioxide (CO2aq), carbonic acid (H2CO3),
 * and bicarbonate (HCO3⁻), forming a vital part of the carbon cycle. The accurate representation of carbonate
 * concentration is important for understanding acid-base balance, ocean chemistry, and geological processes such as
 * limestone formation.
 * </p>
 *
 * <p>
 * This class is immutable, ensuring that once an instance is created with a specific carbonate concentration, that
 * value cannot be changed. The class is also thread-safe.
 * </p>
 *
 * <p>
 * For more information on carbonate, refer to the <a href="https://en.wikipedia.org/wiki/Carbonate">Carbonate Wikipedia
 * page</a>.
 * </p>
 *
 * <p>
 * Usage example:
 *
 * <pre>
 * {@code
 * CO3 carbonateConcentration = new CO3.CO3Builder().value(3.6).build();
 * Double concentration = carbonateConcentration.getValue();
 * }
 * </pre>
 * </p>
 */
public final class CO3 extends Specie {

    /**
     * Constructs a {@code CO3} instance using the provided {@link CO3Builder}.
     *
     * @param builder the {@link CO3Builder} used to build the {@code CO3}
     */
    private CO3(final CO3Builder builder) {
        super(builder);
    }

    /**
     * Returns a new {@link CO3Builder} instance for constructing {@code CO3} objects.
     *
     * @return a new instance of {@link CO3Builder}
     */
    public static CO3Builder builder() {
        return new CO3Builder();
    }

    /**
     * Builder class for creating instances of {@code CO3}.
     * <p>
     * This class extends {@link SpecieBuilder} and provides the implementation for building {@code CO3} instances.
     * </p>
     */
    public static final class CO3Builder extends SpecieBuilder<CO3Builder> {

        /**
         * Builds a new {@code CO3} instance using the current builder state.
         *
         * @return a new {@code CO3} instance
         */
        @Override
        public CO3 build() {
            return new CO3(this);
        }

        @Override
        protected CO3Builder self() {
            return this;
        }
    }
}
