package org.koushik.javabrains.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class InnvocationDemo {
  public static void main(String[] args) {
	InnvocationDemo innvocationDemo = new InnvocationDemo();
	Invocation invocation = innvocationDemo.preparedRequsetForMessagesByYear(2015);
	Response response = invocation.invoke();
	System.out.println(response.getStatus());
  }
  
  public Invocation preparedRequsetForMessagesByYear(int year) {
	  Client client = ClientBuilder.newClient();
	  return client.target("http://localhost:8080/adavnced-jax-rs/webapi/")
			  .path("messages")
			  .queryParam("year", year)
			  .request(MediaType.APPLICATION_JSON)
			  .buildGet();
  }
}
