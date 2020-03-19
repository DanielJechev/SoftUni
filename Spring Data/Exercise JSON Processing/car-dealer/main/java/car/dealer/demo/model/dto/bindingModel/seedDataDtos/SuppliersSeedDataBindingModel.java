package car.dealer.demo.model.dto.bindingModel.seedDataDtos;

import com.google.gson.annotations.Expose;

public class SuppliersSeedDataBindingModel {

    @Expose
    private String name;
    @Expose
    private boolean isImporter;

    public SuppliersSeedDataBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
