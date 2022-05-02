package Repositories;

import com.sun.rowset.JdbcRowSetImpl;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractRepository {
    private static final String URL ="jdbc:postgresql:BTDatabase";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Qwerty!23";

    public List<Contract> getContracts() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        String firstQuery = "SELECT number, created_by, updated_by FROM \"BTSchema\".\"Contracts\";";

        JdbcRowSet jdbcRowSet = new JdbcRowSetImpl(connection);
        jdbcRowSet.setCommand(firstQuery);
        jdbcRowSet.execute();

        List<Contract> list = new ArrayList<>();

        int number;
        Date createdBy;
        Date updatedBy;
        while (jdbcRowSet.next()) {
            number = jdbcRowSet.getInt("number");
            createdBy = jdbcRowSet.getDate("created_by");
            updatedBy = jdbcRowSet.getDate("updated_by");
            list.add(new Contract(number, createdBy, updatedBy));
        }
        connection.close();
        return list;
    }
}
