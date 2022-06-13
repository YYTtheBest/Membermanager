package entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Tbconsume)实体类
 *
 * @author makejava
 * @since 2022-06-10 14:14:08
 */
public class Tbconsume  {
    public Tbconsume() {
    }

    @Override
    public String toString() {
        return "Tbconsume{" +
                "conId=" + conId +
                ", conSername='" + conSername + '\'' +
                ", conPrice=" + conPrice +
                ", conNum=" + conNum +
                ", conMemname='" + conMemname + '\'' +
                ", conDate=" + conDate +
                ", conBill=" + conBill +
                '}';
    }

    private Integer conId;

    private String conSername;

    private Double conPrice;

    private Double conNum;

    private String conMemname;

    private Date conDate;

    private Long conBill;


    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getConSername() {
        return conSername;
    }

    public void setConSername(String conSername) {
        this.conSername = conSername;
    }

    public Double getConPrice() {
        return conPrice;
    }

    public void setConPrice(Double conPrice) {
        this.conPrice = conPrice;
    }

    public Double getConNum() {
        return conNum;
    }

    public void setConNum(Double conNum) {
        this.conNum = conNum;
    }

    public String getConMemname() {
        return conMemname;
    }

    public void setConMemname(String conMemname) {
        this.conMemname = conMemname;
    }

    public Date getConDate() {
        return conDate;
    }

    public void setConDate(Date conDate) {
        this.conDate = conDate;
    }

    public long getConBill() {
        return conBill;
    }

    public void setConBill(long conBill) {
        this.conBill = conBill;
    }

    public Tbconsume(Integer conId, String conSername, Double conPrice, Double conNum, String conMemname, Date conDate, Long conBill) {
        this.conId = conId;
        this.conSername = conSername;
        this.conPrice = conPrice;
        this.conNum = conNum;
        this.conMemname = conMemname;
        this.conDate = conDate;
        this.conBill = conBill;
    }
}

