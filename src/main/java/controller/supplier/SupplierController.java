package controller.supplier;

import db.DBConnection;
import model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierController {

    public boolean addSupplier(Supplier supplier) {

        String SQL = "INSERT INTO supplier VALUES(?,?,?,?)";

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement psTm = connection.prepareStatement(SQL);

            psTm.setObject(1, supplier.getId());
            psTm.setObject(2, supplier.getName());
            psTm.setObject(3, supplier.getEmail());
            psTm.setObject(4, supplier.getCompany());

            return psTm.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateSupplier(Supplier supplier) {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement psTm = connection.prepareStatement("UPDATE supplier SET name=?, email=?, company=? WHERE supplier_id=?");

            psTm.setString(1,supplier.getName());
            psTm.setString(2,supplier.getEmail());
            psTm.setString(3,supplier.getCompany());
            psTm.setString(4,supplier.getId());
            return psTm.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Supplier searchSupplier(String id) {

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM supplier WHERE supplier_id=" + "'" + id + "'");
            resultSet.next();
            return new Supplier(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteSupplier(String id){
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement psTm = connection.prepareStatement("DELETE FROM supplier WHERE supplier_id=" + "'" + id + "'");
            return psTm.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
