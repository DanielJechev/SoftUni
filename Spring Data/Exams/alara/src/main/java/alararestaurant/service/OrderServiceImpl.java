package alararestaurant.service;

import alararestaurant.domain.dtos.xmls.ItemDto;
import alararestaurant.domain.dtos.xmls.OrderDto;
import alararestaurant.domain.dtos.xmls.OrderRootDto;
import alararestaurant.domain.entities.Employee;
import alararestaurant.domain.entities.Order;
import alararestaurant.domain.entities.OrderItem;
import alararestaurant.repository.*;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final static String ORDER_XML_FILE_PATH =
            "C:\\Users\\ADMIN\\Desktop\\alara\\AlaraRestaurant-master\\src\\main\\resources\\files\\orders.xml";

    private final OrderRepository orderRepository;
    private final EmployeeRepository employeeRepository;
    private final OrderItemRepository orderItemRepository;
    private final ItemRepository itemRepository;
    private final FileUtil fileUtil;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, EmployeeRepository employeeRepository, OrderItemRepository orderItemRepository, ItemRepository itemRepository, FileUtil fileUtil, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.employeeRepository = employeeRepository;
        this.orderItemRepository = orderItemRepository;
        this.itemRepository = itemRepository;
        this.fileUtil = fileUtil;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean ordersAreImported() {
        return this.orderRepository.count() > 0;
    }

    @Override
    public String readOrdersXmlFile() throws IOException {
        return this.fileUtil.readFile(ORDER_XML_FILE_PATH);
    }

    @Override
    public String importOrders() throws JAXBException {
        StringBuilder sb = new StringBuilder();

        JAXBContext context = JAXBContext.newInstance(OrderRootDto.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        OrderRootDto orders = (OrderRootDto) unmarshaller.unmarshal(new File(ORDER_XML_FILE_PATH));

        orderLoop:
        for (OrderDto orderDto : orders.getOrders()) {
            Order order = this.modelMapper.map(orderDto, Order.class);
            Employee employee = this.employeeRepository.findByName(orderDto.getEmployee());
            if (!this.validationUtil.isValid(order) || employee == null) {
                sb.append("Invalid data format.").append(System.lineSeparator());

                continue;
            }

            order.setEmployee(employee);
            List<OrderItem> itemList = new ArrayList<>();
            for (ItemDto item : orderDto.getItems().getItems()) {
                if (this.itemRepository.findByName(item.getName()) == null) {
                    continue orderLoop;
                }
                OrderItem orderItem = new OrderItem();
                orderItem.setOrder(order);
                orderItem.setItem(this.itemRepository.findByName(item.getName()));
                orderItem.setQuantity(item.getQuantity());
                itemList.add(orderItem);

                this.orderItemRepository.saveAndFlush(orderItem);
            }
            order.setOrderItems(itemList);
            this.orderRepository.saveAndFlush(order);
            sb.append(String.format("Order for %s on %s added", orderDto.getCustomer(),
                    orderDto.getDateTime())).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public String exportOrdersFinishedByTheBurgerFlippers() {
        StringBuilder sb = new StringBuilder();
        List<Order> orders = this.orderRepository.finishedByBurgerFlipper();


        for (Order order : orders) {
            sb.append(String.format("Name: %s", order.getEmployee().getName())).append(System.lineSeparator())
                    .append("Orders: ").append(System.lineSeparator())
                    .append(String.format("  Customer: %s", order.getCustomer())).append(System.lineSeparator())
                    .append("  Items:").append(System.lineSeparator());
            for (OrderItem orderItem : order.getOrderItems()) {
                sb.append(String.format(" Name: %s", orderItem.getItem().getName())).append(System.lineSeparator())
                        .append(String.format(" Price: %s", orderItem.getItem().getPrice())).append(System.lineSeparator())
                        .append(String.format(" Quantity: %d", orderItem.getQuantity())).append(System.lineSeparator());
                sb.append(System.lineSeparator());
            }

        }

        return sb.toString().trim();
    }
}
