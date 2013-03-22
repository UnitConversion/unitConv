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
    private int additionalAttributes;

    private ConversionAlgorithm() {

    }

    public ConversionAlgorithm(int identifier, String function) {
	this.identifier = identifier;
	this.function = function;
	this.additionalAttributes = 0;
    }

    public ConversionAlgorithm(int identifier, String function,
	    int additionalAttributes) {
	this.identifier = identifier;
	this.function = function;
	this.additionalAttributes = additionalAttributes;
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
    public int getAdditionalAttributes() {
	return additionalAttributes;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + additionalAttributes;
	result = prime * result
		+ ((function == null) ? 0 : function.hashCode());
	result = prime * result + identifier;
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
	ConversionAlgorithm other = (ConversionAlgorithm) obj;
	if (additionalAttributes != other.additionalAttributes)
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
    

}
