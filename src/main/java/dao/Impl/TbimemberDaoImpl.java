package dao.Impl;

import java.util.ArrayList;

import Utils.DBConnection;
import dao.TbimemberDao;
import entity.Tbimember;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TbimemberDaoImpl implements TbimemberDao {
    @Override
    public List<Tbimember> queryByPhoneOrName(Boolean byPhone, String args) {
        String sqlByPhone = "select * from tbIMember where m_phone like ?";
        String sqlByName = "select * from tbIMember where m_name like ?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        List<Tbimember> arrList = new ArrayList<>();
        try {
            if (byPhone) {
                pstmt = connection.prepareStatement(sqlByPhone);

            } else {
                pstmt = connection.prepareStatement(sqlByName);
            }
            pstmt.setObject(1, "%"+args+"%");
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Tbimember tbimember = new Tbimember();
                tbimember.setMId(resultSet.getInt(1));
                tbimember.setMName(resultSet.getString(2));
                tbimember.setMSex(resultSet.getString(3));
                tbimember.setMPhone(resultSet.getString(4));
                tbimember.setMOpendare(resultSet.getDate(5));
                tbimember.setMAddmoney(resultSet.getDouble(6));
                tbimember.setMMoney(resultSet.getDouble(7));
                arrList.add(tbimember);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBConnection.close(connection);
        }
        return arrList;
    }

    @Override
    public List<Tbimember> queryAll() {
        String sql = "select * from tbIMember ";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        List<Tbimember> arrList = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Tbimember tbimember = new Tbimember();
                tbimember.setMId(resultSet.getInt(1));
                tbimember.setMName(resultSet.getString(2));
                tbimember.setMSex(resultSet.getString(3));
                tbimember.setMPhone(resultSet.getString(4));
                tbimember.setMOpendare(resultSet.getDate(5));
                tbimember.setMAddmoney(resultSet.getDouble(6));
                tbimember.setMMoney(resultSet.getDouble(7));
                arrList.add(tbimember);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBConnection.close(connection);
        }
        return arrList;
    }
        @Override
    public int insert(Tbimember tbimember) {
            String sql = "INSERT INTO MemberMIS.tbIMember (m_name, m_sex, m_phone, m_opendare)\n" +
                    "VALUES (?,?,?,?)";
            Connection connection = DBConnection.getConnection();
            PreparedStatement pstmt;
            try {
                pstmt = connection.prepareStatement(sql);
                pstmt.setObject(1,tbimember.getMName());
                pstmt.setObject(2,tbimember.getMSex());
                pstmt.setObject(3,tbimember.getMPhone());
                pstmt.setObject(4,tbimember.getMOpendare());

                int i = pstmt.executeUpdate();
                return i;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                DBConnection.close(connection);
            }
    }

    @Override
    public int update(Tbimember tbimember) {
        String sql = "UPDATE MemberMIS.tbIMember t\n" +
                "SET t.m_name     = ?,\n" +
                "    t.m_sex      = ?,\n" +
                "    t.m_phone    = ? where t.m_id = ?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setObject(1,tbimember.getMName());
            pstmt.setObject(2,tbimember.getMSex());
            pstmt.setObject(3,tbimember.getMPhone());
            pstmt.setObject(4, tbimember.getMId());
            int i = pstmt.executeUpdate();
            return i;
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteById(Integer mId) {
        // TODO: 2022/6/10 删除以后把auto_incommit改为最后一个ID，思路是用max函数来获取最大的ID，然后运行语句
        String sql = "delete from tbIMember where m_id =?";
        String sql1 = "select max(m_id)from tbIMember ;";
        String sql2 = "alter table tbIMember auto_increment=?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setObject(1,mId);
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

    @Override
    public int charge(Integer mId, Double money) {
        String sql = "UPDATE MemberMIS.tbIMember t SET t.m_money = t.m_money + ?,t.m_addmoney = ? WHERE t.m_id = ?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt =null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setDouble(1, money);
            pstmt.setDouble(2, money);
            pstmt.setInt(3, mId);
            int i = pstmt.executeUpdate();
            return i;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Tbimember MemberSelect(String args) {
        String sqlByPhone = "select * from tbIMember where m_phone = ? or m_name = ?";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        List<Tbimember> arrList = new ArrayList<>();
        try {
            pstmt = connection.prepareStatement(sqlByPhone);
//正则表达式

            String pattern = "[\u4e00-\u9fa5]+";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(args);
            boolean matches = m.matches();
            if (matches) {
                pstmt.setString(1,  null );
                pstmt.setString(2, args );
            } else {
                pstmt.setObject(1, args);
                pstmt.setString(2, null);

            }
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Tbimember tbimember = new Tbimember();
                tbimember.setMId(resultSet.getInt(1));
                tbimember.setMName(resultSet.getString(2));
                tbimember.setMSex(resultSet.getString(3));
                tbimember.setMPhone(resultSet.getString(4));
                tbimember.setMOpendare(resultSet.getDate(5));
                tbimember.setMAddmoney(resultSet.getDouble(6));
                tbimember.setMMoney(resultSet.getDouble(7));
                return tbimember;

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBConnection.close(connection);
        }

        return null;
    }

    @Override
    public int pay(String name,String phone, Double money) {
        String sql = "UPDATE MemberMIS.tbIMember t SET t.m_money = t.m_money - ? WHERE t.m_name = ? and t.m_phone =? ";
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstmt =null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setDouble(1, money);
            pstmt.setString(2, name);
            pstmt.setString(3, phone);
            int i = pstmt.executeUpdate();
            return i;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
