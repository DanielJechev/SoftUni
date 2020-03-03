package entities.gringotts.billsPaymentSystem;

import entities.gringotts.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BillingDetail extends BaseEntity {
    private String number;
    private String owner;

    @Column
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Column
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
