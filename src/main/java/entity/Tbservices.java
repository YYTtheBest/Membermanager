package entity;

import java.io.Serializable;

/**
 * (Tbservices)实体类
 *
 * @author makejava
 * @since 2022-06-10 14:14:09
 */
public class Tbservices  {

    private Integer serId;

    private String serName;

    private Double serPrice;

    private Double serMemprice;


    public Integer getSerId() {
        return serId;
    }

    public void setSerId(Integer serId) {
        this.serId = serId;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public Double getSerPrice() {
        return serPrice;
    }

    public void setSerPrice(Double serPrice) {
        this.serPrice = serPrice;
    }

    public Double getSerMemprice() {
        return serMemprice;
    }

    public void setSerMemprice(Double serMemprice) {
        this.serMemprice = serMemprice;
    }

    @Override
    public String toString() {
        return "Tbservices{" +
                "serId=" + serId +
                ", serName='" + serName + '\'' +
                ", serPrice=" + serPrice +
                ", serMemprice=" + serMemprice +
                '}';
    }
}

