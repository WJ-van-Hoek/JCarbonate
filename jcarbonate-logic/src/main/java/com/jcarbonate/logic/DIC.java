package com.jcarbonate.logic;

/**
 * The {@code DIC} class represents the concentration of dissolved inorganic carbon (DIC) in a given context, typically
 * measured in units such as mmol/L. DIC refers to the sum of carbon dioxide (CO₂), carbonic acid (H₂CO₃), bicarbonate
 * (HCO₃⁻), and carbonate (CO₃²⁻) in a solution. This class is immutable, ensuring that once an instance is created with
 * a specific value, that value cannot be changed.
 *
 * <p>
 * In environmental science and aquatic chemistry, DIC is a crucial parameter for understanding carbon cycling and
 * buffering capacity in natural waters. In biological systems, DIC plays a key role in maintaining acid-base balance
 * and supporting various biochemical processes. Accurate measurement and representation of DIC concentration are
 * essential in studies of oceanography, limnology, and climate science.
 *
 * <p>
 * For more information on dissolved inorganic carbon, refer to the
 * <a href="https://en.wikipedia.org/wiki/Dissolved_inorganic_carbon"> Dissolved Inorganic Carbon Wikipedia page</a>.
 */
public final class DIC extends Specie {

    /**
     * Constructs a {@code DIC} instance using the provided {@link DICBuilder}.
     *
     * @param builder the {@link DICBuilder} used to build the {@code DIC}
     */
    private DIC(final DICBuilder builder) {
        super(builder);
    }

    /**
     * Returns a new {@link DICBuilder} instance for constructing {@code DIC} objects.
     *
     * @return a new instance of {@link DICBuilder}
     */
    public static DICBuilder builder() {
        return new DICBuilder();
    }

    /**
     * Builder class for creating instances of {@code DIC}.
     * <p>
     * This class extends {@link SpecieBuilder} and provides the implementation for building {@code DIC} instances.
     * </p>
     */
    protected static final class DICBuilder extends SpecieBuilder<DICBuilder> {

        /**
         * Builds a new {@code DIC} instance using the current builder state.
         *
         * @return a new {@code DIC} instance
         */
        @Override
        public DIC build() {
            return new DIC(this);
        }

        @Override
        protected DICBuilder self() {
            return this;
        }
    }
}
