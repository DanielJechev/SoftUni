package com.car.dealer.services;

import com.car.dealer.domain.dtos.bindings.CustomersDto;
import com.car.dealer.domain.dtos.views.customerSales.CustomersBySales;
import com.car.dealer.domain.dtos.views.orderCustomers.CustomersOrder;
import com.car.dealer.domain.entities.Customer;
import com.car.dealer.domain.entities.Part;
import com.car.dealer.domain.entities.Sale;
import com.car.dealer.domain.dtos.views.customerSales.CustomerBySales;
import com.car.dealer.domain.dtos.views.orderCustomers.CustomerOrders;
import com.car.dealer.repositories.CustomerRepository;
import com.car.dealer.services.base.CustomerService;
import com.car.dealer.utils.base.JaxbUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final JaxbUtil jaxbUtil;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, JaxbUtil jaxbUtil) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.jaxbUtil = jaxbUtil;
    }

    @Override
    public void seedCustomers(CustomersDto customersDto) {
        Customer[] customers = this.modelMapper.map(customersDto.getCustomersDto(), Customer[].class);
        Arrays.stream(customers).forEach(this.customerRepository::save);
    }

    @Override
    public void getAllCustomersOrderByBirthDate() throws IOException, JAXBException {
        Customer[] customers = this.customerRepository.getAllCustomersOrderByBirthDateAndIsYoungDriver()
                .toArray(new Customer[0]);

        CustomerOrders[] customerOrders = this.modelMapper.map(customers, CustomerOrders[].class);
        CustomersOrder customersOrder = new CustomersOrder();
        customersOrder.setCustomers(Arrays.asList(customerOrders));
        this.jaxbUtil.saveToXML("ordered-customers", customersOrder);
    }

    @Override
    public void getCustomersByTotalSalary() throws IOException, JAXBException {
        List<Customer> customers = this.customerRepository.findAll();
        List<CustomerBySales> customerBySales = new ArrayList<>();

        for (Customer customer : customers) {
            BigDecimal totalPrice = BigDecimal.ZERO;
            for (Sale sale : customer.getSales()) {
                for (Part part : sale.getCar().getParts()) {
                    totalPrice = totalPrice.add(part.getPrice());
                }
            }
            customerBySales.add(new CustomerBySales(customer.getName(), customer.getSales().size(), totalPrice));
        }

        customerBySales.sort((a, b) -> {
            if (!a.getSpentMoney().equals(b.getSpentMoney())) {
                return b.getSpentMoney().compareTo(a.getSpentMoney());
            }

            return b.getBoughtCars() - a.getBoughtCars();
        });

        CustomerBySales[] customerBySalesArr = customerBySales.toArray(new CustomerBySales[0]);
        CustomersBySales customersBySales = new CustomersBySales();
        customersBySales.setCustomers(Arrays.asList(customerBySalesArr));
        this.jaxbUtil.saveToXML("customers-total-sales", customersBySales);
    }
}
