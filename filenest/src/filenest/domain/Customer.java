package filenest.domain;

import java.io.Serializable;

public class Customer implements Serializable {

	private String name;
    private String id;
    private String pwd;
    private String email;
    private String phoneNumber;
    private String dept;
    private String birth;
    // userIp

    public Customer(){}
    public Customer(String id){
        this.id = id;
    }
    public Customer(String name, String id, String pwd, String email, String phoneNumber, String dept, String birth) {
        this.name = name;
        this.id = id;
        this.pwd = pwd;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dept = dept;
        this.birth = birth;
    }
    public String changePwd(String pwd){
        return this.pwd=pwd;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dept='" + dept + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
