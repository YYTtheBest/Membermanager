package dao.Impl;

import entity.TbConsume_Total;
import entity.Tbconsume;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TbconsumeDaoImplTest {

    @Test
    void queryTotal() {
        TbconsumeDaoImpl tbconsumeDao = new TbconsumeDaoImpl();
        List<TbConsume_Total> tbConsume_Total = tbconsumeDao.QueryTotal(2018, 4);
        for (TbConsume_Total tbconsume : tbConsume_Total) {
            System.out.println(tbconsume);
        }

    }

}