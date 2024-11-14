package com.example.product.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.product.entity.ProductEntity;
import com.example.product.service.ProductService;

@Controller
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}


	@RequestMapping("/get-time")
	public ModelAndView getCurrentTime() {
		return new ModelAndView("display.jsp", "time", LocalDateTime.now());
	}


	@RequestMapping(path = "/add-product",method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute ProductEntity product) {
		productService.addProduct(product);
		return new ModelAndView("redirect:/index.jsp");
	}

	@RequestMapping("/display-all")
	public ModelAndView findAllProduct() {
		List<ProductEntity> products=productService.findAllProduct();
		return new ModelAndView("display_product.jsp","product",products);
	}
	
	@RequestMapping("/delete-product")
	public ModelAndView deleteProduct(@RequestParam("product_id") int productId) {
		productService.deleteProduct(productId);
		return new ModelAndView("redirect:/display-all");	
	}
	
	@RequestMapping(path = "/update-product",method = RequestMethod.GET)
	public ModelAndView updateProduct(@RequestParam("product_id") int productId) {
		ProductEntity product= productService.findProduct(productId);
		return new ModelAndView("update-product.jsp","products",product);
	}
	
	@RequestMapping(path = "/update-product",method = RequestMethod.POST)
	public ModelAndView finalUpdate(@ModelAttribute ProductEntity product) {
		productService.finalUpdate(product);
		return new ModelAndView("redirect:/display-all");
	}
}

