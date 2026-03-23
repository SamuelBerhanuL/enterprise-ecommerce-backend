package com.enterprise.ecommerce.order;

import com.enterprise.ecommerce.entity.Order;
import com.enterprise.ecommerce.entity.Product;
import com.enterprise.ecommerce.entity.User;
import com.enterprise.ecommerce.repository.OrderRepository;
import com.enterprise.ecommerce.repository.ProductRepository;
import com.enterprise.ecommerce.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public OrderController(OrderRepository orderRepository,
                           UserRepository userRepository,
                           ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @PostMapping
    public Order placeOrder(@RequestBody OrderRequest request, Authentication authentication) {

        String email = authentication.getName();

        User user = userRepository.findByEmail(email);
        Product product = productRepository.findById(request.getProductId()).orElse(null);

        if (user == null || product == null) {
            return null;
        }

        Order order = new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PLACED");

        return orderRepository.save(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}