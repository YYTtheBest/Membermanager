package dao.Impl;

import Utils.DBConnection;
import dao.TbservicesDao;
import entity.Tbservices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TbservicesDaoImpl implements TbservicesDao {


    @Override
    public List<Tbservices> queryByName(String name) {
        Connection connection = DBConnection.getConnection();
        List<Tbservices> arrList = new ArrayList<>();
        String sql = "select * from tbServices where ser_name like  ?";
        PreparedStatement pstmt=null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "%"+name+"%");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Tbservices tbservices = new Tbservices();
                tbservices.setSerId(resultSet.getInt(1));
                tbservices.setSerName(resultSet.getString(2));
                tbservices.setSerPrice(resultSet.getDouble(3));
                tbservices.setSerMemprice(resultSet.getDouble(4));
                arrList.add(tbservices);
            }
            return arrList;
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Tbservices> queryAll() {
        String sql = "select * from tbServices";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        List<Tbservices> arrList = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Tbservices tbservices = new Tbservices();
                tbservices.setSerId(resultSet.getInt(1));
                tbservices.setSerName(resultSet.getString(2));
                tbservices.setSerPrice(resultSet.getDouble(3));
                tbservices.setSerMemprice(resultSet.getDouble(4));
                arrList.add(tbservices);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBConnection.close(connection);
        }
        return arrList;
    }

    @Override
    public int insert(Tbservices tbservices) {
        String sql = "INSERT INTO MemberMIS.tbServices (ser_name, ser_price, Ser_memprice) VALUES (?,?,?)";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, tbservices.getSerName());
            pstmt.setDouble(2, tbservices.getSerPrice());
            pstmt.setDouble(3, tbservices.getSerMemprice());
            int i = pstmt.executeUpdate();
            return i;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBConnection.close(connection);
        }
    }

    @Override
    public int update(Tbservices tbservices) {
        String sql = "UPDATE MemberMIS.tbServices t\n" +
                "SET t.ser_name     = ?,\n" +
                "    t.ser_price    = ?,\n" +
                "    t.Ser_memprice = ?\n" +
                "WHERE t.ser_id = ?;";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, tbservices.getSerName());
            pstmt.setDouble(2, tbservices.getSerPrice());
            pstmt.setDouble(3, tbservices.getSerMemprice());
            pstmt.setObject(4, tbservices.getSerId());
            int i = pstmt.executeUpdate();
            return i;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBConnection.close(connection);
        }
    }

    @Override
    public int deleteById(Integer serId) {
        String sql = "DELETE FROM MemberMIS.tbServices WHERE ser_id = ?";
        String sql1 = "select max(ser_id)from tbServices ;";
        String sql2 = "alter table tbServices auto_increment=?";

        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setObject(1,serId);
            int i = pstmt.executeUpdate();
            pstmt=connection.prepareStatement(sql1);
            ResultSet resultSet = pstmt.executeQuery();
            int max =0;
            while (resultSet.next()) {
                max = resultSet.getInt(1);
            }
            pstmt=connection.prepareStatement(sql2);
            pstmt.setInt(1, max);
            int i1 = pstmt.executeUpdate();
            System.out.println(i1);
            return i;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBConnection.close(connection);
        }
    }
}
