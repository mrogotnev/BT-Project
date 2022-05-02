import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringReader;

public class Deserializer {
    private ObjectMapper objectMapper;

    public Deserializer() {
        objectMapper = new ObjectMapper();
    }

    public Contract[] getDeserializationContracts(String json) throws IOException {
        StringReader stringReader = new StringReader(json);
        return objectMapper.readValue(stringReader, Contract[].class);
    }
}
