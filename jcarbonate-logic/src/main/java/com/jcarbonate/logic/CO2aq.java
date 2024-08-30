package com.jcarbonate.logic;

/**
 * The {@code CO2aq} class represents the concentration of dissolved carbon dioxide (CO2) in a solution, typically
 * measured in units such as mmol/L. Dissolved CO2 is a critical component in various natural and industrial processes,
 * playing a key role in the carbon cycle, oceanic buffering systems, and biological respiration.
 *
 * <p>
 * In aquatic environments, dissolved CO2 is in equilibrium with carbonic acid (H2CO3), bicarbonate (HCO3⁻), and
 * carbonate (CO3²⁻), forming the basis of the carbonate buffering system. This buffering system is essential for
 * maintaining pH balance in natural waters and in the human body. Accurate representation of dissolved CO2
 * concentration is crucial for understanding gas exchange processes, ocean acidification, and climate change impacts.
 * </p>
 *
 * <p>
 * This class is immutable, ensuring that once an instance is created with a specific dissolved CO2 concentration, that
 * value cannot be changed. The class is also thread-safe.
 * </p>
 *
 * <p>
 * For more information on dissolved carbon dioxide, refer to the
 * <a href="https://en.wikipedia.org/wiki/Carbon_dioxide_in_Earth%27s_atmosphere#Dissolved_CO2_in_water">Dissolved CO2
 * Wikipedia page</a>.
 * </p>
 *
 * <p>
 * Usage example:
 *
 * <pre>
 * {@code
 * CO2aq co2Concentration = new CO2aq.CO2aqBuilder().value(2.5).build();
 * Double concentration = co2Concentration.getValue();
 * }
 * </pre>
 * </p>
 */
public final class CO2aq extends Specie {

    /**
     * Constructs a {@code CO2aq} instance using the provided {@link CO2aqBuilder}.
     *
     * @param builder the {@link CO2aqBuilder} used to build the {@code CO2aq}
     */
    private CO2aq(final CO2aqBuilder builder) {
        super(builder);
    }

    /**
     * Returns a new {@link CO2aqBuilder} instance for constructing {@code CO2aq} objects.
     *
     * @return a new instance of {@link CO2aqBuilder}
     */
    public static CO2aqBuilder builder() {
        return new CO2aqBuilder();
    }

    /**
     * Builder class for creating instances of {@code CO2aq}.
     * <p>
     * This class extends {@link SpecieBuilder} and provides the implementation for building {@code CO2aq} instances.
     * </p>
     */
    public static final class CO2aqBuilder extends SpecieBuilder<CO2aqBuilder> {

        /**
         * Builds a new {@code CO2aq} instance using the current builder state.
         *
         * @return a new {@code CO2aq} instance
         */
        @Override
        public CO2aq build() {
            return new CO2aq(this);
        }
    }
}
