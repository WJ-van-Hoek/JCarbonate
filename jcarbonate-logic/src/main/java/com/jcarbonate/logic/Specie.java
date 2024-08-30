package com.jcarbonate.logic;

import java.util.Objects;

/**
 * Abstract base class representing a species with a concentration value.
 * <p>
 * This class encapsulates the common behavior and properties for different species. The concentration value of the
 * species is immutable once set.
 * </p>
 */
public abstract class Specie {
    /**
     * The concentration value of this {@code Specie}.
     * <p>
     * This immutable field is set via the constructor and must be non-null and non-negative.
     * </p>
     */
    private final Double _value;

    /**
     * Constructs a {@code Specie} instance using the provided {@link SpecieBuilder}.
     *
     * @param builder the {@link SpecieBuilder} used to build the {@code Specie}
     */
    protected Specie(final SpecieBuilder<?> builder) {
        _value = builder.getValue();
    }

    /**
     * Returns the concentration value of this {@code Specie}.
     *
     * @return the concentration value of this {@code Specie}, never {@code null}
     */
    public final Double getValue() {
        return _value;
    }

    /**
     * Abstract static builder class for constructing {@link Specie} instances.
     * <p>
     * The builder ensures that the concentration value is non-null and non-negative.
     * </p>
     *
     * @param <T> the type of the builder subclass
     */
    protected abstract static class SpecieBuilder<T extends SpecieBuilder<T>> {
        /**
         * The concentration of the species in the solution.
         * <p>
         * This field is initialized via the builder and is immutable. It must be non-null and non-negative.
         * </p>
         */
        private Double _value;

        /**
         * Sets the concentration value of the species.
         * <p>
         * The concentration value must be non-negative. If a negative value is provided, an
         * {@link IllegalArgumentException} will be thrown.
         * </p>
         *
         * @param value the concentration value to set, which must be non-negative
         * @return this {@code SpecieBuilder} instance for chaining
         * @throws IllegalArgumentException if {@code value} is negative
         * @throws NullPointerException if {@code value} is {@code null}
         */
        @SuppressWarnings("unchecked")
        public final T value(final double value) {
            Objects.requireNonNull(value, "Specie concentration cannot be null.");
            if (value < 0) {
                throw new IllegalArgumentException("Specie concentration cannot be negative.");
            }
            _value = value;
            return (T) this;
        }

        /**
         * Returns the concentration value set in this builder.
         *
         * @return the concentration value, or {@code null} if not set
         */
        private Double getValue() {
            return _value;
        }

        /**
         * Builds a {@code Specie} instance.
         * <p>
         * Subclasses must implement this method to return an instance of a specific {@code Specie} type.
         * </p>
         *
         * @return a {@code Specie} instance
         */
        protected abstract Specie build();
    }
}
