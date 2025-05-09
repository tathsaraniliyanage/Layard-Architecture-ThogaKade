package lk.ijse.thogakade.model;

/*
    @author DanujaV
    @created 10/24/23 - 10:38 AM   
*/

import lk.ijse.thogakade.DAO.CustomerDAOImpl;
import lk.ijse.thogakade.db.DbConnection;
import lk.ijse.thogakade.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel {
    public boolean saveCustomer(final CustomerDto dto) throws SQLException {
     /*   Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO customer VALUES(?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getId());
        pstm.setString(2, dto.getName());
        pstm.setString(3, dto.getAddress());
        pstm.setString(4, dto.getTel());

        boolean isSaved = pstm.executeUpdate() > 0;
        return isSaved;  */

        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        return customerDAO.saveCustomer(dto);
    }

    public boolean updateCustomer(final CustomerDto dto) throws SQLException {
     /*   Connection connection = DbConnection.getInstance().getConnection();

        String sql = "UPDATE customer SET name = ?, address = ?, tel = ? WHERE id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, dto.getName());
        pstm.setString(2, dto.getAddress());
        pstm.setString(3, dto.getTel());
        pstm.setString(4, dto.getId());

        return pstm.executeUpdate() > 0;   */

        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
       return customerDAO.updateCustomer(dto);
    }

   public CustomerDto searchCustomer(String id) throws SQLException {
      /*  Connection connection = DbConnection.getInstance().getConnection();

        String sql = "SELECT * FROM customer WHERE id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();  */

      CustomerDAOImpl customerDAO = new CustomerDAOImpl();
      ArrayList<CustomerDto> searchCustomer = new ArrayList<>();
      for(CustomerDto dto : searchCustomer){
           customerDAO.searchCustomer(new CustomerDto(dto.getId(), dto.getName(), dto.getAddress(),dto.getTel()));
      }
       //customerDAO.searchCustomer(new CustomerDto(cus_id, cus_name, cus_address, cus_tel););


        CustomerDto dto = null;

         /* if(resultSet.next()) {
            String cus_id = resultSet.getString(1);
            String cus_name = resultSet.getString(2);
            String cus_address = resultSet.getString(3);
            String cus_tel = resultSet.getString(4);

            dto = new CustomerDto(cus_id, cus_name, cus_address, cus_tel);
        }  */

        return dto;
    }

    public List<CustomerDto> getAllCustomers() throws SQLException {
      /*  Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM customer");  */

       // List<CustomerDto> dtoList = new ArrayList<>();

       // ResultSet resultSet = pstm.executeQuery();

        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        ArrayList<CustomerDto> allCustomer = new ArrayList<>();
        for(CustomerDto dto: allCustomer){
            customerDAO.getAllCustomer( new CustomerDto(dto.getId(), dto.getName(), dto.getAddress(), dto.getTel()));
        }

     /*   while (resultSet.next()) {
            String cus_id = resultSet.getString(1);
            String cus_name = resultSet.getString(2);
            String cus_address = resultSet.getString(3);
            String cus_tel = resultSet.getString(4);

            var dto = new CustomerDto(cus_id, cus_name, cus_address, cus_tel);
            dtoList.add(dto);
        }  */
        return allCustomer;
    }

    public boolean deleteCustomer(String id) throws SQLException {
      /*  Connection connection = DbConnection.getInstance().getConnection();
        String sql = "DELETE FROM customer WHERE id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;  */

        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        return customerDAO.deleteCustomer(id);
    }

    public List<CustomerDto> loadAllCustomers() throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        ResultSet resultSet = connection.prepareStatement( "SELECT * FROM customer").executeQuery();

        List<CustomerDto> cusList = new ArrayList<>();

        while (resultSet.next()) {
            cusList.add(new CustomerDto(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            ));
        }
        return cusList;
    }
}
