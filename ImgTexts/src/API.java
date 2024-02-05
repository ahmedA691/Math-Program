
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

public class API {

    public static String API() {
    	if(Globals.message==null)
    	{
    		Globals.message=JOptionPane.showInputDialog("Please write the math problem");
    		Globals.message = "Only give the final answer, no steps and put the basic math signs if you need to such as * / + ^ ="+Globals.message;
    	}
    	String apiKey = "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";
        String endpoint = "https://api.openai.com/v1/chat/completions";

        List<Map<String, String>> messages = new ArrayList<>();
        messages.add(Map.of("role", "system", "content", "You are a helpful assistant."));
        messages.add(Map.of("role", "user", "content", Globals.message));

        int maxTokens = 100;

        try {
            Map<String, Object> data = new HashMap<>();
            data.put("messages", messages);
            data.put("max_tokens", maxTokens);
            data.put("model", "gpt-3.5-turbo"); // Specify the model you want to use

            Gson gson = new Gson();
            String requestBody = gson.toJson(data);

            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endpoint))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + apiKey)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            
            Map<String, Object> responseObject = gson.fromJson(response.body(), Map.class);
            List<Map<String, Object>> choices = (List<Map<String, Object>>) responseObject.get("choices");

            if (choices != null && !choices.isEmpty()) {
                Map<String, Object> assistantChoice = choices.get(0);
                Map<String, String> assistantMessage = (Map<String, String>) assistantChoice.get("message");
                String assistantResponse = assistantMessage.get("content");
                Globals.message=null;
                return assistantResponse;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String API(String message)
    {
    	Globals.message = message;
    	return API();
    }
}
