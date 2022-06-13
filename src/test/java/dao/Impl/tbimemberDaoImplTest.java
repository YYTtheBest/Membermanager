package dao.Impl;
import java.util.Date;

import entity.Tbimember;
import org.junit.jupiter.api.Test;

import java.util.List;

class tbimemberDaoImplTest {


    @Test
    void queryByPhoneOrName() {
        TbimemberDaoImpl tbimemberDao = new TbimemberDaoImpl();
        List 张 = tbimemberDao.queryByPhoneOrName(false, "梁");
        for (Object o : 张) {
            System.out.println(o);
        }
    }


    @Test
    void queryAll() {
        TbimemberDaoImpl tbimemberDao = new TbimemberDaoImpl();
        List 张 = tbimemberDao.queryAll();
        for (Object o : 张) {
            System.out.println(o);
        }
    }

    @Test
    void insert() {
        Tbimember tbimember = new Tbimember();
        tbimember.setMName("Text");
        tbimember.setMSex("");
        tbimember.setMPhone("");
        tbimember.setMOpendare(new Date());
        tbimember.setMAddmoney(0.0D);
        tbimember.setMMoney(0.0D);
        TbimemberDaoImpl tbimemberDao = new TbimemberDaoImpl();
        int insert = tbimemberDao.insert(tbimember);
        System.out.println(insert);

    }

    @Test
    void update() {
        TbimemberDaoImpl tbimemberDao = new TbimemberDaoImpl();

        Tbimember tbimember = new Tbimember();
        tbimember.setMId(31);
        tbimember.setMName("Testt");
        tbimember.setMSex("");
        tbimember.setMPhone("");
        tbimember.setMOpendare(new Date());
        tbimember.setMAddmoney(6.6D);
        tbimember.setMMoney(0.0D);

        System.out.println(tbimemberDao.update(tbimember));


    }

    @Test
    void deleteById() {
        TbimemberDaoImpl tbimemberDao = new TbimemberDaoImpl();
        System.out.println(tbimemberDao.deleteById(31));
    }

    @Test
    void charge() {
        TbimemberDaoImpl tbimemberDao = new TbimemberDaoImpl();
        System.out.println(tbimemberDao.charge(30, 850.66));
    }
}