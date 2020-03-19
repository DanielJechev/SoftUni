package car.dealer.demo;

import car.dealer.demo.model.dto.viewModel.query1.CustomerWrapper;
import car.dealer.demo.model.dto.viewModel.query2Dtos.CarDto;
import car.dealer.demo.model.dto.bindingModel.seedDataDtos.*;
import car.dealer.demo.model.dto.viewModel.query1.CustomerViewModelQuery1;
import car.dealer.demo.model.dto.viewModel.query2Dtos.CarWrapper;
import car.dealer.demo.model.dto.viewModel.query3.LocalSupplierDto;
import car.dealer.demo.model.dto.viewModel.query3.LocalSupplierWrapper;
import car.dealer.demo.model.dto.viewModel.query4.CarViewModel;
import car.dealer.demo.model.dto.viewModel.query4.CarViewModelWrapper;
import car.dealer.demo.model.dto.viewModel.query5.CustomerQuery5Wrapper;
import car.dealer.demo.model.dto.viewModel.query5.CustomerViewModelQuery5;
import car.dealer.demo.model.dto.viewModel.query6.SaleQuery6Wrapper;
import car.dealer.demo.model.dto.viewModel.query6.SaleViewModelQuery6;
import car.dealer.demo.service.carService.CarService;
import car.dealer.demo.service.customerService.CustomerService;
import car.dealer.demo.service.partService.PartService;
import car.dealer.demo.service.saleService.SaleService;
import car.dealer.demo.service.supplierService.SupplierService;
import car.dealer.demo.utils.serialize.Serializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.*;

@Component
@Transactional
public class CmdRunner implements CommandLineRunner {

    private final static String CARS_INPUT_JSON = "/files/input/cars.json";
    private final static String CUSTOMERS_INPUT_JSON = "/files/input/customers.json";
    private final static String PARTS_INPUT_JSON = "/files/input/parts.json";
    private final static String SUPPLIERS_INPUT_JSON = "/files/input/suppliers.json";
    private static final String OUTPUT_JSON_DIRECTORY_PATH = "src/main/resources/files/output/";
    private static final String OUTPUT_XML_DIRECTORY_PATH = "src/main/resources/files/outputXml/";

    private final Serializer serializerJson;
    private final Serializer serializerXml;

    private CarService carService;
    private CustomerService customerService;
    private PartService partService;
    private SaleService saleService;
    private SupplierService supplierService;

    public CmdRunner(
            @Qualifier(value = "JsonSerializer") Serializer serializerJson,
            @Qualifier(value = "XmlSerializer") Serializer serializerXml,
            CarService carService,
            CustomerService customerService,
            PartService partService,
            SaleService saleService,
            SupplierService supplierService) {
        this.serializerJson = serializerJson;
        this.serializerXml = serializerXml;
        this.carService = carService;
        this.customerService = customerService;
        this.partService = partService;
        this.saleService = saleService;
        this.supplierService = supplierService;
    }

    @Override
    public void run(String... args) throws Exception {
//        seedDataIntoDB();

        orderedCustomers();
        carsFromMakeToyota();
        localSuppliers();
        carsWithTheirListOfParts();
        totalSalesByCustomer();
        salesWithAppliedDiscount();
    }

    private void salesWithAppliedDiscount() {
        List<SaleViewModelQuery6> saleViewModel = this.saleService.salesWithAppliedDiscount();
        serializerJson.serialize(saleViewModel, OUTPUT_JSON_DIRECTORY_PATH + "sales-discounts.json");

        SaleQuery6Wrapper wrapper = new SaleQuery6Wrapper(saleViewModel);
        serializerXml.serialize(wrapper, OUTPUT_XML_DIRECTORY_PATH + "sales-discounts.xml");
    }

    private void totalSalesByCustomer() {
        List<CustomerViewModelQuery5> allWithMinOneBoughtCar = this.customerService.getAllWithMinOneBoughtCar();
        serializerJson.serialize(allWithMinOneBoughtCar, OUTPUT_JSON_DIRECTORY_PATH + "customers-total-sales.json");

        CustomerQuery5Wrapper customerWrapper = new CustomerQuery5Wrapper(allWithMinOneBoughtCar);
        serializerXml.serialize(customerWrapper, OUTPUT_XML_DIRECTORY_PATH + "customers-total-sales.xml");
    }

