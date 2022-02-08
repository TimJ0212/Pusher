package pusher;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Pusher {
    private final static String PUSH_MESSAGE_URL = "https://api.pushover.net/1/messages.json";
    private static final String TOKEN = "<YOUR_TOKEN>";
    private static final String USER = "<YOUR_USER>";

    /**
     * Sends a message completely default client.
     */
    public static String sendMessage(String message) throws IOException {
        URL url = new URL(PUSH_MESSAGE_URL);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("Content-Type", "application/json");

        String data = "{\"token\": \""+ TOKEN +"\", \"user\": \"" + USER + "\", \"message\":\"" + message + "\"}";

        byte[] out = data.getBytes(StandardCharsets.UTF_8);

        OutputStream stream = http.getOutputStream();
        stream.write(out);

        http.disconnect();
        return http.getResponseCode() + " " + http.getResponseMessage();
    }
}
