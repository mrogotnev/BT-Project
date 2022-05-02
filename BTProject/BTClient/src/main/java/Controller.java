import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import java.io.IOException;
import java.util.Date;

public class Controller {
    private ObservableList<Contract> contracts = FXCollections.observableArrayList();

    @FXML
    private TableView<Contract> tableContracts;
    @FXML
    private TableColumn<Contract, Integer> number;
    @FXML
    private TableColumn<Contract, Date> createdBy;
    @FXML
    private TableColumn<Contract, Date> updatedBy;
    @FXML
    private TableColumn<Contract, Boolean> isActual;

    @FXML
    public void initialize() throws IOException {
        initData();
        number.setCellValueFactory(new PropertyValueFactory<Contract, Integer>("number"));
        createdBy.setCellValueFactory(new PropertyValueFactory<Contract, Date>("createdBy"));
        updatedBy.setCellValueFactory(new PropertyValueFactory<Contract, Date>("updatedBy"));
        isActual.setCellValueFactory(c -> new SimpleBooleanProperty(c.getValue().getIsActual()));
        isActual.setCellFactory(c -> new CheckBoxTableCell<>());
        tableContracts.setItems(contracts);
    }

    private void initData() throws IOException {
        HttpClient httpClient = new HttpClient();
        Deserializer deserializer = new Deserializer();
        Contract[] arrayOfContracts = deserializer.getDeserializationContracts(httpClient.getHttp());
        contracts =  FXCollections.observableArrayList(arrayOfContracts);
    }
}
