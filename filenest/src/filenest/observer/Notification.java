package filenest.observer;

import filenest.domain.Customer;
import filenest.domain.Manager;
import filenest.domain.QnA;

public class Notification {
    private String content;
    private Customer customer ;
    private Manager manager;

    public Notification(String content, Customer customer){
        this.content = content;
        this.customer = customer;
    }
    public Notification(String content, Manager manager){
        this.content = content;
        this.manager = manager;
    }
}
