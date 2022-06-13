package entity;

public class TbConsume_NameAndPrivce {
    private int id;
    private String name;
    private Double price;

    public TbConsume_NameAndPrivce() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TbConsume_NameAndPrivce(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
