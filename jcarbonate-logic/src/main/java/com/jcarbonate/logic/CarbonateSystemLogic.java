package com.jcarbonate.logic;

import java.util.Objects;

/**
 * The {@code CarbonateSystemLogic} class provides a set of static methods to perform calculations related to carbonate
 * system chemistry, including the concentrations of various species (e.g., CO2, HCO3-, CO3--) and pH.
 * <p>
 * This class is immutable and thread-safe.
 * </p>
 */
public final class CarbonateSystemLogic {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private CarbonateSystemLogic() {
    }

    /**
     * Calculates the partial pressure of CO2 (PCO2) given the concentration of aqueous CO2 (CO2aq).
     *
     * @param co2Aq The concentration of aqueous CO2 (CO2aq) in mol/L.
     * @return The partial pressure of CO2 (PCO2) in atm.
     * @throws NullPointerException if {@code co2Aq} is {@code null}.
     */
    public static double calculatePCO2(final CO2aq co2Aq) {
        Objects.requireNonNull(co2Aq, "co2Aq is needed to calculate PCO2");
        return co2Aq.getValue() / CarbonConstants.KH;
    }

    /**
     * Calculates the concentration of aqueous CO2 (CO2aq) given the partial pressure of CO2 (PCO2).
     *
     * @param pCO2 The partial pressure of CO2 (PCO2) in atm.
     * @return The concentration of aqueous CO2 (CO2aq) in mol/L.
     * @throws NullPointerException if {@code pCO2} is {@code null}.
     */
    public static double calculateCO2Aq(final PCO2 pCO2) {
        Objects.requireNonNull(pCO2, "pCO2 is needed to calculate CO2Aq concentration");
        return CarbonConstants.KH * pCO2.getValue();
    }

    /**
     * Returns the concentration of aqueous CO2 (CO2aq), assuming it is equivalent to the concentration of carbonic acid
     * (H2CO3).
     *
     * @param h2co3 The concentration of carbonic acid (H2CO3) in mol/L.
     * @return The concentration of aqueous CO2 (CO2aq) in mol/L.
     * @throws NullPointerException if {@code h2co3} is {@code null}.
     */
    public static double calculateCO2Aq(final H2CO3 h2co3) {
        Objects.requireNonNull(h2co3, "h2co3 is needed to calculate CO2Aq concentration");
        return h2co3.getValue();
    }

    /**
     * Calculates the concentration of carbonic acid (H2CO3) given the concentration of aqueous CO2 (CO2aq).
     *
     * @param co2Aq The concentration of aqueous CO2 (CO2aq) in mol/L.
     * @return The concentration of carbonic acid (H2CO3) in mol/L.
     * @throws NullPointerException if {@code co2Aq} is {@code null}.
     */
    public static double calculateH2CO3(final CO2aq co2Aq) {
        Objects.requireNonNull(co2Aq, "co2Aq is needed to calculate H2CO3 concentration");
        return co2Aq.getValue();
    }

    /**
     * Calculates the concentration of carbonic acid (H2CO3) given the total dissolved inorganic carbon (DIC),
     * bicarbonate (HCO3-), and carbonate (CO3--).
     *
     * @param dic The total dissolved inorganic carbon (DIC) concentration in mol/L.
     * @param hco3 The concentration of bicarbonate ions (HCO3-) in mol/L.
     * @param co3 The concentration of carbonate ions (CO3--) in mol/L.
     * @return The concentration of carbonic acid (H2CO3) in mol/L.
     * @throws NullPointerException if {@code dic}, {@code hco3}, or {@code co3} is {@code null}.
     */
    public static double calculateH2CO3(final DIC dic, final HCO3 hco3, final CO3 co3) {
        Objects.requireNonNull(dic, "dic is needed to calculate H2CO3 concentration");
        Objects.requireNonNull(hco3, "hco3 is needed to calculate H2CO3 concentration");
        Objects.requireNonNull(co3, "co3 is needed to calculate H2CO3 concentration");
        return dic.getValue() - hco3.getValue() - co3.getValue();
    }

    /**
     * Calculates the concentration of bicarbonate ions (HCO3-) given the concentration of carbonic acid (H2CO3) and the
     * pH of the solution.
     *
     * @param h2co3 The concentration of carbonic acid (H2CO3) in mol/L.
     * @param pH The pH of the solution.
     * @return The concentration of bicarbonate ions (HCO3-) in mol/L.
     * @throws NullPointerException if {@code h2co3} or {@code pH} is {@code null}.
     */
    public static double calculateHCO3(final H2CO3 h2co3, final PH pH) {
        Objects.requireNonNull(h2co3, "h2co3 is needed to calculate HCO3 concentration");
        Objects.requireNonNull(pH, "pH is needed to calculate HCO3 concentration");
        final double hPlus = Math.pow(10, -pH.getValue());
        return (CarbonConstants.K1 * h2co3.getValue()) / hPlus;
    }

