package alararestaurant.domain.dtos.xmls;

import alararestaurant.domain.entities.OrderType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderDto {

    @XmlElement
    private String customer;

    @XmlElement
    private String employee;

    @XmlElement(name = "date-time")
    private String dateTime;
    @XmlElement

    private OrderType type;

    @XmlElement
    private ItemRootDto items;

    public OrderDto(){}

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public ItemRootDto getItems() {
        return items;
    }

    public void setItems(ItemRootDto items) {
        this.items = items;
    }
}
