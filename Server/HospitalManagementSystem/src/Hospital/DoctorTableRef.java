package Hospital;

import javafx.beans.property.SimpleStringProperty;

public class DoctorTableRef {
    private final SimpleStringProperty Id;
    private final SimpleStringProperty Name;
    private final SimpleStringProperty Dept;
    private final SimpleStringProperty ContactNo;
    private final SimpleStringProperty Email;
    private final SimpleStringProperty Address;

    public DoctorTableRef(String id, String name, String dept, String contactNo, String email, String address) {
        Id = new SimpleStringProperty(id);
        Name = new SimpleStringProperty(name);
        Dept = new SimpleStringProperty(dept);
        ContactNo = new SimpleStringProperty(contactNo);
        Email =new SimpleStringProperty(email);
        Address =new SimpleStringProperty(address);
    }

    public String getId() {
        return Id.get();
    }

    public SimpleStringProperty idProperty() {
        return Id;
    }

    public void setId(String id) {
        this.Id.set(id);
    }

    public String getName() {
        return Name.get();
    }

    public SimpleStringProperty nameProperty() {
        return Name;
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public String getDept() {
        return Dept.get();
    }

    public SimpleStringProperty deptProperty() {
        return Dept;
    }

    public void setDept(String dept) {
        this.Dept.set(dept);
    }

    public String getContactNo() {
        return ContactNo.get();
    }

    public SimpleStringProperty contactNoProperty() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        this.ContactNo.set(contactNo);
    }

    public String getEmail() {
        return Email.get();
    }

    public SimpleStringProperty emailProperty() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email.set(email);
    }

    public String getAddress() {
        return Address.get();
    }

    public SimpleStringProperty addressProperty() {
        return Address;
    }

    public void setAddress(String address) {
        this.Address.set(address);
    }
}
