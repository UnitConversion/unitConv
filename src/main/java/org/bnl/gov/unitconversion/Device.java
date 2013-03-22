/**
 * 
 */
package org.bnl.gov.unitconversion;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author shroffk
 * 
 */
@XmlRootElement
public class Device {

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime
		* result
		+ ((componentTypeName == null) ? 0 : componentTypeName
			.hashCode());
	result = prime * result + installId;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + serialNumber;
	result = prime * result + ((system == null) ? 0 : system.hashCode());
	result = prime * result
		+ ((typeDescription == null) ? 0 : typeDescription.hashCode());
	result = prime * result + ((vendor == null) ? 0 : vendor.hashCode());
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
	Device other = (Device) obj;
	if (componentTypeName == null) {
	    if (other.componentTypeName != null)
		return false;
	} else if (!componentTypeName.equals(other.componentTypeName))
	    return false;
	if (installId != other.installId)
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (serialNumber != other.serialNumber)
	    return false;
	if (system == null) {
	    if (other.system != null)
		return false;
	} else if (!system.equals(other.system))
	    return false;
	if (typeDescription == null) {
	    if (other.typeDescription != null)
		return false;
	} else if (!typeDescription.equals(other.typeDescription))
	    return false;
	if (vendor == null) {
	    if (other.vendor != null)
		return false;
	} else if (!vendor.equals(other.vendor))
	    return false;
	return true;
    }

    public static class DeviceBuilder {

	private String name;
	private String system;
	private int installId;
	private String componentTypeName;
	private String typeDescription;
	private String vendor;
	private int serialNumber;

	/**
	 * 
	 */
	private DeviceBuilder() {

	}

	/**
	 * create a builder for {@link Device}
	 * 
	 * @param name
	 *            - name of device
	 * @return DeviceBuilder
	 */
	public static DeviceBuilder device(String name) {
	    DeviceBuilder deviceBuilder = new DeviceBuilder();
	    deviceBuilder.name = name;
	    return deviceBuilder;
	}

	public DeviceBuilder system(String system) {
	    this.system = system;
	    return this;
	}

	public DeviceBuilder installId(int installId) {
	    this.installId = installId;
	    return this;
	}

	public DeviceBuilder componentTypeName(String componentTypeName) {
	    this.componentTypeName = componentTypeName;
	    return this;
	}

	public DeviceBuilder typeDescription(String typeDescription) {
	    this.typeDescription = typeDescription;
	    return this;
	}

	public DeviceBuilder vendor(String vendor) {
	    this.vendor = vendor;
	    return this;
	}
	
	public DeviceBuilder serialNumber(int serialNumber){
	    this.serialNumber = serialNumber;
	    return this;
	}

	public Device build() {
	    return new Device(name, system, installId, componentTypeName,
		    typeDescription, vendor, serialNumber);
	}

    }

    private String name;
    private String system;
    @JsonProperty("install_id")
    private int installId;
    @JsonProperty("serial_number")
    private int serialNumber;
    @JsonProperty("cmpnt_type_name")
    private String componentTypeName;
    @JsonProperty("type_description")
    private String typeDescription;
    private String vendor;

    private Device(){
    }
    /**
     * @param name
     * @param system
     * @param installId
     * @param componentTypeName
     * @param typeDescription
     * @param vendor
     */
    private Device(String name, String system, int installId,
	    String componentTypeName, String typeDescription, String vendor, int serialNumber) {
	this.name = name;
	this.system = system;
	this.installId = installId;
	this.componentTypeName = componentTypeName;
	this.typeDescription = typeDescription;
	this.vendor = vendor;
	this.serialNumber = serialNumber;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the system
     */
    public String getSystem() {
        return system;
    }

    /**
     * @return the installId
     */
    public int getInstallId() {
        return installId;
    }

    /**
     * @return the serialNumber
     */
    public int getSerialNumber() {
        return serialNumber;
    }
    
    /**
     * @return the componentTypeName
     */
    public String getComponentTypeName() {
        return componentTypeName;
    }

    /**
     * @return the typeDescription
     */
    public String getTypeDescription() {
        return typeDescription;
    }

    /**
     * @return the vendor
     */
    public String getVendor() {
        return vendor;
    }
    
    
}
