package org.koushik.javabrains.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.koushik.javabrains.messenger.model.Message;

public class RestAppClient {
	
	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		
		//Best pratice to write target path of the server uri.
		
		WebTarget baseTarget = client.target("http://localhost:8080/adavnced-jax-rs/webapi/");
		WebTarget messageTarget = baseTarget.path("messages");
		WebTarget singleMessageTarget = messageTarget.path("{messageId}");
		
//		Response response = client.target("http://localhost:8080/adavnced-jax-rs/webapi/messages/1").request().get();
//		Message message = response.readEntity(Message.class);
//		System.out.println(message.getMessage());
		
//		Message response = client
//				.target("http://localhost:8080/adavnced-jax-rs/webapi/messages/1")
//				.request(MediaType.APPLICATION_JSON)
//				.get(Message.class);
//		System.out.println(response.getAuthor());
		
//		String response = client
//				.target("http://localhost:8080/adavnced-jax-rs/webapi/messages/1")
//				.request(MediaType.APPLICATION_JSON)
//				.get(String.class);
//		System.out.println(response);
		
		// this code is for get request.
		Message response = singleMessageTarget
				.resolveTemplate("messageId", 2)
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		System.out.println(response.getAuthor());
		
		//this code is post request
		Message newMessage = new Message(4, "My New Message From JAX-RS as client","koushik");
		Response response2 = messageTarget
		.request()
		.post(Entity.json(newMessage));
		Message createMessage = response2.readEntity(Message.class);
		System.out.println(createMessage.getMessage());
		
		//this code is for put  request
//		Message newMessage1 = new Message(4, "My New Message From JAX-RS as client is updated","koushik");
//		Response response3 = messageTarget
//		.request(MediaType.APPLICATION_JSON)
//		.put(Entity.json(newMessage1));
//		Message updatedMessage = response3.readEntity(Message.class);
//		System.out.println(updatedMessage.getMessage());
	}

}
 