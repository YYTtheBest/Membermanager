package entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Tbiemployee)实体类
 *
 * @author makejava
 * @since 2022-06-10 14:14:08
 */
public class Tbiemployee implements Serializable {
    private static final long serialVersionUID = -64731010654436188L;

    private Integer emId;

    private String emName;

    private String emSex;

    private String emPhone;

    private Date emBrith;

    private String emJob;

    private String emLogin;

    private String emPasswd;


    public Integer getEmId() {
        return emId;
    }

    public void setEmId(Integer emId) {
        this.emId = emId;
    }

    public String getEmName() {
        return emName;
    }

    public void setEmName(String emName) {
        this.emName = emName;
    }

    public String getEmSex() {
        return emSex;
    }

    public void setEmSex(String emSex) {
        this.emSex = emSex;
    }

    public String getEmPhone() {
        return emPhone;
    }

    public void setEmPhone(String emPhone) {
        this.emPhone = emPhone;
    }

    public Date getEmBrith() {
        return emBrith;
    }

    public void setEmBrith(Date emBrith) {
        this.emBrith = emBrith;
    }

    public String getEmJob() {
        return emJob;
    }

    public void setEmJob(String emJob) {
        this.emJob = emJob;
    }

    public String getEmLogin() {
        return emLogin;
    }

    public void setEmLogin(String emLogin) {
        this.emLogin = emLogin;
    }

    public String getEmPasswd() {
        return emPasswd;
    }

    public void setEmPasswd(String emPasswd) {
        this.emPasswd = emPasswd;
    }

}

