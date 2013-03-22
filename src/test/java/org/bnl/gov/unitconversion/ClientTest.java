/**
 * 
 */
package org.bnl.gov.unitconversion;

import static org.bnl.gov.unitconversion.Device.DeviceBuilder.device;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.sun.jersey.api.client.Client;

/**
 * @author shroffk
 * 
 */
public class ClientTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testCreateClient() {

	String serviceURL = "http://localhost:8000/magnets";
	ConversionClient client = new ConversionClient(serviceURL);

	exception.expect(IOException.class);
	client = new ConversionClient("https://localhost:9432/magnets");

    }

    @Test
    public void testFindSystems() {
	Collection<String> testSystems = Arrays.asList("Storage Ring", "Linac",
		"LBT", "Booster", "BST");
	ConversionClient client = new ConversionClient(
		"http://localhost:8000/magnets");
	Collection<String> systems;
	try {
	    systems = client.listSystems();
	    Assert.assertEquals(testSystems, systems);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    @Test
    public void testFind() {
	/**
	 * {"type_description": "68mm, SHORT SEXTUPOLE", "vendor":
	 * "Danfysik, Denmark", "name": "SH1G2C30A", "install_id": 3, "system":
	 * "Storage Ring", "cmpnt_type_name": "Sext A"}
	 */
	Device device = device("SH1G2C30A").system("Storage Ring").installId(3)
		.componentTypeName("Sext A")
		.typeDescription("68mm, SHORT SEXTUPOLE")
		.vendor("Danfysik, Denmark").build();
	ConversionClient client = new ConversionClient(
		"http://localhost:8000/magnets");
	Collection<Device> devices;
	try {
	    devices = client.findDevices("SH1G2C30A");
	    Assert.assertTrue("Failed to find device", devices.contains(device));
	} catch (IOException e) {
	    e.printStackTrace();
	}

	// When seraching for SH*G2C30A
	//
	// [{"type_description": "68mm, SHORT SEXTUPOLE", "vendor":
	// "Danfysik, Denmark", "name": "SH1G2C30A", "install_id": 3, "system":
	// "Storage Ring", "cmpnt_type_name": "Sext A"}, {"type_description":
	// "68mm, SHORT SEXTUPOLE", "vendor": "Danfysik, Denmark", "name":
	// "SH3G2C30A", "install_id": 7, "system": "Storage Ring",
	// "cmpnt_type_name": "Sext A"}, {"type_description":
	// "68mm, SHORT SEXTUPOLE", "vendor": "Danfysik, Denmark", "name":
	// "SH4G2C30A", "install_id": 9, "system": "Storage Ring",
	// "cmpnt_type_name": "Sext A"}]
	
	try {
	    devices = client.findDevices("SH*G2C30A");
	    Assert.assertTrue("Failed to find device", devices.size() == 3);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	

    }

    @Test
    public void testConversion() {
	ConversionClient client = new ConversionClient(
		"http://localhost:8000/magnets");
	try {
	    Map<String, ConversionData> info = client.getConversionInfo("LN-SO5");
	} catch (Exception e) {
	    Assert.fail(e.getMessage());
	}

    }

}
