/**
 * 
 */
package org.bnl.gov.unitconversion;

import java.util.Collections;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author shroffk
 * 
 */
@XmlRootElement
public class Conversion {

    public static class ConversionDataBuilder {

	private MeasurementData measurementData;

	// These are design values
	private Double magneticLengthDesign;
	private Double defaultEnergy;

	private Double realEnergy;

	private Map<String, ConversionAlgorithm> conversionFunctions = Collections
		.emptyMap();

	private String description;

	private ConversionResult conversionResult;

	private ConversionDataBuilder() {
	}

	public static ConversionDataBuilder conversionDataOfType() {
	    return new ConversionDataBuilder();
	}

	public ConversionDataBuilder withMeasurementData(
		MeasurementData measurementData) {
	    this.measurementData = measurementData;
	    return this;
	}

	public ConversionDataBuilder withMagneticLengthDesign(
		Double magneticLengthDesign) {
	    this.magneticLengthDesign = magneticLengthDesign;
	    return this;
	}

	public ConversionDataBuilder withDefaultEnergy(Double defaultEnergy) {
	    this.defaultEnergy = defaultEnergy;
	    return this;
	}

	public ConversionDataBuilder withRealEnergy(Double realEnergy) {
	    this.realEnergy = realEnergy;
	    return this;
	}

	public ConversionDataBuilder description(String description) {
	    this.description = description;
	    return this;
	}

	public ConversionDataBuilder withConversionFunctions(
		Map<String, ConversionAlgorithm> conversionFunctions) {
	    this.conversionFunctions = conversionFunctions;
	    return this;
	}

	public ConversionDataBuilder conversionResult(
		ConversionResult conversionResult) {
	    this.conversionResult = conversionResult;
	    return this;
	}

	public Conversion build() {
	    return new Conversion(measurementData, magneticLengthDesign,
		    defaultEnergy, realEnergy, conversionFunctions,
		    description, conversionResult);
	}

    }

    private MeasurementData measurementData;

    // These are design values
    private Double magneticLengthDesign;
    private Double defaultEnergy;

    private Double realEnergy;

    private Map<String, ConversionAlgorithm> conversionFunctions;

    private String description;

    private ConversionResult conversionResult;

    private Conversion() {

    }

    /**
     * @param type
     * @param device
     * @param measurementData
     * @param magneticLengthDesign
     * @param defaultEnergy
     * @param liveBeamEnergy
     * @param conversionFunctions
     * @param description
     */
    private Conversion(MeasurementData measurementData,
	    Double magneticLengthDesign, Double defaultEnergy,
	    Double realEnergy,
	    Map<String, ConversionAlgorithm> conversionFunctions,
	    String description, ConversionResult conversionResult) {
	this.measurementData = measurementData;
	this.magneticLengthDesign = magneticLengthDesign;
	this.defaultEnergy = defaultEnergy;
	this.realEnergy = realEnergy;
	this.conversionFunctions = conversionFunctions;
	this.description = description;
	this.conversionResult = conversionResult;
    }

   
    /**
     * @return the measurementData
     */
    public MeasurementData getMeasurementData() {
        return measurementData;
    }

    /**
     * @return the magneticLengthDesign
     */
    public Double getMagneticLengthDesign() {
	return magneticLengthDesign;
    }

    /**
     * @return the defaultEnergy
     */
    public Double getDefaultEnergy() {
        return defaultEnergy;
    }

    /**
     * @return the realEnergy
     */
    public Double getRealEnergy() {
        return realEnergy;
    }

    /**
     * @return the conversionFunctions
     */
    public Map<String, ConversionAlgorithm> getConversionFunctions() {
	return Collections.unmodifiableMap(conversionFunctions);
    }

    /**
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * @return the conversionResult
     */
    public ConversionResult getConversionResult() {
	return conversionResult;
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
	result = prime
		* result
		+ ((conversionFunctions == null) ? 0 : conversionFunctions
			.hashCode());
	result = prime
		* result
		+ ((conversionResult == null) ? 0 : conversionResult.hashCode());
	result = prime * result
		+ ((defaultEnergy == null) ? 0 : defaultEnergy.hashCode());
	result = prime * result
		+ ((description == null) ? 0 : description.hashCode());
	result = prime * result
		+ ((realEnergy == null) ? 0 : realEnergy.hashCode());
	result = prime
		* result
		+ ((magneticLengthDesign == null) ? 0 : magneticLengthDesign
			.hashCode());
	result = prime * result
		+ ((measurementData == null) ? 0 : measurementData.hashCode());
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
	Conversion other = (Conversion) obj;
	if (conversionFunctions == null) {
	    if (other.conversionFunctions != null)
		return false;
	} else if (!conversionFunctions.equals(other.conversionFunctions))
	    return false;
	if (conversionResult == null) {
	    if (other.conversionResult != null)
		return false;
	} else if (!conversionResult.equals(other.conversionResult))
	    return false;
	if (defaultEnergy == null) {
	    if (other.defaultEnergy != null)
		return false;
	} else if (!defaultEnergy.equals(other.defaultEnergy))
	    return false;
	if (description == null) {
	    if (other.description != null)
		return false;
	} else if (!description.equals(other.description))
	    return false;
	if (realEnergy == null) {
	    if (other.realEnergy != null)
		return false;
	} else if (!realEnergy.equals(other.realEnergy))
	    return false;
	if (magneticLengthDesign == null) {
	    if (other.magneticLengthDesign != null)
		return false;
	} else if (!magneticLengthDesign.equals(other.magneticLengthDesign))
	    return false;
	if (measurementData == null) {
	    if (other.measurementData != null)
		return false;
	} else if (!measurementData.equals(other.measurementData))
	    return false;
	return true;
    }

}
