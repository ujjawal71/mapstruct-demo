package com.example.mapstruct.spring.mapstructdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapstruct.spring.mapstructdemo.dto.ProductDto;
import com.example.mapstruct.spring.mapstructdemo.mapper.ProductMapper;
import com.example.mapstruct.spring.mapstructdemo.product.Product;
import com.example.mapstruct.spring.mapstructdemo.repository.ProductRepository;

@RestController
public class ProductController {

	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/products")
	public Product save(@RequestBody ProductDto productDto)
	{

		return productRepository.save(productMapper.DtoTomodel(productDto));
		
	}
	
	@GetMapping("/products")
	public List<ProductDto> findAll()
	{
		return productMapper.modelToDtos(productRepository.findAll());
		
	}
	
	
}
