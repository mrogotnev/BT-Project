package Services;

import Repositories.Contract;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public class Serializer {
    private ObjectMapper objectMapper;

    public Serializer() {
        objectMapper = new ObjectMapper();
    }

    public StringWriter getSerializationContracts(List<Contract> contracts) throws IOException {
        StringWriter stringWriter = new StringWriter();
        objectMapper.writeValue(stringWriter, contracts);
        return stringWriter;
    }
}
