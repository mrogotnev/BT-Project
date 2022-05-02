import Repositories.Contract;
import Services.ContractService;
import Services.Serializer;
import com.sun.net.httpserver.*;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

public class HttpServerHandler implements HttpHandler{
    private ContractService contractService;
    private Serializer serializer;

    public HttpServerHandler() throws SQLException {
        contractService = new ContractService();
        serializer = new Serializer();
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        List<Contract> contracts = null;
        try {
            contracts = contractService.getContracts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        serializer.getSerializationContracts(contracts);

        String result = serializer.getSerializationContracts(contracts).toString();

        byte[] bytes = result.getBytes();
        httpExchange.sendResponseHeaders(200, bytes.length);

        OutputStream os = httpExchange.getResponseBody();
        os.write(bytes);
        os.close();
        httpExchange.close();
    }
}

