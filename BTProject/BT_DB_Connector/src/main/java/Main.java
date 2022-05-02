import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.SQLException;
import com.sun.net.httpserver.*;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        HttpServer httpServer = HttpServer.create();
        httpServer.bind(new InetSocketAddress("localhost", 8080), 0);
        HttpContext context = httpServer.createContext("/", new HttpServerHandler());

        httpServer.start();
    }
}
