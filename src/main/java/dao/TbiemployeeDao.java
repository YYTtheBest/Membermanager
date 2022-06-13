package dao;
import entity.Tbiemployee;

/**
 * (Tbiemployee)表数据库访问层
 */
public interface TbiemployeeDao {

    /**
     * 通过用户名密码查询
     *
     * @param em_login    username
     * @param em_password password
     * @return 实例对象
     */
    Tbiemployee queryById(String em_login, String em_password);

}

