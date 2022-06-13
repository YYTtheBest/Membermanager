package entity;

public class TbConsume_Total {
private String con_sername;
private double memberPrice;
private double userPrice;
private double totalPrice;

    @Override
    public String toString() {
        return "TbConsume_Total{" +
                "con_sername='" + con_sername + '\'' +
                ", memberPrice=" + memberPrice +
                ", userPrice=" + userPrice +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public TbConsume_Total() {
    }

    public String getCon_sername() {
        return con_sername;
    }

    public void setCon_sername(String con_sername) {
        this.con_sername = con_sername;
    }

    public double getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(double memberPrice) {
        this.memberPrice = memberPrice;
    }

    public double getUserPrice() {
        return userPrice;
    }

    public void setUserPrice(double userPrice) {
        this.userPrice = userPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public TbConsume_Total(String con_sername, double memberPrice, double userPrice, double totalPrice) {
        this.con_sername = con_sername;
        this.memberPrice = memberPrice;
        this.userPrice = userPrice;
        this.totalPrice = totalPrice;
    }
}
