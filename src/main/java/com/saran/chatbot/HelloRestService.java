package com.saran.chatbot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@Path("/")
public class HelloRestService {

	@POST
	@Path("/health")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response invoke(String json) {

		System.out.println("input from facebook=" + json);
		JSONObject obj = new JSONObject(json);
		String recepientId = obj.getJSONArray("entry").getJSONObject(0).getJSONArray("messaging").getJSONObject(0)
				.getJSONObject("sender").getString("id");

		boolean status = obj.getJSONArray("entry").getJSONObject(0).getJSONArray("messaging").getJSONObject(0)
				.has("message");

		if (status) {
			boolean hasEcho = obj.getJSONArray("entry").getJSONObject(0).getJSONArray("messaging").getJSONObject(0)
					.getJSONObject("message").has("is_echo");
			boolean isDelivered = false;
			if (hasEcho) {
				isDelivered = obj.getJSONArray("entry").getJSONObject(0).getJSONArray("messaging").getJSONObject(0)
						.getJSONObject("message").getBoolean("is_echo");				
			}

			if (!isDelivered) {
				String jsonReq = constructJsonString(recepientId, getRandomMessage());
				System.out.println("out message to facebook=" + jsonReq);
				try {
					sendMessage(jsonReq);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Delivered!");
			}
		}
		String jsonSuccess = "{\"success\": true}";
		return Response.status(Status.OK).entity(jsonSuccess).build();

	}

	private void sendMessage(String json) throws IOException {
		// String token =
		// "EAAPTgPVacLABAHwikyVLWN1rZBZCPfv3mZCUil0w6TTp21uZCyFsaeESqIwINZBa0tB39X2bFfL9j4il1uaAIqJqZCZBU791MtUv123ZCZCwQFwJUQvYkp7WISZCWcRAUqUzgkgPFsX1zAZA9Q5r7ETm09dpzeV8Rx9QZCDY4zuEm9bG51qL1xdnMJI7";
		String newToken = "EAAPTgPVacLABAB0WzDfTvZBnu4bhDZCeNEFtuZCvk2scahJZBpY5RUJuYuaeRPvLANZAG3oNr6UWBx1H55QvgotLRQkzzkdZAAhsaa8q4Rteg1fHFf0nulkPY8a6eju2ZCAQtCLTokvzprO0ebwZCvRo3WlGigKUSOwtdSMDR5yy7EZAuI3ZBwk2vZB";
		String url = "https://graph.facebook.com/v2.6/me/messages?access_token=" + newToken;
		// CloseableHttpAsyncClient httpclient =
		// HttpAsyncClients.createDefault();
		HttpClient httpClient = HttpClientBuilder.create().build();
		// httpclient.start();
		HttpPost request = new HttpPost(url);
		// String JsonResponse ="{\"recipient\":"+recpId +"\"}";

		StringEntity postingString = new StringEntity(json);
		request.setEntity(postingString);
		request.setHeader("Content-type", "application/json");
		HttpResponse response = httpClient.execute(request);
		System.out.println(response.getStatusLine());

	}

	private String constructJsonString(String userId, String message) {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append("\"").append("recipient").append("\"").append(":").append("{");
		builder.append("\"").append("id").append("\"").append(":").append("\"").append(userId).append("\"");
		builder.append("}").append(",");
		builder.append("\"").append("message").append("\"").append(":").append("{");
		builder.append("\"").append("text").append("\"").append(":").append("\"").append(message).append("\"");
		builder.append("}}");
		return builder.toString();
	}

	@GET
	@Path("/health")
	public Response health(@QueryParam("hub.challenge") String token) {
		System.out.println("token" + token);
		return Response.status(Status.OK).entity(token).build();
	}

	private String getRandomMessage() {

		List<String> list = new ArrayList<String>();
		list.add("Hai There!");
		list.add("I am bot! How can i help you.");
		list.add("How are you");
		list.add("I am doing good");
		list.add("I am machine!");
		return list.get(new Random().nextInt(list.size()));

	}
	@GET
	@Path("/hello")
	public String hello(){
		return "Hello";
	}
	
	@GET
	@Path("/mtcnstatus")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,String> getMtcnStatus(@QueryParam("mtcn") String mtcn ){
		Map<String,String>  status = new HashMap<String,String>();
		List<String> statusList = Arrays.asList("Success","Declined","Onhold","In-progress");
		int index = ThreadLocalRandom.current().nextInt(statusList.size());
		status.put("mtcn", statusList.get(index));
		return status;
	}
	
	@GET
	@Path("/rewards")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,String> getRewards(@QueryParam("country") String country ){
		System.out.println("country="+country);
		Map<String,String>  status = new HashMap<String,String>();
		status.put(country, "10% Cashback on transaction fee on Thanks giving day week!");
		return status;
	}

}
