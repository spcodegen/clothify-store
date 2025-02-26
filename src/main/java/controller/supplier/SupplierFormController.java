package controller.supplier;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
        boolean isSupplierAdd = new SupplierController().addSupplier(
                new Supplier(
                        txtSupplierId.getText(),
                        txtName.getText(),
                        txtEmail.getText(),
                        txtCompany.getText()
                ));
        if (isSupplierAdd) {
            new Alert(Alert.AlertType.INFORMATION, "Supplier Added!!!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Supplier Not Added!!!").show();
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        boolean isDeleted = new SupplierController().deleteSupplier(txtSupplierId.getText());
        if (isDeleted){
            new Alert(Alert.AlertType.INFORMATION,"Delete Success!!!").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"Note Deleted!!!").show();
        }
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
        boolean isUpdated = new SupplierController().updateSupplier(new Supplier(
                txtSupplierId.getText(),
                txtName.getText(),
                txtEmail.getText(),
                txtCompany.getText()
        ));

        if (isUpdated){
            new Alert(Alert.AlertType.INFORMATION,"Update Success!!!").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"Update Fail!!!").show();
        }
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        txtSupplierIdOnAction(actionEvent);
    }

    public void txtSupplierIdOnAction(ActionEvent actionEvent) {

        Supplier supplier = new SupplierController().searchSupplier(
                txtSupplierId.getText());

        System.out.println(supplier);

        txtName.setText(supplier.getName());
        txtEmail.setText(supplier.getEmail());
        txtCompany.setText(supplier.getCompany());
    }
}
