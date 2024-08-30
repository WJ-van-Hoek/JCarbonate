package com.jcarbonate.logic;

/**
 * The {@code PCO2} class represents the partial pressure of carbon dioxide (PCO2)
 * in a gas or liquid, typically measured in units such as mmHg or kPa. PCO2 is a critical
 * parameter in respiratory physiology, environmental science, and various industrial processes.
 *
 * <p>
 * In biological systems, PCO2 is a key indicator of respiratory function and acid-base balance.
 * It is closely related to the concentrations of dissolved CO2, carbonic acid (H2CO3), bicarbonate (HCO3⁻),
 * and carbonate (CO3²⁻) in blood and other fluids. Understanding PCO2 is essential for evaluating
 * gas exchange in the lungs, respiratory disorders, and the effects of environmental CO2 on ecosystems.
 * </p>
 *
 * <p>
 * This class is immutable, ensuring that once an instance is created with a specific PCO2 value,
 * that value cannot be changed. The class is also thread-safe.
 * </p>
 *
 * <p>
 * For more information on PCO2, refer to the
 * <a href="https://en.wikipedia.org/wiki/Partial_pressure#Carbon_dioxide">PCO2 Wikipedia page</a>.
 * </p>
 *
 * <p>
 * Usage example:
 *
 * <pre>
 * {@code
 * PCO2 pco2 = new PCO2.PCO2Builder().value(40.0).build();
 * Double partialPressure = pco2.getValue();
 * }
 * </pre>
 * </p>
 */
public final class PCO2 extends Specie {

    /**
     * Constructs a {@code PCO2} instance using the provided {@link PCO2Builder}.
     *
     * @param builder the {@link PCO2Builder} used to build the {@code PCO2}
     */
    private PCO2(final PCO2Builder builder) {
        super(builder);
    }

    /**
     * Returns a new {@link PCO2Builder} instance for constructing {@code PCO2}
     * objects.
     *
     * @return a new instance of {@link PCO2Builder}
     */
    public static PCO2Builder builder() {
        return new PCO2Builder();
    }

    /**
     * Builder class for creating instances of {@code PCO2}.
     * <p>
     * This class extends {@link SpecieBuilder} and provides the implementation for
     * building {@code PCO2} instances.
     * </p>
     */
    public static final class PCO2Builder extends SpecieBuilder<PCO2Builder> {

        /**
         * Builds a new {@code PCO2} instance using the current builder state.
         *
         * @return a new {@code PCO2} instance
         */
        @Override
        public PCO2 build() {
            return new PCO2(this);
        }
    }
}
