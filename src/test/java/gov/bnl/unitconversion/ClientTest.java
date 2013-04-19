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

import javax.ws.rs.core.MultivaluedMap;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.rules.ExpectedException;

import com.sun.jersey.core.util.MultivaluedMapImpl;

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
    public void testFindDeviceByName() {
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
    public void testFindDevice() {
	// {"installId": 717,
	// "vendor": "BINP, Russia",
	// "name": "QH2G6C23B",
	// "serialNumber": "12",
	// "system": "Storage Ring",
	// "componentType": "Quad Cp",
	// "inventoryId": 111,
	// "typeDescription": "66mm, LONG, DBL COIL KINKED QUAD"}
	Device deviceQH2G6C23B = device("QH2G6C23B").installId(717)
		.vendor("BINP, Russia").serialNumber(12).system("Storage Ring")
		.componentTypeName("Quad Cp").inventoryId(111)
		.typeDescription("66mm, LONG, DBL COIL KINKED QUAD").build();

	// QM2G4C01B

	// A1SD2

	Collection<Device> results;
	ConversionClient client = new ConversionClient(
		"http://localhost:8000/magnets");
	MultivaluedMap<String, String> searchParameters = new MultivaluedMapImpl();
	try {
	    // Search by system
	    searchParameters.add("system", "Storage Ring");
	    results = client.findDevices(searchParameters);
	    Assert.assertTrue("Failed to search by system",
		    results.contains(deviceQH2G6C23B));
	    // Search by installId
	    searchParameters.clear();
	    searchParameters.add("installId", String.valueOf(717));
	    results = client.findDevices(searchParameters);
	    Assert.assertTrue("Failed to search by installId",
		    results.contains(deviceQH2G6C23B));
	    // Search by serialNumber
	    searchParameters.clear();
	    searchParameters.add("serialNumber", String.valueOf(12));
	    results = client.findDevices(searchParameters);
	    Assert.assertTrue("Failed to search by serialNumber",
		    results.contains(deviceQH2G6C23B));
	    // Search by inventoryId
	    searchParameters.clear();
	    searchParameters.add("inventoryId", String.valueOf(111));
	    results = client.findDevices(searchParameters);
	    Assert.assertTrue("Failed to search by inventoryId",
		    results.contains(deviceQH2G6C23B));
	    // Search by vendor
	    searchParameters.clear();
	    searchParameters.add("vendor", "BINP, Russia");
	    results = client.findDevices(searchParameters);
	    Assert.assertTrue("Failed to search by vendor",
		    results.contains(deviceQH2G6C23B));
	    // Search by componentType
	    searchParameters.clear();
	    searchParameters.add("componentType", "Quad Cp");
	    results = client.findDevices(searchParameters);
	    Assert.assertTrue("Failed to search by componentType",
		    results.contains(deviceQH2G6C23B));
	    // Search by typeDescription
	    searchParameters.clear();
	    searchParameters.add("typeDescription",
		    "66mm, LONG, DBL COIL KINKED QUAD");
	    results = client.findDevices(searchParameters);
	    Assert.assertTrue("Failed to search by typeDescription",
		    results.contains(deviceQH2G6C23B));
	} catch (Exception e) {
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