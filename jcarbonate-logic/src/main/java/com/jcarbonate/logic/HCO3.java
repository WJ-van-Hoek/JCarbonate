package com.jcarbonate.logic;

/**
 * The {@code HCO3} class represents the concentration of bicarbonate (HCO3⁻)
 * in a solution, typically measured in units such as mmol/L. Bicarbonate is a
 * vital component of the carbonate buffering system, which helps regulate pH levels
 * in natural waters and biological systems, such as blood.
 *
 * <p>
 * In aqueous environments, bicarbonate is in equilibrium with dissolved carbon dioxide (CO2aq),
 * carbonic acid (H2CO3), and carbonate (CO3²⁻), forming a critical part of the carbon cycle.
 * The accurate representation of bicarbonate concentration is crucial for understanding acid-base balance,
 * ocean acidification, and metabolic processes.
 * </p>
 *
 * <p>
 * This class is immutable, ensuring that once an instance is created with a
 * specific bicarbonate concentration, that value cannot be changed. The class
 * is also thread-safe.
 * </p>
 *
 * <p>
 * For more information on bicarbonate, refer to the
 * <a href="https://en.wikipedia.org/wiki/Bicarbonate">Bicarbonate Wikipedia page</a>.
 * </p>
 *
 * <p>
 * Usage example:
 *
 * <pre>
 * {@code
 * HCO3 bicarbonateConcentration = new HCO3.HCO3Builder().value(4.7).build();
 * Double concentration = bicarbonateConcentration.getValue();
 * }
 * </pre>
 * </p>
 */
public final class HCO3 extends Specie {

    /**
     * Constructs a {@code HCO3} instance using the provided {@link HCO3Builder}.
     *
     * @param builder the {@link HCO3Builder} used to build the {@code HCO3}
     */
    private HCO3(final HCO3Builder builder) {
        super(builder);
    }

    /**
     * Returns a new {@link HCO3Builder} instance for constructing {@code HCO3}
     * objects.
     *
     * @return a new instance of {@link HCO3Builder}
     */
    public static HCO3Builder builder() {
        return new HCO3Builder();
    }

    /**
     * Builder class for creating instances of {@code HCO3}.
     * <p>
     * This class extends {@link SpecieBuilder} and provides the implementation for
     * building {@code HCO3} instances.
     * </p>
     */
    public static final class HCO3Builder extends SpecieBuilder<HCO3Builder> {

        /**
         * Builds a new {@code HCO3} instance using the current builder state.
         *
         * @return a new {@code HCO3} instance
         */
        @Override
        public HCO3 build() {
            return new HCO3(this);
        }
    }
}
