package com.jcarbonate.logic;

/**
 * The {@code PCO2} class represents the partial pressure of CO2 in a system, typically measured in atmospheres (atm).
 * This class is immutable and thread-safe.
 */
public final class PCO2 {

    /**
     * The partial pressure of CO2, in atmospheres (atm).
     */
    private final double _value;

    /**
     * Constructs a {@code PCO2} instance with the specified value.
     *
     * @param value The partial pressure of CO2 in atm.
     */
    public PCO2(double value) {
    	_value = value;
    }

    /**
     * Returns the partial pressure of CO2.
     *
     * @return The partial pressure of CO2 in atm.
     */
    public double getValue() {
        return _value;
    }
}
