import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    public String getHttp() throws IOException {
        URL url = new URL("http://localhost:8080/");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String content;
        StringBuilder result = new StringBuilder();
        while ((content = bufferedReader.readLine()) != null) {
            result.append(content);
        }
        return result.toString();
    }
}
