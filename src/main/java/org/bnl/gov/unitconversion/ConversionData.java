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
public class ConversionData {

    public static class ConversionDataBuilder {
	private String type = "standard";

	private Device device;

	private MagnetMeasurementData magnetMeasurementData;

	// These are design values
	private Double magneticLengthDesign;
	private Double defaultBeamEnergy;

	private Double liveBeamEnergy;

	private Map<String, ConversionAlgorithm> conversionFunctions = Collections
		.emptyMap();

	private String description;

	private ConversionDataBuilder(String type) {
	    this.type = type;
	}

	public static ConversionDataBuilder conversionDataOfType(String type) {
	    return new ConversionDataBuilder(type);
	}

	public ConversionDataBuilder forDevice(Device device) {
	    this.device = device;
	    return this;
	}

	public ConversionDataBuilder withMagnetMeasurementData(
		MagnetMeasurementData magnetMeasurementData) {
	    this.magnetMeasurementData = magnetMeasurementData;
	    return this;
	}

	public ConversionDataBuilder withMagneticLengthDesign(
		Double magneticLengthDesign) {
	    this.magneticLengthDesign = magneticLengthDesign;
	    return this;
	}

	public ConversionDataBuilder withDefaultBeamEnergy(
		Double defaultBeamEnergy) {
	    this.defaultBeamEnergy = defaultBeamEnergy;
	    return this;
	}

	public ConversionDataBuilder withLiveBeamEnergy(Double liveBeamEnergy) {
	    this.liveBeamEnergy = liveBeamEnergy;
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

	public ConversionData build() {
	    return new ConversionData(type, device, magnetMeasurementData,
		    magneticLengthDesign, defaultBeamEnergy, liveBeamEnergy,
		    conversionFunctions, description);
	}

    }

    private String type;

    private Device device;

    private MagnetMeasurementData magnetMeasurementData;

    // These are design values
    private Double magneticLengthDesign;
    private Double defaultBeamEnergy;

    private Double liveBeamEnergy;

    private Map<String, ConversionAlgorithm> conversionFunctions;

    private String description;

    
    private ConversionData(){
	
    }
    /**
     * @param type
     * @param device
     * @param magnetMeasurementData
     * @param magneticLengthDesign
     * @param defaultBeamEnergy
     * @param liveBeamEnergy
     * @param conversionFunctions
     * @param description
     */
    private ConversionData(String type, Device device,
	    MagnetMeasurementData magnetMeasurementData,
	    Double magneticLengthDesign, Double defaultBeamEnergy,
	    Double liveBeamEnergy,
	    Map<String, ConversionAlgorithm> conversionFunctions,
	    String description) {
	this.type = type;
	this.device = device;
	this.magnetMeasurementData = magnetMeasurementData;
	this.magneticLengthDesign = magneticLengthDesign;
	this.defaultBeamEnergy = defaultBeamEnergy;
	this.liveBeamEnergy = liveBeamEnergy;
	this.conversionFunctions = conversionFunctions;
	this.description = description;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @return the device
     */
    public Device getDevice() {
        return device;
    }

    /**
     * @return the magnetMeasurementData
     */
    public MagnetMeasurementData getMagnetMeasurementData() {
        return magnetMeasurementData;
    }

    /**
     * @return the magneticLengthDesign
     */
    public Double getMagneticLengthDesign() {
        return magneticLengthDesign;
    }

    /**
     * @return the defaultBeamEnergy
     */
    public Double getDefaultBeamEnergy() {
        return defaultBeamEnergy;
    }

    /**
     * @return the liveBeamEnergy
     */
    public Double getLiveBeamEnergy() {
        return liveBeamEnergy;
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
    /* (non-Javadoc)
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
		+ ((defaultBeamEnergy == null) ? 0 : defaultBeamEnergy
			.hashCode());
	result = prime * result
		+ ((description == null) ? 0 : description.hashCode());
	result = prime * result + ((device == null) ? 0 : device.hashCode());
	result = prime * result
		+ ((liveBeamEnergy == null) ? 0 : liveBeamEnergy.hashCode());
	result = prime
		* result
		+ ((magnetMeasurementData == null) ? 0 : magnetMeasurementData
			.hashCode());
	result = prime
		* result
		+ ((magneticLengthDesign == null) ? 0 : magneticLengthDesign
			.hashCode());
	result = prime * result + ((type == null) ? 0 : type.hashCode());
	return result;
    }
    /* (non-Javadoc)
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
	ConversionData other = (ConversionData) obj;
	if (conversionFunctions == null) {
	    if (other.conversionFunctions != null)
		return false;
	} else if (!conversionFunctions.equals(other.conversionFunctions))
	    return false;
	if (defaultBeamEnergy == null) {
	    if (other.defaultBeamEnergy != null)
		return false;
	} else if (!defaultBeamEnergy.equals(other.defaultBeamEnergy))
	    return false;
	if (description == null) {
	    if (other.description != null)
		return false;
	} else if (!description.equals(other.description))
	    return false;
	if (device == null) {
	    if (other.device != null)
		return false;
	} else if (!device.equals(other.device))
	    return false;
	if (liveBeamEnergy == null) {
	    if (other.liveBeamEnergy != null)
		return false;
	} else if (!liveBeamEnergy.equals(other.liveBeamEnergy))
	    return false;
	if (magnetMeasurementData == null) {
	    if (other.magnetMeasurementData != null)
		return false;
	} else if (!magnetMeasurementData.equals(other.magnetMeasurementData))
	    return false;
	if (magneticLengthDesign == null) {
	    if (other.magneticLengthDesign != null)
		return false;
	} else if (!magneticLengthDesign.equals(other.magneticLengthDesign))
	    return false;
	if (type == null) {
	    if (other.type != null)
		return false;
	} else if (!type.equals(other.type))
	    return false;
	return true;
    }
       
    

}
