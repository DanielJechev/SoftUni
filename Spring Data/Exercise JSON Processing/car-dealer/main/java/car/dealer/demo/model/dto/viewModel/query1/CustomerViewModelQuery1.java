package car.dealer.demo.model.dto.viewModel.query1;

import car.dealer.demo.model.dto.bindingModel.query1Dtos.SaleDto;
import com.google.gson.annotations.Expose;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.Transient;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerViewModelQuery1 implements Serializable {

    @Expose
    @XmlElement
    private Long id;
    @Expose
    @XmlElement
    private String name;
    @Expose
    @XmlElement(name = "birth-date")
    private Date birthDate;
    @Expose
    @XmlElement(name = "is-young-driver")
    private boolean isYoungDriver;
    @Expose
    @XmlTransient
    private Set<SaleDto> sales;

    public CustomerViewModelQuery1() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public Set<SaleDto> getSales() {
        return sales;
    }

    public void setSales(Set<SaleDto> sales) {
        this.sales = sales;
    }
}
