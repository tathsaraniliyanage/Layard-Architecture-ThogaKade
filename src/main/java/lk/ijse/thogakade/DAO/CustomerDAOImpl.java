package lk.ijse.thogakade.DAO;

import lk.ijse.thogakade.db.DbConnection;
import lk.ijse.thogakade.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Praboda Thathsarani
 * @Project thogakade-mvc-master
 */
public class CustomerDAOImpl {
    public boolean saveCustomer(CustomerDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO customer VALUES(?, ?, ?, ?)");
        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());
        pstm.setString(4, dto.getTel());

        return pstm.executeUpdate() > 0;
    }

    public boolean updateCustomer(CustomerDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE customer SET name = ?, address = ?, tel = ? WHERE id = ?");
        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, dto.getTel());
        pstm.setString(4, dto.getId());

        return pstm.executeUpdate() > 0;
    }

    public boolean deleteCustomer( String id) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM customer WHERE id = ?");
        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;
    }

    public void searchCustomer(CustomerDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement( "SELECT * FROM customer WHERE id = ?");
        pstm.setString(1, dto.getId());
        pstm.setString(1, dto.getName());
        pstm.setString(1, dto.getAddress());
        pstm.setString(1, dto.getTel());

        ResultSet resultSet = pstm.executeQuery();
    }

    public void getAllCustomer(CustomerDto dto) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM customer");
        pstm.executeQuery();
    }
}
