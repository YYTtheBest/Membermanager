package dao;

import entity.Tbimember;

import java.util.List;

/**
 * (Tbimember)表数据库访问层
 */
public interface TbimemberDao {

    /**
     * 通过ID查询单条数据
     *
     * @param byPhone true则为通过手机查询，反之则为姓名
     * @param args     name or phone
     * @return 实例对象
     */
    List queryByPhoneOrName(Boolean byPhone,String args);

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    List<Tbimember> queryAll();


    /**
     * 新增数据
     *
     * @param tbimember 实例对象
     * @return 影响行数
     */
    int insert(Tbimember tbimember);


    /**
     * 修改数据
     *
     * @param tbimember 实例对象
     * @return 影响行数
     */
    int update(Tbimember tbimember);

    /**
     * 通过id删除数据
     *
     * @param mId id
     * @return 影响行数
     */
    int deleteById(Integer mId);

    /**
     * 充值金额
     * @param mId ID
     * @param money 充值的钱
     * @return 结果
     */
    int charge(Integer mId, Double money);

    /**
     * 会员录入
     * @param input 姓名或电话
     * @return 返回对应的会员
     */
    Tbimember MemberSelect(String input);

    /**
     * 根据姓名+手机号来获取用户
     * @param name 姓名
     * @param phone 手机号
     * @param money 消费金额
     * @return
     */
    int pay(String name,String phone ,Double money);

}

