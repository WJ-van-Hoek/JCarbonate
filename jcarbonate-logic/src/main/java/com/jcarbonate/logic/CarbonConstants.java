package com.jcarbonate.logic;

/**
 * This class represents the constants used in the carbonate system. The constants are temperature-dependent and may
 * vary with environmental conditions.
 */
public class CarbonConstants {

    /**
     * Henry's Law constant (KH) in mol/(L·atm). This constant describes the solubility of CO₂ in water.
     */
    public static final double KH = 3.3e-2; // mol/(L·atm)

    /**
     * First dissociation constant (K1) in mol/L. This constant represents the equilibrium between carbonic acid (H₂CO₃)
     * and bicarbonate (HCO₃⁻) and a hydrogen ion (H⁺).
     */
    public static final double K1 = 4.3e-7; // mol/L

    /**
     * Second dissociation constant (K2) in mol/L. This constant represents the equilibrium between bicarbonate (HCO₃⁻)
     * and carbonate (CO₃²⁻) and a hydrogen ion (H⁺).
     */
    public static final double K2 = 4.7e-11; // mol/L
}
