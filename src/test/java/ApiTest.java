

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ApiTest {
    @Test
    public void testGetMethod() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://www.onliner.by/");
        try {
            CloseableHttpResponse response = httpClient.execute(request);
            System.out.println(response.getStatusLine().getStatusCode());
            //System.out.println(response.getEntity().getContent());
            InputStream body = response.getEntity().getContent();
            System.out.println(Utils.convertStreamToString(body));

                 } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}