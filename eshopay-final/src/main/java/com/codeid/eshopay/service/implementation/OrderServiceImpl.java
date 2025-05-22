package com.codeid.eshopay.service.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codeid.eshopay.model.dto.OrderDto;
import com.codeid.eshopay.model.dto.OrderResponseDto;
import com.codeid.eshopay.model.entity.Cart;
import com.codeid.eshopay.model.entity.CartItem;
import com.codeid.eshopay.model.entity.Location;
import com.codeid.eshopay.model.entity.Order;
import com.codeid.eshopay.model.entity.OrderDetail;
import com.codeid.eshopay.model.entity.User;
import com.codeid.eshopay.repository.CartRepository;
import com.codeid.eshopay.repository.OrderDetailRepository;
import com.codeid.eshopay.repository.OrderRepository;
import com.codeid.eshopay.service.OrderService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final OrderDetailRepository orderDetailRepository;

    private OrderDto mapToDto(Order order) {
    return OrderDto.builder()
            .orderId(order.getOrderId())
            .orderDate(order.getOrderDate())
            .shipName(order.getShipName())
            .totalAmount(order.getTotalAmount())
            .paymentType(order.getPaymentType())
            .build();
}
    
    
    @Override
    public List<Order> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Order findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Order save(Order entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Order update(Integer id, Order entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    @Transactional
    public OrderDto createOrder(Integer userId, OrderResponseDto orderResponseDto) {
        // 1. Get user's cart
    Cart cart = cartRepository.findByUserUserId(userId)
            .orElseThrow(() -> new EntityNotFoundException("Cart not found for user: " + userId));

    if (cart.getCartItems().isEmpty()) {
        throw new IllegalStateException("Cart is empty");
    }

    // 2. Calculate total and discount
    double totalAmount = 0.0;
    double totalDiscount = 0.0;

    List<OrderDetail> orderDetails = new ArrayList<>();
    for (CartItem item : cart.getCartItems()) {
        double price = item.getProduct().getUnitPrice();
        double discount = item.getDiscount() != null ? item.getDiscount() : 0.0;
        int quantity = item.getQuantity();

        OrderDetail detail = OrderDetail.builder()
                .product(item.getProduct())
                .quantity(quantity)
                .unitPrice(price)
                .discount(discount)
                .build();

        orderDetails.add(detail);

        totalAmount += price * quantity;
        totalDiscount += discount * quantity;
    }

    // 3. Create Order entity
    Order order = Order.builder()
            .user(User.builder().userId(userId).build())
            .orderDate(LocalDate.now())
            .requiredDate(orderResponseDto.getRequiredDate())
            .transacNo(orderResponseDto.getTransacNo())
            .transacDate(orderResponseDto.getTransacDate())
            .paymentType(orderResponseDto.getPaymentType())
            .shipVia(orderResponseDto.getShipVia())
            .shipName(orderResponseDto.getShipName())
            .location(Location.builder().locationId(orderResponseDto.getLocationId()).build())
            .totalAmount(totalAmount)
            .totalDiscount(totalDiscount)
            .build();

    order.setOrderDetails(orderDetails); // assuming one-to-many is set properly

    for (OrderDetail detail : orderDetails) {
        detail.setOrder(order); // set the relationship
    }

    // 4. Save order and clear cart
    Order savedOrder = orderRepository.save(order);

    cart.getCartItems().clear();
    cartRepository.save(cart);

    // 5. Return DTO
    return mapToDto(savedOrder);
    }
    
}
