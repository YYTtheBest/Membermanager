package dao;

import entity.Tbconsume;
import entity.Tbservices;

import java.util.List;

/**
 * (Tbservices)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-10 14:14:09
 */
public interface TbservicesDao {

    /**
     * 通过姓名查询单条数据
     *
     * @param name 主键
     * @return 实例对象
     */
    List<Tbservices> queryByName(String  name);

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<Tbservices> queryAll();


    /**
     * 新增数据
     *
     * @param tbservices 实例对象
     * @return 影响行数
     */
    int insert(Tbservices tbservices);


    /**
     * 修改数据
     *
     * @param tbservices 实例对象
     * @return 影响行数
     */
    int update(Tbservices tbservices);

    /**
     * 通过id删除数据
     *
     * @param serId id
     * @return 影响行数
     */
    int deleteById(Integer serId);

}

