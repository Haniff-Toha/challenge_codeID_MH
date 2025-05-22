package com.codeid.eshopay.service.implementation;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codeid.eshopay.model.dto.CartDto;
import com.codeid.eshopay.model.dto.CartItemDto;
import com.codeid.eshopay.model.entity.Cart;
import com.codeid.eshopay.model.entity.CartItem;
import com.codeid.eshopay.model.entity.CartItemKey;
import com.codeid.eshopay.model.entity.Product;
import com.codeid.eshopay.model.entity.User;
import com.codeid.eshopay.repository.CartItemRepository;
import com.codeid.eshopay.repository.CartRepository;
import com.codeid.eshopay.service.CartService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public static CartDto mapToDto(Cart cart) {
        List<CartItemDto> cartItems = cart.getCartItems() != null
                ? cart.getCartItems().stream()
                        .map(CartItemServiceImpl::mapToDto)
                        .collect(Collectors.toList())
                : Collections.emptyList();

        return CartDto.builder()
                .cartId(cart.getCartId())
                .userId(cart.getUser().getUserId())
                .items(cartItems)
                .build();

    }

    public static Cart mapToEntity(CartDto cartDto) {
        return Cart.builder()
                .cartId(cartDto.getCartId())
                .user(User.builder().userId(cartDto.getUserId()).build())
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CartDto> findAll() {
        try {
            log.info("Fetching all carts");
            return cartRepository.findAll().stream()
                    .map(CartServiceImpl::mapToDto).toList();
        } catch (Exception e) {
            log.error("Error fetching all carts {}", e.getMessage());
            throw new RuntimeException("Failed to fetch projects", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public CartDto findById(Integer id) {
        log.info("Fecthing project with ID : {}", id);
        var cart = cartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found with id:" + id));
        return mapToDto(cart);
    }

    @Override
    @Transactional
    public CartDto save(CartDto entity) {
        log.info("Saving new cart: {}", entity.getCartId());
        // log.info("for user {}", entity.getUserId());
        Cart cart = mapToEntity(entity);
        Cart savedProject = cartRepository.save(cart);
        return mapToDto(savedProject);
    }

    @Override
    @Transactional
    public CartDto update(Integer id, CartDto entity) {
        // log.info("Updating cart with ID: {}", id);
        // var existingProject = this.cartRepository.findById(id)
        // .orElseThrow(() -> new EntityNotFoundException("Project not found with id : "
        // + id));

        // existingProject.setClient(entity.getClient());
        // existingProject.setProjectId(entity.getProjectId());
        // existingProject.setProjectName(entity.getProjectName());

        // var updateProject = this.projectRepository.save(existingProject);
        // return mapToDto(updateProject);
        throw new UnsupportedOperationException("Unimplemented method 'update'");

    }

    @Override
    public void delete(Integer id) {
        log.info("Deleting cart with ID: {}", id);
        var existingCart = this.cartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found with id : " + id));
        this.cartRepository.save(existingCart);
        log.info("Successfully deleted cart with ID: {}", id);
    }

    // @Override
    // public List<CartItemDto> getItemsByCartId(Integer cartId) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getItemsByCartId'");
    // }

    // @Override
    // public void updateItemQuantity(Integer cartId, Integer productId, Integer
    // newQuantity) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method
    // 'updateItemQuantity'");
    // }

    // @Override
    // public void removeItem(Integer cartId, Integer productId) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method 'removeItem'");
    // }

    @Override
    public CartDto addItem(Integer userId, CartItemDto cartItemDto) {
        log.info("Add item to Cart for user ID: {}", userId);
        // 1. cek apakah cart already exist
        Cart cartExisting = this.cartRepository.findByUserUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Cart not found for user ID : " + userId));

        // Inject cartId into dto
        cartItemDto.setCartId(cartExisting.getCartId());

        // 2. cek apakah product sudah ada di cartId
        var itemOptional = this.cartItemRepository
                .findByCartCartIdAndProductProductId(cartExisting.getCartId(),
                        cartItemDto.getProductId());

        // 2.2 Jika Product ada
        if (itemOptional.isPresent()) {
            // 2.1 Update quantity and return updated cart
            CartItem existingItem = itemOptional.get();
            existingItem.setQuantity(existingItem.getQuantity() + cartItemDto.getQuantity());

            // Optional: update unitPrice or discount if needed
            existingItem.setUnitPrice(cartItemDto.getUnitPrice());
            existingItem.setDiscount(cartItemDto.getDiscount());

            cartItemRepository.save(existingItem);
            log.info("Updated quantity for existing item in cart");
        }
        // 3. jika tidak ada ubah data dto ke entity
        else {
            // 3. Create new cart item
            CartItemKey newCartItemKey = new CartItemKey(cartItemDto.getCartId(), cartItemDto.getProductId());

            CartItem newItem = CartItem.builder()
                    .id(newCartItemKey)
                    .cart(cartExisting)
                    .product(Product.builder().productId(cartItemDto.getProductId()).build())
                    .quantity(cartItemDto.getQuantity())
                    .unitPrice(cartItemDto.getUnitPrice())
                    .discount(cartItemDto.getDiscount())
                    .build();

            // cartItemRepository.save(newItem);
            var cartItemSaved = this.cartItemRepository.save(newItem);

            // 3.4 tambahkan new item ke List<CartItem>
            List<CartItem> cartItems = List.of(cartItemSaved);
            cartExisting.setCartItems(cartItems);

            log.info("Successfully added new item to cart");
            return mapToDto(cartExisting);
        }
        // 4. Refresh cart items from DB and return DTO
        List<CartItem> updatedItems = cartItemRepository.findByCartCartId(cartExisting.getCartId());
        cartExisting.setCartItems(updatedItems);
        return mapToDto(cartExisting);
    }

    @Override
    public CartDto deleteItem(Integer userId, Integer productId) {
        log.info("Delete item from Cart for user ID: {} and product ID: {}", userId, productId);

        // 1. Get Cart by user ID
        Cart cart = this.cartRepository.findByUserUserId(userId)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found for user ID: " + userId));

        // 2. Find CartItem by cartId and productId
        CartItem cartItem = this.cartItemRepository
                .findByCartCartIdAndProductProductId(cart.getCartId(), productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found in cart with ID: " + productId));

        // 3. Delete CartItem
        this.cartItemRepository.delete(cartItem);

        // 4. Refresh cart items and return
        List<CartItem> updatedItems = cartItemRepository.findByCartCartId(cart.getCartId());
        cart.setCartItems(updatedItems);

        return mapToDto(cart);
    }

}