    /**
     * Calculates the concentration of carbonate ions (CO3--) given the concentration of bicarbonate ions (HCO3-) and
     * the pH of the solution.
     *
     * @param hco3 The concentration of bicarbonate ions (HCO3-) in mol/L.
     * @param pH The pH of the solution.
     * @return The concentration of carbonate ions (CO3--) in mol/L.
     * @throws NullPointerException if {@code hco3} or {@code pH} is {@code null}.
     */
    public static double calculateCO3(final HCO3 hco3, final PH pH) {
        Objects.requireNonNull(hco3, "hco3 is needed to calculate CO3 concentration");
        Objects.requireNonNull(pH, "pH is needed to calculate CO3 concentration");
        final double hPlus = Math.pow(10, -pH.getValue());
        return (CarbonConstants.K2 * hco3.getValue()) / hPlus;
    }

    /**
     * Calculates the concentration of carbonate ions (CO3--) given the total dissolved inorganic carbon (DIC) and
     * bicarbonate ions (HCO3-). The calculation is iterative and adjusts for the presence of CO3--.
     *
     * @param dic The total dissolved inorganic carbon (DIC) concentration in mol/L.
     * @param hco3 The concentration of bicarbonate ions (HCO3-) in mol/L.
     * @return The concentration of carbonate ions (CO3--) in mol/L.
     * @throws NullPointerException if {@code dic} or {@code hco3} is {@code null}.
     */
    public static double calculateCO3(final DIC dic, final HCO3 hco3) {
        Objects.requireNonNull(dic, "dic is needed to calculate CO3 concentration");
        Objects.requireNonNull(hco3, "hco3 is needed to calculate CO3 concentration");
        double co3;
        double error;
        double co2 = dic.getValue() - hco3.getValue();

        final double tolerance = 1e-6;
        do {
            // Calculate CO3^2- using the second dissociation constant
            co3 = (CarbonConstants.K2 * hco3.getValue()) / (co2 * (CarbonConstants.K1 / hco3.getValue()));

            // Recalculate CO2 based on updated CO3^2- value
            final double newCo2 = dic.getValue() - hco3.getValue() - co3;

            // Calculate the error (difference between old and new CO2 values)
            error = Math.abs(newCo2 - co2);

            // Update CO2 value
            co2 = newCo2;
        } while (error > tolerance);
        return co3;
    }

    /**
     * Calculates the pH of the solution given the concentration of carbonic acid (H2CO3) and bicarbonate ions (HCO3-).
     *
     * @param h2co3 The concentration of carbonic acid (H2CO3) in mol/L.
     * @param hco3 The concentration of bicarbonate ions (HCO3-) in mol/L.
     * @return The pH of the solution.
     * @throws NullPointerException if {@code h2co3} or {@code hco3} is {@code null}.
     */
    public static double calculatePH(final H2CO3 h2co3, final HCO3 hco3) {
        Objects.requireNonNull(h2co3, "h2co3 is needed to calculate pH");
        Objects.requireNonNull(hco3, "hco3 is needed to calculate pH");
        final double hPlus = (CarbonConstants.K1 * h2co3.getValue()) / hco3.getValue();
        return -Math.log(hPlus);
    }

    /**
     * Calculates the partial pressure of CO2 (PCO2) given the total dissolved inorganic carbon (DIC) and bicarbonate
     * ions (HCO3-).
     *
     * @param dic The total dissolved inorganic carbon (DIC) concentration in mol/L.
     * @param hco3 The concentration of bicarbonate ions (HCO3-) in mol/L.
     * @return The partial pressure of CO2 (PCO2) in atm.
     * @throws NullPointerException if {@code dic} or {@code hco3} is {@code null}.
     */
    public static double calculatePCO2(final double dic, final double hco3) {
        Objects.requireNonNull(dic, "dic is needed to calculate CO3 concentration");
        Objects.requireNonNull(hco3, "hco3 is needed to calculate CO3 concentration");
        // Initial guesses for CO2
        final double co2 = dic - hco3; // Assuming CO3^2- is negligible initially

        // Iteratively solve for CO2 and CO3^2-
        final double tolerance = 1e-6;

        return calculatePCO2(dic, hco3, co2, tolerance);
    }

    /**
     * Helper method to calculate the partial pressure of CO2 (PCO2) given DIC, HCO3-, and an initial guess for CO2. The
     * calculation is iterative until the result converges within a specified tolerance.
     *
     * @param dic The total dissolved inorganic carbon (DIC) concentration in mol/L.
     * @param hco3 The concentration of bicarbonate ions (HCO3-) in mol/L.
     * @param co2 Initial guess for the concentration of aqueous CO2 (CO2aq) in mol/L.
     * @param tolerance The tolerance for iterative calculation (e.g., 1e-6).
     * @return The calculated partial pressure of CO2 (PCO2) in atm.
     */
    private static double calculatePCO2(final double dic, final double hco3, final double co2, final double tolerance) {
        double co3;
        double error;
        double co2Calculated;
        do {
            // Calculate CO3^2- using the second dissociation constant
            co3 = (CarbonConstants.K2 * hco3) / (co2 * (CarbonConstants.K1 / hco3));

            // Recalculate CO2 based on updated CO3^2- value
            final double newCo2 = dic - hco3 - co3;

            // Calculate the error (difference between old and new CO2 values)
            error = Math.abs(newCo2 - co2);

            // Update CO2 value
            co2Calculated = newCo2;
        } while (error > tolerance);

        // Set results
        return co2Calculated;
    }
}
