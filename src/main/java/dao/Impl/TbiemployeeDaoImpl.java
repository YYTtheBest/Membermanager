package dao.Impl;
import java.util.Date;

import Utils.DBConnection;
import dao.TbiemployeeDao;
import entity.Tbiemployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TbiemployeeDaoImpl implements TbiemployeeDao {
    @Override
    public Tbiemployee queryById(String em_login, String em_password) {
        String sql = "select  * from tbIEmployee where em_login =? and em_passwd =?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, em_login);
            pstmt.setString(2, em_password);
            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet != null) {
                while (resultSet.next()) {
                    Tbiemployee tbiemployee = new Tbiemployee();
                    tbiemployee.setEmId(resultSet.getInt(1));
                    tbiemployee.setEmName(resultSet.getString(2));
                    return tbiemployee;

                }

            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnection.close(connection);
        }
        return null;
    }
}



