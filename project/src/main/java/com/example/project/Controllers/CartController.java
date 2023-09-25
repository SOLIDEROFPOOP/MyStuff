package com.example.project.Controllers;

import com.example.project.data.Product;
import com.example.project.models.Cart;
import com.example.project.models.ProductRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/add/{id}")
    public String add(@PathVariable int id, HttpSession session, Model model){
        Product product = productRepository.getOne(id);
         if(session.getAttribute("cart") == null){
             HashMap<Integer, Cart> cart = new HashMap<>();
             cart.put(id , new Cart(id , product.getName(), product.getPrice(), 1, product.getImage()));
             session.setAttribute("cart", cart);
         }else{
            HashMap<Integer , Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("cart");
             if (cart.containsKey(id)){
                int qty = cart.get(id).getQuantity();
                 cart.put(id , new Cart(id , product.getName(), product.getPrice(), ++qty, product.getImage()));
             }else{
                 cart.put(id , new Cart(id , product.getName(), product.getPrice(), 1, product.getImage()));
                 session.setAttribute("cart", cart);
             }
         }
         HashMap<Integer , Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("cart");
         int size = 0;
         double total = 0;
        for (Cart value : cart.values()){
            size += value.getQuantity();
            total += value.getQuantity() * Double.parseDouble(value.getPrice());
        }
        model.addAttribute("size" , size);
        model.addAttribute("total" , total);
         return "cart_view";
    }
    @RequestMapping("/view")
    public String view(HttpSession session, Model model){
        if (session.getAttribute("cart") == null){
            return "redirect:/";
        }
        HashMap<Integer , Cart> cart = (HashMap<Integer, Cart>) session.getAttribute("cart");
        model.addAttribute("cart" , cart);
        return "cart";
    }
}
