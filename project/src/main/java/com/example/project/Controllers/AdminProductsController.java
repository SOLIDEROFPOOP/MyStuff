package com.example.project.Controllers;

import com.example.project.models.data.Category;
import com.example.project.models.data.Product;
import com.example.project.models.CategoryRepository;
import com.example.project.models.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin/products")
public class AdminProductsController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @GetMapping()
    public String index(Model model){


        List<Product> products = productRepository.findAll();
        List<Category> categories = categoryRepository.findAll();

        HashMap<Integer , String> cats = new HashMap<>();

        for (Category cat : categories) {
            cats.put(cat.getId(), cat.getName());
        }

        model.addAttribute("products", products);
        model.addAttribute("cats", cats);

        return "admin/products/index";
    }
    @GetMapping("/add")
    public String add(@ModelAttribute Product product, Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "admin/products/add";
    }
    @PostMapping("/add")
    public String add(@Valid Product product, BindingResult bindingResult, MultipartFile file , RedirectAttributes redirectAttributes, Model model) throws IOException {
        List<Category> categories = categoryRepository.findAll();
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categories);
            return "admin/products/add";
        }
        boolean fileOk = false;
        byte[] bytes = file.getBytes();
        String filename = file.getOriginalFilename();
        Path path = Paths.get("src/main/resources/static/media/" + filename);
        if (filename.endsWith("jpg") || filename.endsWith("png")) {
            fileOk = true;
        }
        redirectAttributes.addFlashAttribute("message", "Product added");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        String slug = product.getName().toLowerCase().replace(" ", "-");
        Product productExists = productRepository.findBySlug(slug);

        if (!fileOk){
            redirectAttributes.addFlashAttribute("message", "Image must be jpg or png");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            redirectAttributes.addFlashAttribute("product", product);
        }
        else if (productExists != null){
            redirectAttributes.addFlashAttribute("message", "Product exists choose another");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        } else {
            product.setSlug(slug);
            product.setImage(filename);
            productRepository.save(product);
            Files.write(path, bytes);
        }
        return "redirect:/admin/products/add";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        List<Category> categories = categoryRepository.findAll();
        Product product = productRepository.getOne(id);

        model.addAttribute("product", product);
        model.addAttribute("categories", categories);

        return "admin/products/edit";
    }
    @PostMapping("/edit")
    public String edit(@Valid Product product, BindingResult bindingResult, MultipartFile file , RedirectAttributes redirectAttributes, Model model) throws IOException {
        Product currentProduct = productRepository.getOne(product.getId());
        List<Category> categories = categoryRepository.findAll();
        if (bindingResult.hasErrors()) {
            model.addAttribute("productName", currentProduct.getName());
            model.addAttribute("categories", categories);
            return "admin/products/edit";
        }
        boolean fileOk = false;
        byte[] bytes = file.getBytes();
        String filename = file.getOriginalFilename();
        Path path = Paths.get("src/main/resources/static/media/" + filename);
        if (!file.isEmpty()){
            if (filename.endsWith("jpg") || filename.endsWith("png")) {
                fileOk = true;
            }
        } else {
            fileOk = true;
        }
        if (filename.endsWith("jpg") || filename.endsWith("png")) {
            fileOk = true;
        }
        redirectAttributes.addFlashAttribute("message", "Product edited");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        String slug = product.getName().toLowerCase().replace(" ", "-");
        Product productExists = productRepository.findBySlugAndIdNot(slug , product.getId());

        if (!fileOk){
            redirectAttributes.addFlashAttribute("message", "Image must be jpg or png");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            redirectAttributes.addFlashAttribute("product", product);
        }
        else if (productExists != null){
            redirectAttributes.addFlashAttribute("message", "Product exists choose another");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
        } else {
            product.setSlug(slug);
            if (!file.isEmpty()){
                Path path2 = Paths.get("src/main/resources/static/media/" + currentProduct.getImage());
                Files.delete(path2);
                product.setImage(filename);
                Files.write(path, bytes);
            } else {
                product.setImage(currentProduct.getImage());
            }
            productRepository.save(product);

        }
        return "redirect:/admin/products/edit/" + product.getId();
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) throws IOException {
        Product product = productRepository.getOne(id);
        Product currentProduct = productRepository.getOne(product.getId());
        productRepository.deleteById(id); // deleteById is a method from CrudRepository
        Path path2 = Paths.get("src/main/resources/static/media/" + currentProduct.getImage());
        Files.delete(path2);
        redirectAttributes.addFlashAttribute("message", "Product deleted");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/admin/products";
    }
}
