package com.asm.service.implement;

import com.asm.entity.Cart;
import com.asm.entity.Drinkingcup;
import com.asm.responsitory.DrinkingcupRepository;
import com.asm.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class CartService implements ICartService {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private DrinkingcupRepository drinkingcupRepository;
    @Autowired
    private HttpServletResponse httpServletResponse;


    @Override
    public void addToCart(long productId, long amount) {

        HttpSession session = request.getSession();
        Optional<Drinkingcup> optionalDrinkingcup = drinkingcupRepository.findById(productId);
        HashMap<Long, Cart> cart = (HashMap<Long, Cart>) session.getAttribute("listCart");
        long amountDrinking =0;
        if (cart == null) {
            cart = new HashMap<Long, Cart>();

            Cart carts = new Cart(amount, optionalDrinkingcup.get());
            cart.put(productId, carts);
        } else {

            if (cart.containsKey(optionalDrinkingcup.get().getId())) {
                Cart carts = cart.get(optionalDrinkingcup.get().getId());
                carts.amountAdd();

            } else {
                Cart carts = new Cart(1L, optionalDrinkingcup.get());
                cart.put(productId, carts);

            }
        }

        session.setAttribute("listCart", cart);
        this.subTotal();
    }


    @Override
    public void changeProductQuantity(long productId) {
        HttpSession session = request.getSession();
        Optional<Drinkingcup> optionalDrinkingcup = drinkingcupRepository.findById(productId);
        HashMap<Long, Cart> cart = (HashMap<Long, Cart>) session.getAttribute("listCart");
        Cart carts = cart.get(optionalDrinkingcup.get().getId());
        carts.amountAdd();
        cart.put(productId, carts);
        this.subTotal();

    }

    @Override
    public void changeProductQuantityUp(long productId) {
        HttpSession session = request.getSession();
        Optional<Drinkingcup> optionalDrinkingcup = drinkingcupRepository.findById(productId);
        HashMap<Long, Cart> cart = (HashMap<Long, Cart>) session.getAttribute("listCart");
        Cart carts = cart.get(optionalDrinkingcup.get().getId());
        carts.amountUp();
        cart.put(productId, carts);
        this.subTotal();
    }

    public void subTotal() {
        double sum = 0;
        HttpSession session = request.getSession();
        HashMap<Long, Cart> cart = (HashMap<Long, Cart>) session.getAttribute("listCart");
        for (Map.Entry<Long, Cart> entry : cart.entrySet()) {
            System.out.println("sum èn");
            Long key = entry.getKey();
            Cart val = entry.getValue();
            sum += val.getIdDrinkingCups().getPrice() * val.getAmount();
        }

        session.setAttribute("sum", sum);
        session.setAttribute("shippingFee", 35000);
        session.setAttribute("sumTT", sum + 35000);

    }

    @Override
    public void removeProduct(long productId) {
        Cart carts = new Cart();
        HttpSession session = request.getSession();
        Optional<Drinkingcup> optionalDrinkingcup = drinkingcupRepository.findById(productId);
        HashMap<Long, Cart> cart = (HashMap<Long, Cart>) session.getAttribute("listCart");
        if (cart.containsKey(productId)) {
            cart.remove(productId);
            carts = cart.get(productId);
            session.setAttribute("message", "Delete thành công");
        }
        session.setAttribute("listCart", cart);
        this.subTotal();
    }

    @Override
    public void removeProducts() {
        request.getSession().removeAttribute("listCart");
        HttpSession session = request.getSession();
        session.setAttribute("sum", 0);
        session.setAttribute("shippingFee", 0);
        session.setAttribute("sumTT", 0);
    }
}
