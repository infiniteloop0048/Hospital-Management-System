package Hospital;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class FinanceTable implements Serializable{

    private final SimpleStringProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty money;

    public FinanceTable(String id,String name,String money) {
        this.id = new SimpleStringProperty(id);
        this.name =new SimpleStringProperty(name);
        this.money =new SimpleStringProperty(money);
    }

    //--------------

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getMoney() {
        return money.get();
    }

    public SimpleStringProperty moneyProperty() {
        return money;
    }

    public void setMoney(String money) {
        this.money.set(money);
    }
}
