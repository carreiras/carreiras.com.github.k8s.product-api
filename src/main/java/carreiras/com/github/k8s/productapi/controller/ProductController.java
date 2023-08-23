package carreiras.com.github.k8s.productapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import carreiras.com.github.k8s.dto.product.ProductRequest;
import carreiras.com.github.k8s.productapi.entity.Product;
import carreiras.com.github.k8s.productapi.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    public Product create(@RequestBody @Valid ProductRequest productRequest) {
        return productService.create(productRequest);
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> findByCategoryId(@PathVariable Long categoryId) {
        return productService.findByCategoryId(categoryId);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping("/identifier/{identifier}")
    public Product findByIdentifier(@PathVariable String identifier) {
        return productService.findByIdentifier(identifier);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody @Valid ProductRequest productRequest) {
        return productService.update(id, productRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}