    private void carsWithTheirListOfParts() {
        List<CarViewModel> cars = this.carService.getAllCarsWithListOfParts();
        serializerJson.serialize(cars, OUTPUT_JSON_DIRECTORY_PATH + "cars-and-parts.json");

        CarViewModelWrapper modelWrapper = new CarViewModelWrapper(cars);
        serializerXml.serialize(modelWrapper, OUTPUT_XML_DIRECTORY_PATH + "cars-and-parts.xml");
    }

    private void localSuppliers() {
        List<LocalSupplierDto> allLocalSuppliers = this.supplierService.getAllLocalSuppliers();
        serializerJson.serialize(allLocalSuppliers, OUTPUT_JSON_DIRECTORY_PATH + "local-suppliers.json");

        LocalSupplierWrapper wrapper = new LocalSupplierWrapper(allLocalSuppliers);
        serializerXml.serialize(wrapper, OUTPUT_XML_DIRECTORY_PATH + "local-suppliers.xml");
    }

    private void carsFromMakeToyota() {
        List<CarDto> carDtos = this.carService.getAllByMake("Toyota");
        serializerJson.serialize(carDtos, OUTPUT_JSON_DIRECTORY_PATH + "toyota-cars.json");

        CarWrapper carWrapper = new CarWrapper(carDtos);
        serializerXml.serialize(carWrapper, OUTPUT_XML_DIRECTORY_PATH + "toyota-cars.xml");
    }

    private void orderedCustomers() {
        List<CustomerViewModelQuery1> customerViewModel =
                this.customerService.allOrderedByBirthDate();
        serializerJson.serialize(customerViewModel, OUTPUT_JSON_DIRECTORY_PATH + "ordered-customers.json");

        CustomerWrapper customerWrapper = new CustomerWrapper(customerViewModel);
        serializerXml.serialize(customerWrapper, OUTPUT_XML_DIRECTORY_PATH + "ordered-customers.xml");
    }

    private void seedDataIntoDB() {
        seedSuppliers();
        seedParts();
        seedCars();
        seedCustomers();
        seedRandomSales();
    }

    private void seedRandomSales() {
        List<SaleSeedBindingModel> salesList = new ArrayList<>();
        fillSaleBindingModelsRandomly(salesList);
        this.saleService.saveAll(salesList);
    }

    private void fillSaleBindingModelsRandomly(List<SaleSeedBindingModel> salesList) {
        Random random = new Random();
        ArrayList<Double> discountList = new ArrayList<Double>() {{
            add(0.0);
            add(0.0);
            add(5.0);
            add(10.0);
            add(15.0);
            add(20.0);
            add(30.0);
            add(40.0);
            add(50.0);
        }};

        Set<Long> carsIds = new HashSet<>();
        int index = random.nextInt(600);
        for (int i = 0; i < index; i++) {
            long carId;
            do {
                carId = randomNumber(random, 358);
            } while (carsIds.contains(carId));
            carsIds.add(carId);
            long customerID = randomNumber(random, 30);
            double discount = discountList.get(randomNumber(random, 8));
            SaleSeedBindingModel saleModel = new SaleSeedBindingModel(carId, customerID, discount);
            salesList.add(saleModel);
        }
    }

    private int randomNumber(Random random, int count) {
        int id;
        do {
            id = random.nextInt(count);
        } while (id == 0 || id > count);
        return id;
    }

    private void seedCustomers() {
        CustomerSeedDataBindinModel[] customerDtos =
                serializerJson.deserialize(CustomerSeedDataBindinModel[].class, CUSTOMERS_INPUT_JSON);
        this.customerService.saveAll(customerDtos);
    }

    private void seedCars() {
        CarSeedDataBindingModel[] carDtos =
                serializerJson.deserialize(CarSeedDataBindingModel[].class, CARS_INPUT_JSON);
        this.carService.saveAll(carDtos);
    }

    private void seedParts() {
        PartSeedDataBindingModel[] partsDtos =
                serializerJson.deserialize(PartSeedDataBindingModel[].class, PARTS_INPUT_JSON);
        this.partService.saveAll(partsDtos);
    }

    private void seedSuppliers() {
        SuppliersSeedDataBindingModel[] suppliersDtos =
                serializerJson.deserialize(SuppliersSeedDataBindingModel[].class, SUPPLIERS_INPUT_JSON);
        this.supplierService.saveAll(suppliersDtos);
    }
}
