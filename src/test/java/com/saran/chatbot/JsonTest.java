package com.saran.chatbot;

import java.io.IOException;

import org.json.JSONObject;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class JsonTest {

	@Test
	public void testJson() throws JsonParseException, JsonMappingException, IOException {
		String response = "{\"object\":\"page\",\"entry\":[{\"id\":\"237891439940502\",\"time\":1472270039510,\"messaging\":[{\"sender\":{\"id\":\"1050581225059190\"},\"recipient\":{\"id\":\"237891439940502\"},\"timestamp\":1472269700606,\"delivery\":{\"mid\":\"mid.1472269700310:a47cab6d45ac910119\",\"seq\":2,\"text\":\"hello\"}}]}]}";

		 JSONObject obj = new JSONObject(response);
		 //JSONArray array = obj.getJSONArray("entry");
		 //JSONObject obj1 = obj.getJSONArray("entry").getString("id");
		 

//		ObjectMapper obj = new ObjectMapper();
//		Page page = obj.readValue(response, Page.class);
		 String recptId = obj.getJSONArray("entry").getJSONObject(0).getJSONArray("messaging").getJSONObject(0).getJSONObject("recipient").getString("id");
		boolean status = obj.getJSONArray("entry").getJSONObject(0).getJSONArray("messaging").getJSONObject(0).has("message");
		
				// .getString("text");
		System.out.println(status);
		//System.out.println(message);
		
	}

}
