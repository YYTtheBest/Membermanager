package entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Tbimember)实体类
 *
 * @author makejava
 * @since 2022-06-10 14:14:09
 */
public class Tbimember implements Serializable {
    private static final long serialVersionUID = 113424702931710803L;

    private Integer mId;

    private String mName;

    private String mSex;

    private String mPhone;

    private Date mOpendare;

    private Double mAddmoney;

    private Double mMoney;


    public Integer getMId() {
        return mId;
    }

    public void setMId(Integer mId) {
        this.mId = mId;
    }

    public String getMName() {
        return mName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public String getMSex() {
        return mSex;
    }

    public void setMSex(String mSex) {
        this.mSex = mSex;
    }

    public String getMPhone() {
        return mPhone;
    }

    public void setMPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public Date getMOpendare() {
        return mOpendare;
    }

    public void setMOpendare(Date mOpendare) {
        this.mOpendare = mOpendare;
    }

    public Double getMAddmoney() {
        return mAddmoney;
    }

    public void setMAddmoney(Double mAddmoney) {
        this.mAddmoney = mAddmoney;
    }

    public Double getMMoney() {
        return mMoney;
    }

    public void setMMoney(Double mMoney) {
        this.mMoney = mMoney;
    }

    @Override
    public String toString() {
        return "Tbimember{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mSex='" + mSex + '\'' +
                ", mPhone='" + mPhone + '\'' +
                ", mOpendare=" + mOpendare +
                ", mAddmoney=" + mAddmoney +
                ", mMoney=" + mMoney +
                '}';
    }
}

