/**
 * 
 */
package org.bnl.gov.unitconversion;

/**
 * @author shroffk
 * 
 */
public class ConversionAlgorithm {
    private int identifier;
    private String function;
    private int auxInfo;
    private String initialUnit;
    private String finalUnit;
    
    private ConversionAlgorithm() {

    }

    /**
     * @param identifier
     * @param function
     * @param auxInfo
     * @param initialUnit
     * @param finalUnit
     */
    private ConversionAlgorithm(int identifier, String function, int auxInfo,
	    String initialUnit, String finalUnit) {
	this.identifier = identifier;
	this.function = function;
	this.auxInfo = auxInfo;
	this.initialUnit = initialUnit;
	this.finalUnit = finalUnit;
    }

    /**
     * @return the identifier
     */
    public int getIdentifier() {
	return identifier;
    }

    /**
     * @return the function
     */
    public String getFunction() {
	return function;
    }

    /**
     * @return the additionalAttributes
     */
    public int getAuxInfo() {
	return auxInfo;
    }    
    
    /**
     * @return the initialUnit
     */
    public String getInitialUnit() {
        return initialUnit;
    }

    /**
     * @return the finalUnit
     */
    public String getFinalUnit() {
        return finalUnit;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + auxInfo;
	result = prime * result
		+ ((function == null) ? 0 : function.hashCode());
	result = prime * result + identifier;
	return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	ConversionAlgorithm other = (ConversionAlgorithm) obj;
	if (auxInfo != other.auxInfo)
	    return false;
	if (function == null) {
	    if (other.function != null)
		return false;
	} else if (!function.equals(other.function))
	    return false;
	if (identifier != other.identifier)
	    return false;
	return true;
    }
    
    public static class ConversionAlogrithmBuilder {
	private int identifier;
	private String function;
	private int auxInfo = 0;
	private String initialUnit;
	private String finalUnit;

	/**
	 * @param identifier
	 * @param function
	 */
	private ConversionAlogrithmBuilder(int identifier, String function) {
	    this.identifier = identifier;
	    this.function = function;
	}

	/**
	 * @param identifier
	 */
	private ConversionAlogrithmBuilder(int identifier) {
	    this.identifier = identifier;
	}

	public static ConversionAlogrithmBuilder conversionAlgorithm(
		int identifier) {
	    return new ConversionAlogrithmBuilder(identifier);
	}

	public static ConversionAlogrithmBuilder conversionAlgorithm(
		int identifier, String function) {
	    return new ConversionAlogrithmBuilder(identifier, function);
	}

	public ConversionAlogrithmBuilder withFunction(String function) {
	    this.function = function;
	    return this;
	}

	public ConversionAlogrithmBuilder withAuxInfo(int auxInfo) {
	    this.auxInfo = auxInfo;
	    return this;
	}

	public ConversionAlogrithmBuilder withinitialUnit(String initialUnit) {
	    this.initialUnit = initialUnit;
	    return this;
	}

	public ConversionAlogrithmBuilder withfinalUnit(String finalUnit) {
	    this.finalUnit = finalUnit;
	    return this;
	}

	public ConversionAlgorithm build() {
	    return new ConversionAlgorithm(identifier, function, auxInfo,
		    initialUnit, finalUnit);
	}
    }


}
