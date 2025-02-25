package controller.supplier;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Supplier;

import java.sql.*;

public class SupplierFormController {

    @FXML
    private TableColumn<?, ?> colCompany;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colSupplierId;

    @FXML
    private TableView<Supplier> tblSupplier;

    @FXML
    private TextField txtCompany;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSupplierId;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String SQL ="INSERT INTO supplier VALUES(?,?,?,?)";

        String supplierId = txtSupplierId.getText();
        String name = txtName.getText();
        String email = txtEmail.getText();
        String company = txtCompany.getText();

        Supplier supplier = new Supplier(supplierId, name, email, company);

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement psTm = connection.prepareStatement(SQL);

            psTm.setObject(1, supplier.getId());
            psTm.setObject(2, supplier.getName());
            psTm.setObject(3, supplier.getEmail());
            psTm.setObject(4, supplier.getCompany());
            int i = psTm.executeUpdate();
            System.out.println(i);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {
        ObservableList<Supplier> customerObservableList = FXCollections.observableArrayList();

        colSupplierId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colCompany.setCellValueFactory(new PropertyValueFactory<>("company"));

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM supplier");

            while (resultSet.next()) {

                customerObservableList.add(new Supplier(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                ));
            }

            tblSupplier.setItems(customerObservableList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}
