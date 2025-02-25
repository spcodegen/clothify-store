package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class DashBoardFormController {

    @FXML
    private AnchorPane loadFormContent;

    @FXML
    void btnAllOrderFormOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/order_detail_form.fxml");
        assert resource!=null;

        Parent load = FXMLLoader.load(resource);
        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);
    }

    @FXML
    void btnNewOrderFormOnAction(ActionEvent event) throws IOException {
//        Stage stage = new Stage();
//        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/order_form.fxml"))));
//        stage.show();

        URL resource = this.getClass().getResource("/view/order_form.fxml");
        assert resource!=null;

        Parent load =FXMLLoader.load(resource);
        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);
    }

    @FXML
    void btnProductFormOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/product_form.fxml");
        assert resource!=null;
        Parent load = FXMLLoader.load(resource);
        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);
    }

    @FXML
    void btnSettingOnAction(ActionEvent event) {

    }

    @FXML
    void btnSupplierFormOnAction(ActionEvent event) throws IOException {
        URL resource = this.getClass().getResource("/view/supplier_form.fxml");
        assert resource!=null;
        Parent load = FXMLLoader.load(resource);
        loadFormContent.getChildren().clear();
        loadFormContent.getChildren().add(load);
    }

}
