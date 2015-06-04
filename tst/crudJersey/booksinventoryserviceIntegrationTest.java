package crudJersey;

import javax.ws.rs.core.MediaType;

import org.junit.*;

import static org.junit.Assert.assertEquals;

import com.exp.ws.rs.Book;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class booksinventoryserviceIntegrationTest {

	 
  //client.callPost();// create
  //client.callGet(); // read 


 // client.callPut(); // update
 // client.callDelete(); // delete
	 
	 @Before
	    public void setUp() throws Exception {

		 @SuppressWarnings("unused")
		booksinventoryserviceIntegrationTest client = new booksinventoryserviceIntegrationTest();
	 }

@Test
public void callPost() {
		  Client client = getClient();
		  WebResource resource = client
		    .resource("http://localhost:8080/crudJersey/api/booksinventoryservice/post");
		  Book book = new Book("1-b", "NewBook");
		  ClientResponse response = resource.accept(MediaType.APPLICATION_JSON)
		    .type(MediaType.APPLICATION_JSON)
		    .post(ClientResponse.class, book);
		  System.out.println("status: " + response.getStatus());
		  assertEquals(String.format("Response code of POST should match: %d,%d",response.getStatus(),204),response.getStatus(),204);
		 }

 @Test
 public void callGet() {
  Client client = getClient();
  WebResource resource = client
    .resource("http://localhost:8080/crudJersey/api/booksinventoryservice/get");
  ClientResponse response = resource.queryParam("isbn", "1-b")
    .accept(MediaType.APPLICATION_JSON)
    .type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
  System.out.println("Call status: " + response.getStatus());
  Book book = response.getEntity(Book.class);
  assertEquals(String.format("Book isbn should match: %s,%s",book.getIsbn(),"1-b"),book.getIsbn(),"1-b");
 }


@Test
 public void callPut() {
  Client client = getClient();
  WebResource resource = client
    .resource("http://localhost:8080/crudJersey/api/booksinventoryservice/put");
  Book book = new Book("1-b", "NewBookUpdated");
  ClientResponse response = resource.accept(MediaType.APPLICATION_JSON)
    .type(MediaType.APPLICATION_JSON)
    .put(ClientResponse.class, book);
  assertEquals(String.format("Response code of PUT should match: %s,%s",response.getStatus(),204),response.getStatus(),204);
 }

@Test
 public void callDelete() {
  Client client = getClient();
  WebResource resource = client
    .resource("http://localhost:8080/crudJersey/api/booksinventoryservice/delete");
  ClientResponse response = resource.queryParam("isbn", "1-b").delete(
    ClientResponse.class);
  assertEquals(String.format("Response code of DELETE should match: %s,%s",response.getStatus(),204),response.getStatus(),204);

 }

 private Client getClient() {
  ClientConfig clientConfig = new DefaultClientConfig();
  clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,
    Boolean.TRUE);
  Client client = Client.create(clientConfig);
  return client;
 }
}
