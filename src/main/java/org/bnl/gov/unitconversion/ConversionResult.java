/**
 * 
 */
package org.bnl.gov.unitconversion;

import java.util.Collections;
import java.util.Map;

/**
 * @author shroffk
 * 
 */
public class ConversionResult {

    private Map<String, ConversionData> conversionInfo;

    private String message;
    private double value;
    private String unit;

    
    
    /**
     * @param conversionInfo
     * @param message
     * @param value
     * @param unit
     */
    private ConversionResult(Map<String, ConversionData> conversionInfo,
	    String message, double value, String unit) {
	this.conversionInfo = conversionInfo;
	this.message = message;
	this.value = value;
	this.unit = unit;
    }



    /**
     * @param message
     * @param value
     * @param unit
     */
    private ConversionResult(String message, double value, String unit) {
	this.message = message;
	this.value = value;
	this.unit = unit;
    }



    /**
     * @return the conversionInfo
     */
    public Map<String, ConversionData> getConversionInfo() {
        return Collections.unmodifiableMap(conversionInfo);
    }



    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }



    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }



    /**
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }
    
    

}
