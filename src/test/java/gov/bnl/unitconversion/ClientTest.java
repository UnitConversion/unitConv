/**
 * 
 */
package gov.bnl.unitconversion;

import static gov.bnl.unitconversion.Device.DeviceBuilder.device;

import gov.bnl.unitconversion.Conversion;
import gov.bnl.unitconversion.ConversionClient;
import gov.bnl.unitconversion.Device;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
    public void testListSystems() {
	Collection<String> testSystems = Arrays.asList("Storage Ring", "Linac",
		"LBT", "Booster", "BST");
	ConversionClient client = new ConversionClient(
		"http://localhost:8000/magnets");
	Collection<String> systems;
	try {
	    systems = client.listSystems();
	    Assert.assertEquals(testSystems, systems);
	} catch (IOException e) {
	    Assert.fail(e.getMessage());
	}
    }

    @Test
    public void testFind() {
	/**
	 * {"type_description": "68mm, SHORT SEXTUPOLE", "vendor":
	 * "Danfysik, Denmark", "name": "SH1G2C30A", "install_id": 3, "system":
	 * "Storage Ring", "cmpnt_type_name": "Sext A"}
	 */
	Device device_SH1G2C30A = device("SH1G2C30A").system("Storage Ring")
		.installId(3).componentTypeName("Sext A").inventoryId(430)
		.serialNumber(79).typeDescription("68mm, SHORT SEXTUPOLE")
		.vendor("Danfysik, Denmark").build();
	ConversionClient client = new ConversionClient(
		"http://localhost:8000/magnets");
	Collection<Device> devices;
	try {
	    devices = client.findDevices("SH1G2C30A");
	    Assert.assertTrue("Failed to find device",
		    devices.contains(device_SH1G2C30A));
	} catch (IOException e) {
	    e.printStackTrace();
	}

	// When seraching for SH*G2C30A we expect 3 device returned
	//
	// {"installId": 3, "vendor": "Danfysik, Denmark", "name": "SH1G2C30A",
	// "serialNumber": "79",
	// "system": "Storage Ring", "componentType": "Sext A", "inventoryId":
	// 430,
	// "typeDescription": "68mm, SHORT SEXTUPOLE"},
	//
	// {"installId": 7, "vendor": "Danfysik, Denmark", "name": "SH3G2C30A",
	// "serialNumber": "83",
	// "system": "Storage Ring", "componentType": "Sext A", "inventoryId":
	// 434,
	// "typeDescription": "68mm, SHORT SEXTUPOLE"},
	//
	// {"installId": 9, "vendor": "Danfysik, Denmark", "name": "SH4G2C30A",
	// "serialNumber": "85",
	// "system": "Storage Ring", "componentType": "Sext A", "inventoryId":
	// 436,
	// "typeDescription": "68mm, SHORT SEXTUPOLE"}
	Device deviceSH1G2C30A = device("SH1G2C30A").installId(3)
		.vendor("Danfysik, Denmark").serialNumber(79)
		.system("Storage Ring").componentTypeName("Sext A")
		.inventoryId(430).typeDescription("68mm, SHORT SEXTUPOLE")
		.build();

	Device deviceSH3G2C30A = device("SH3G2C30A").installId(7)
		.vendor("Danfysik, Denmark").serialNumber(83)
		.system("Storage Ring").componentTypeName("Sext A")
		.inventoryId(434).typeDescription("68mm, SHORT SEXTUPOLE")
		.build();

	Device deviceSH4G2C30A = device("SH4G2C30A").installId(9)
		.vendor("Danfysik, Denmark").serialNumber(85)
		.system("Storage Ring").componentTypeName("Sext A")
		.inventoryId(436).typeDescription("68mm, SHORT SEXTUPOLE")
		.build();
	Device[] expectedDevices = { deviceSH1G2C30A, deviceSH3G2C30A,
		deviceSH4G2C30A };

	try {
	    devices = client.findDevices("SH*G2C30A");
	    Assert.assertTrue("Failed to find devices", devices.size() == 3);
	    Assert.assertArrayEquals("Device search result do not match:",
		    expectedDevices, devices.toArray(new Device[3]));
	} catch (IOException e) {
	    Assert.fail(e.getMessage());
	}

    }

    @Test
    public void testConversion() {
	ConversionClient client = new ConversionClient(
		"http://localhost:8000/magnets");
	try {
	    Map<String, Map<String, Conversion>> info = client
		    .getConversionInfo("LN-SO5");
	} catch (Exception e) {
	    Assert.fail(e.getMessage());
	}

    }

}
