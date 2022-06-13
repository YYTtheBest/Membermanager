package dao.Impl;

import Utils.DBConnection;
import dao.TbconsumeDao;
import entity.TbConsume_Total;
import entity.Tbconsume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TbconsumeDaoImpl implements TbconsumeDao {
    @Override
    public Tbconsume queryByName(String name) {
        return null;
    }

    @Override
    public List<TbConsume_Total> QueryTotal(int year, int month) {
        String var = "set @Year=?,@Month=?";
        String sql =
                "SELECT * FROM inTotal;";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        List<TbConsume_Total> arr = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(var);
            pstmt.setInt(1, year);
            pstmt.setInt(2, month);
            pstmt.execute();
            pstmt = connection.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                TbConsume_Total tbConsume_total = new TbConsume_Total();
                tbConsume_total.setCon_sername(resultSet.getString(1));
                tbConsume_total.setMemberPrice(resultSet.getDouble(2));
                tbConsume_total.setUserPrice(resultSet.getDouble(3));
                tbConsume_total.setTotalPrice(resultSet.getDouble(4));
                arr.add(tbConsume_total);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arr;
    }

    @Override
    public long count(Tbconsume tbconsume) {
        return 0;
    }

    @Override
    public int insert(Tbconsume tbconsume) {
        String sql = "INSERT INTO MemberMIS.tbConsume (con_sername, con_price, con_num, con_memname, con_date, con_bill)\n" +
                "VALUES (?,?,?,?,?,?)";

        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setObject(1, tbconsume.getConSername());
            pstmt.setObject(2, tbconsume.getConPrice());
            pstmt.setObject(3, tbconsume.getConNum());
            pstmt.setObject(4, tbconsume.getConMemname());
            pstmt.setObject(5, tbconsume.getConDate());
            pstmt.setObject(6, tbconsume.getConBill());
            int i = pstmt.executeUpdate();
return i;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int update(Tbconsume tbconsume) {
        return 0;
    }

    @Override
    public int deleteById(Integer conId) {
        return 0;
    }
}
