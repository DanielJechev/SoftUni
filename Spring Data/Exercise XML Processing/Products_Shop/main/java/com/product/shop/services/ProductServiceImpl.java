package com.product.shop.services;

import com.product.shop.domain.dtos.bindings.ProductsDto;
import com.product.shop.domain.dtos.views.productsInRange.ProductsInRange;
import com.product.shop.domain.dtos.views.successfullySoldProducts.UsersModel;
import com.product.shop.domain.entities.Category;
import com.product.shop.domain.entities.Product;
import com.product.shop.domain.entities.User;
import com.product.shop.domain.dtos.views.productsInRange.ProductInRange;
import com.product.shop.domain.dtos.views.successfullySoldProducts.UserModel;
import com.product.shop.repositories.CategoryRepository;
import com.product.shop.repositories.ProductRepository;
import com.product.shop.repositories.UserRepository;
import com.product.shop.services.base.ProductService;
import com.product.shop.utils.base.JaxbUtil;
import com.product.shop.utils.base.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final Random random;
    private final ValidatorUtil validatorUtil;
    private final JaxbUtil jaxbUtil;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository, CategoryRepository categoryRepository, ModelMapper modelMapper, Random random, ValidatorUtil validatorUtil, JaxbUtil jaxbUtil) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.random = random;
        this.validatorUtil = validatorUtil;
        this.jaxbUtil = jaxbUtil;
    }

    @Override
    public void saveProducts(ProductsDto productsDto) {
        Product[] products = this.modelMapper.map(productsDto.getProductDtos(), Product[].class);
        User[] users = this.userRepository.findAll().toArray(new User[0]);
        int usersCount = users.length;

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            int sellerNumber = this.random.nextInt(usersCount);
            product.setSeller(users[sellerNumber]);

            if (i % 4 != 0) {
                int buyerNumber = this.random.nextInt(usersCount);
                product.setBuyer(users[buyerNumber]);
            }
        }

        Arrays.stream(products).forEach(p -> {
            List<String> violationsMessage = this.validatorUtil.getViolationsMessage(p);

            if (violationsMessage.size() > 0) {
                violationsMessage.forEach(System.out::println);
            } else {
                this.productRepository.save(p);
            }
        });
    }

    @Override
    public void seedProductsWithCategory() {
        Category[] categories = this.categoryRepository.findAll().toArray(new Category[0]);
        int categoriesCount = categories.length;
        Product[] products = this.productRepository.findAll().toArray(new Product[0]);

        for (Product product : products) {
            int categoryId = this.random.nextInt(categoriesCount);
            product.getCategories().add(categories[categoryId]);
            this.productRepository.saveAndFlush(product);
        }
    }

    @Override
    public void saveProductsInRange() throws IOException, JAXBException {
        List<ProductInRange> products = this.productRepository.getAllProductsInRangeWithoutBuyer(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));
        ProductsInRange productsInRange = new ProductsInRange();
        productsInRange.setProducts(products);
        this.jaxbUtil.saveToXML("products-in-range", productsInRange);
    }

    @Override
    public void saveSuccessfullySoldProducts() throws IOException, JAXBException {
        List<User> users = this.productRepository.getSuccessfullySoldProductsByUsers();
        UserModel[] userModels = this.modelMapper.map(users, UserModel[].class);
        UsersModel usersModel = new UsersModel();
        usersModel.setUsers(Arrays.asList(userModels));
        this.jaxbUtil.saveToXML("users-sold-products", usersModel);
    }
}
