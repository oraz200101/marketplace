package com.example.demomarketplace.dto;

import com.example.demomarketplace.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BucketDto {
 private Long id;
 private UserDto userDto;
 private List<ProductDtoMini>productDtoMinis;
}
