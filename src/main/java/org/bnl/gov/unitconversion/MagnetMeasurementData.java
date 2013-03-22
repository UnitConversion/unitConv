package org.bnl.gov.unitconversion;

import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MagnetMeasurementData {

    public static class MagnetMeasurementDataBuilder {
	private List<String> direction = Collections.emptyList();
	private List<Double> current = Collections.emptyList();
	private List<Double> currentError = Collections.emptyList();
	private String currentUnit;
	private List<Double> field = Collections.emptyList();
	private List<Double> fieldError = Collections.emptyList();
	private String fieldUnit;
	private List<Double> magneticLength = Collections.emptyList();
	private Double averageMagneticLength;
	private List<Double> runNumber = Collections.emptyList();
	private int serialNumber;

	private MagnetMeasurementDataBuilder() {

	}

	public static MagnetMeasurementDataBuilder magnetMeasurements() {
	    return new MagnetMeasurementDataBuilder();
	}

	/**
	 * @param direction
	 *            the direction to set
	 */
	public MagnetMeasurementDataBuilder Direction(List<String> direction) {
	    this.direction = direction;
	    return this;
	}

	/**
	 * @param current
	 *            the current to set
	 */
	public MagnetMeasurementDataBuilder Current(List<Double> current) {
	    this.current = current;
	    return this;
	}

	/**
	 * @param currentError
	 *            the currentError to set
	 */
	public MagnetMeasurementDataBuilder CurrentError(
		List<Double> currentError) {
	    this.currentError = currentError;
	    return this;
	}

	/**
	 * @param currentUnit
	 *            the currentUnit to set
	 */
	public MagnetMeasurementDataBuilder CurrentUnit(String currentUnit) {
	    this.currentUnit = currentUnit;
	    return this;
	}

	/**
	 * @param field
	 *            the field to set
	 */
	public MagnetMeasurementDataBuilder Field(List<Double> field) {
	    this.field = field;
	    return this;
	}

	/**
	 * @param fieldError
	 *            the fieldError to set
	 */
	public MagnetMeasurementDataBuilder FieldError(List<Double> fieldError) {
	    this.fieldError = fieldError;
	    return this;
	}

	/**
	 * @param fieldUnit
	 *            the fieldUnit to set
	 */
	public MagnetMeasurementDataBuilder FieldUnit(String fieldUnit) {
	    this.fieldUnit = fieldUnit;
	    return this;
	}

	/**
	 * @param magneticLength
	 *            the magneticLength to set
	 */
	public MagnetMeasurementDataBuilder MagneticLength(
		List<Double> magneticLength) {
	    this.magneticLength = magneticLength;
	    return this;
	}

	/**
	 * @param averageMagneticLength
	 *            the averageMagneticLength to set
	 */
	public MagnetMeasurementDataBuilder AverageMagneticLength(
		Double averageMagneticLength) {
	    this.averageMagneticLength = averageMagneticLength;
	    return this;
	}

	/**
	 * @param runNumber
	 *            the runNumber to set
	 */
	public MagnetMeasurementDataBuilder RunNumber(List<Double> runNumber) {
	    this.runNumber = runNumber;
	    return this;
	}

	/**
	 * @param serialNumber
	 *            the serialNumber to set
	 */
	public MagnetMeasurementDataBuilder SerialNumber(int serialNumber) {
	    this.serialNumber = serialNumber;
	    return this;
	}

	public MagnetMeasurementData build() {
	    return new MagnetMeasurementData(this.direction, this.current,
		    this.currentError, this.currentUnit, this.field,
		    this.fieldError, this.fieldUnit, this.magneticLength,
		    this.averageMagneticLength, this.runNumber,
		    this.serialNumber);
	}
    }

    private List<String> direction;
    private List<Double> current;
    private List<Double> currentError;
    private String currentUnit;
    private List<Double> field;
    private List<Double> fieldError;
    private String fieldUnit;
    private List<Double> magneticLength;
    private Double averageMagneticLength;
    private List<Double> runNumber;
    private int serialNumber;

    private MagnetMeasurementData() {
    }

    /**
     * @param direction
     * @param current
     * @param currentUnit
     * @param field
     * @param fieldError
     * @param fieldUnit
     * @param magneticLength
     * @param averageMagneticLength
     * @param runNumber
     * @param serialNumber
     */
    private MagnetMeasurementData(List<String> direction, List<Double> current,
	    List<Double> currentError, String currentUnit, List<Double> field,
	    List<Double> fieldError, String fieldUnit,
	    List<Double> magneticLength, Double averageMagneticLength,
	    List<Double> runNumber, int serialNumber) {
	this.direction = direction;
	this.current = current;
	this.currentError = currentError;
	this.currentUnit = currentUnit;
	this.field = field;
	this.fieldError = fieldError;
	this.fieldUnit = fieldUnit;
	this.magneticLength = magneticLength;
	this.averageMagneticLength = averageMagneticLength;
	this.runNumber = runNumber;
	this.serialNumber = serialNumber;
    }

    /**
     * @return the direction
     */
    public List<String> getDirection() {
	return Collections.unmodifiableList(direction);
    }

    /**
     * @return the current
     */
    public List<Double> getCurrent() {
	return Collections.unmodifiableList(current);
    }

    /**
     * @return the currentUnit
     */
    public String getCurrentUnit() {
	return currentUnit;
    }

    /**
     * @return the field
     */
    public List<Double> getField() {
	return Collections.unmodifiableList(field);
    }

    /**
     * @return the fieldError
     */
    public List<Double> getFieldError() {
	return Collections.unmodifiableList(fieldError);
    }

    /**
     * @return the fieldUnit
     */
    public String getFieldUnit() {
	return fieldUnit;
    }

    /**
     * @return the magneticLength
     */
    public List<Double> getMagneticLength() {
	return Collections.unmodifiableList(magneticLength);
    }

    /**
     * @return the averageMagneticLength
     */
    public Double getAverageMagneticLength() {
	return averageMagneticLength;
    }

    /**
     * @return the runNumber
     */
    public List<Double> getRunNumber() {
	return Collections.unmodifiableList(runNumber);
    }

    /**
     * @return the serialNumber
     */
    public int getSerialNumber() {
	return serialNumber;
    }

    /**
     * @return the currentError
     */
    public List<Double> getCurrentError() {
        return Collections.unmodifiableList(currentError);
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
		+ ((averageMagneticLength == null) ? 0 : averageMagneticLength
			.hashCode());
	result = prime * result + ((current == null) ? 0 : current.hashCode());
	result = prime * result
		+ ((currentError == null) ? 0 : currentError.hashCode());
	result = prime * result
		+ ((currentUnit == null) ? 0 : currentUnit.hashCode());
	result = prime * result
		+ ((direction == null) ? 0 : direction.hashCode());
	result = prime * result + ((field == null) ? 0 : field.hashCode());
	result = prime * result
		+ ((fieldError == null) ? 0 : fieldError.hashCode());
	result = prime * result
		+ ((fieldUnit == null) ? 0 : fieldUnit.hashCode());
	result = prime * result
		+ ((magneticLength == null) ? 0 : magneticLength.hashCode());
	result = prime * result
		+ ((runNumber == null) ? 0 : runNumber.hashCode());
	result = prime * result + serialNumber;
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
	MagnetMeasurementData other = (MagnetMeasurementData) obj;
	if (averageMagneticLength == null) {
	    if (other.averageMagneticLength != null)
		return false;
	} else if (!averageMagneticLength.equals(other.averageMagneticLength))
	    return false;
	if (current == null) {
	    if (other.current != null)
		return false;
	} else if (!current.equals(other.current))
	    return false;
	if (currentError == null) {
	    if (other.currentError != null)
		return false;
	} else if (!currentError.equals(other.currentError))
	    return false;
	if (currentUnit == null) {
	    if (other.currentUnit != null)
		return false;
	} else if (!currentUnit.equals(other.currentUnit))
	    return false;
	if (direction == null) {
	    if (other.direction != null)
		return false;
	} else if (!direction.equals(other.direction))
	    return false;
	if (field == null) {
	    if (other.field != null)
		return false;
	} else if (!field.equals(other.field))
	    return false;
	if (fieldError == null) {
	    if (other.fieldError != null)
		return false;
	} else if (!fieldError.equals(other.fieldError))
	    return false;
	if (fieldUnit == null) {
	    if (other.fieldUnit != null)
		return false;
	} else if (!fieldUnit.equals(other.fieldUnit))
	    return false;
	if (magneticLength == null) {
	    if (other.magneticLength != null)
		return false;
	} else if (!magneticLength.equals(other.magneticLength))
	    return false;
	if (runNumber == null) {
	    if (other.runNumber != null)
		return false;
	} else if (!runNumber.equals(other.runNumber))
	    return false;
	if (serialNumber != other.serialNumber)
	    return false;
	return true;
    }
    

}