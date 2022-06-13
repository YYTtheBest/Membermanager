package dao.Impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TbiemployeeDaoImplTest {

    @Test
    void queryById() {
        TbiemployeeDaoImpl tbiemployeeDao = new TbiemployeeDaoImpl();
        System.out.println(tbiemployeeDao.queryById("PM-1", "PM-1"));
    }
}