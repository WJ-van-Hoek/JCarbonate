package com.jcarbonate.logic;

/**
 * The {@code CarbonateSystem} class represents a model of the carbonate system in a solution, providing various
 * properties such as the partial pressure of CO2 (PCO2), pH, and the concentrations of different carbonate species
 * (CO2aq, H2CO3, HCO3-, CO3--).
 * <p>
 * This class is immutable, and once an instance is created, its state cannot be modified. The calculations are based on
 * established chemical equilibria for the carbonate system.
 * </p>
 */
public final class CarbonateSystem {

    /**
     * The partial pressure of CO2 (PCO2) in the system, measured in atmospheres (atm).
     */
    private final PCO2 _pCO2;

    /**
     * The pH of the solution, representing the acidity or alkalinity of the system.
     */
    private final PH _pH;

    /**
     * The concentration of dissolved aqueous CO2 (CO2aq) in the system, measured in moles per liter (mol/L).
     */
    private final CO2aq _co2Aq;

    /**
     * The concentration of carbonic acid (H2CO3) in the system, measured in moles per liter (mol/L).
     */
    private final H2CO3 _h2co3;

    /**
     * The concentration of bicarbonate ions (HCO3-) in the system, measured in moles per liter (mol/L).
     */
    private final HCO3 _hco3;

    /**
     * The concentration of carbonate ions (CO3--) in the system, measured in moles per liter (mol/L).
     */
    private final CO3 _co3;

    /**
     * Constructs a {@code CarbonateSystem} instance using the partial pressure of CO2 (PCO2) and pH. The concentrations
     * of other species (CO2aq, H2CO3, HCO3-, CO3--) are calculated based on these inputs.
     *
     * @param pCO2 The partial pressure of CO2 (PCO2) in atm.
     * @param pH The pH of the solution.
     */
    public CarbonateSystem(final PCO2 pCO2, final PH pH) {
        _pCO2 = pCO2;
        _pH = pH;
        _co2Aq = CO2aq.builder().value(CarbonateSystemLogic.calculateCO2Aq(_pCO2)).build();
        _h2co3 = H2CO3.builder().value(CarbonateSystemLogic.calculateH2CO3(_co2Aq)).build();
        _hco3 = HCO3.builder().value(CarbonateSystemLogic.calculateHCO3(_h2co3, _pH)).build();
        _co3 = CO3.builder().value(CarbonateSystemLogic.calculateCO3(_hco3, _pH)).build();
    }

    /**
     * Constructs a {@code CarbonateSystem} instance using the bicarbonate concentration (HCO3-) and total dissolved
     * inorganic carbon (DIC). The concentrations of other species (CO3--, H2CO3, CO2aq) and the pH are calculated based
     * on these inputs.
     *
     * @param hco3 The concentration of bicarbonate ions (HCO3-) in mol/L.
     * @param dic The total dissolved inorganic carbon (DIC) in mol/L.
     */
    public CarbonateSystem(final HCO3 hco3, final DIC dic) {
        _hco3 = hco3;
        _co3 = CO3.builder().value(CarbonateSystemLogic.calculateCO3(dic, hco3)).build();
        _h2co3 = H2CO3.builder().value(CarbonateSystemLogic.calculateH2CO3(dic, hco3, _co3)).build();
        _co2Aq = CO2aq.builder().value(CarbonateSystemLogic.calculateCO2Aq(_h2co3)).build();
        _pCO2 = new PCO2(CarbonateSystemLogic.calculatePCO2(_co2Aq));
        _pH = new PH(CarbonateSystemLogic.calculatePH(_h2co3, hco3));
    }

    /**
     * Returns the partial pressure of CO2 (PCO2) in atm.
     *
     * @return The partial pressure of CO2 (PCO2) in atm.
     */
    public Double getPCO2() {
        return _pCO2.getValue();
    }

    /**
     * Returns the pH of the solution.
     *
     * @return The pH of the solution.
     */
    public Double getPH() {
        return _pH.getValue();
    }

    /**
     * Returns the concentration of aqueous CO2 (CO2aq) in mol/L.
     *
     * @return The concentration of aqueous CO2 (CO2aq) in mol/L.
     */
    public Double getCO2Aq() {
        return _co2Aq.getValue();
    }

    /**
     * Returns the concentration of carbonic acid (H2CO3) in mol/L.
     *
     * @return The concentration of carbonic acid (H2CO3) in mol/L.
     */
    public Double getH2CO3() {
        return _h2co3.getValue();
    }

    /**
     * Returns the concentration of bicarbonate ions (HCO3-) in mol/L.
     *
     * @return The concentration of bicarbonate ions (HCO3-) in mol/L.
     */
    public Double getHCO3() {
        return _hco3.getValue();
    }

    /**
     * Returns the concentration of carbonate ions (CO3--) in mol/L.
     *
     * @return The concentration of carbonate ions (CO3--) in mol/L.
     */
    public Double getCO3() {
        return _co3.getValue();
    }

}
