package com.example.mapstruct.spring.mapstructdemo.mapper;

import java.util.List;
import java.util.UUID;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


import com.example.mapstruct.spring.mapstructdemo.dto.ProductDto;
import com.example.mapstruct.spring.mapstructdemo.product.Product;

@Mapper(componentModel="spring",imports =UUID.class)
public interface ProductMapper {
	
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
	@Mapping(source="product.des",target="description",defaultValue ="description")
	@Mapping(target="itemId",expression ="java(UUID.randomUUID().toString())")
	ProductDto modelToDto(Product product);
	
	List<ProductDto> modelToDtos(List<Product> list);
	
	//@Mapping(source="productDto.description",target="des",defaultValue ="description")
	@InheritInverseConfiguration
	Product DtoTomodel(ProductDto productDto);

}
