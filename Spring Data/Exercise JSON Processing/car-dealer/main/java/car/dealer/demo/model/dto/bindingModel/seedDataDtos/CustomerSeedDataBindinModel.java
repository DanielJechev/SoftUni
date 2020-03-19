package car.dealer.demo.model.dto.bindingModel.seedDataDtos;

import com.google.gson.annotations.Expose;

import java.util.Date;

public class CustomerSeedDataBindinModel {

    @Expose
    private String name;
    @Expose
    private Date birthDate;
    @Expose
    private boolean isYoungDriver;

    public CustomerSeedDataBindinModel() {
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
}
