package dao;

import entity.TbConsume_NameAndPrivce;
import entity.TbConsume_Total;
import entity.Tbconsume;


import java.util.List;

/**
 * (Tbconsume)表数据库访问层
 */
public interface TbconsumeDao {

    /**
     * 通过姓名查询单条数据
     *
     * @param name 主键
     * @return 实例对象
     */
   Tbconsume queryByName(String  name);

    /**
     * 消费数据统计
     *
     * @return 对象列表
     */
    List<TbConsume_Total> QueryTotal(int year, int month);

    /**
     * 统计总行数
     *
     * @param tbconsume 查询条件
     * @return 总行数
     */
    long count(Tbconsume tbconsume);

    /**
     * 新增数据
     *
     * @param tbconsume 实例对象
     * @return 影响行数
     */
    int insert(Tbconsume tbconsume);


    /**
     * 修改数据
     *
     * @param tbconsume 实例对象
     * @return 影响行数
     */
    int update(Tbconsume tbconsume);

    /**
     * 通过id删除数据
     *
     * @param conId id
     * @return 影响行数
     */
    int deleteById(Integer conId);




}

