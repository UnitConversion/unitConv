/**
 * 
 */
package gov.bnl.unitconversion;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;
import org.codehaus.jackson.type.TypeReference;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.core.util.MultivaluedMapImpl;

/**
 * @author shroffk
 * 
 */
public class ConversionClient {

    private WebResource service;

    public ConversionClient(String serviceURL) {
	ClientConfig clientConfig = new DefaultClientConfig();
	clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
		Boolean.TRUE);
	Client client = Client.create(clientConfig);
	service = client.resource(UriBuilder.fromUri(serviceURL).build());
    }

    /**
     * List all the systems
     * 
     * @return Collection of system names
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public Collection<String> listSystems() throws IOException {
	ClientResponse clientResponse = service.path("system")
		.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
	if (clientResponse.getStatus() < 300) {
	    return clientResponse.getEntity(List.class);
	} else {
	    throw new IOException("Failed with error code : "
		    + clientResponse.getStatus());
	}
    }

    public Collection<Device> findDevices(String name) throws IOException {
	MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
	queryParams.add("name", name);
	return findDevices(queryParams);
    }

    public Collection<Device> findDevices(
	    MultivaluedMap<String, String> searchParameters) throws IOException {
	ClientResponse clientResponse = service.path("devices")
		.queryParams(searchParameters)
		.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
	if (clientResponse.getStatus() < 300) {
	    Collection<Device> devices = Arrays.asList(clientResponse
		    .getEntity(Device[].class));
	    return devices;
	} else {
	    throw new IOException("Failed with error code : "
		    + clientResponse.getStatus());
	}
    }

    public Collection<Device> getConversionInfo(String name)
	    throws JsonParseException, JsonMappingException,
	    ClientHandlerException, UniformInterfaceException, IOException {
	MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
	queryParams.add("name", name);
	return getConversionInfo(queryParams);
    }

    public Collection<Device> getConversionInfo(
	    MultivaluedMap<String, String> searchParameters) throws IOException {
	ClientResponse clientResponse = service.path("conversion")
		.queryParams(searchParameters)
		.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
	if (clientResponse.getStatus() < 300) {
	    String devices = clientResponse.getEntity(String.class);
	    System.out.println(devices);
	    ObjectMapper mapper = new ObjectMapper();

	    JsonFactory f = new JsonFactory();
	    JsonParser jp = f.createJsonParser(devices);

	    ObjectReader reader = mapper.reader(Device.class);
	    JsonNode tree = mapper.readTree(devices);
	    for (JsonNode jsonNode : tree) {
//		Device test = reader.readValue(jsonNode);
		Map<String, Map<String, Conversion>> parsedComplexMap = mapper
			.readValue(
				jsonNode,
				new TypeReference<HashMap<String, HashMap<String, Conversion>>>() {
				});
	    }
	    jp.nextToken();
	    while (jp.nextToken() != JsonToken.END_OBJECT) {
		String token = jp.getCurrentName();
		System.out.println(token + ":" + jp.getText());
		Device d = jp.readValueAs(new TypeReference<Device>() {

		});
	    }
	    return null;
	} else {
	    throw new IOException("Failed with error code : "
		    + clientResponse.getStatus());
	}
    }
}