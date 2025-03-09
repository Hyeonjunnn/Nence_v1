package com.nence.nence_v1.controller;

import com.nence.nence_v1.data.dto.ChangeProductNameDto;
import com.nence.nence_v1.data.dto.ProductDto;
import com.nence.nence_v1.data.dto.ProductResponseDto;
import com.nence.nence_v1.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "상품 API", description = "상품 관련 API입니다.")
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    @Operation(summary = "상품 단건 조회 API", description = "상품 number를 받아와 상품을 조회합니다.")
    @Parameters({
            @Parameter(name = "number", description = "상품 번호", example = "1"),
    })
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
//                    content = @Content(mediaType = "application/json")
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProductResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "NOT FOUND",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "INTERNAL SERVER ERROR",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<ProductResponseDto> getProduct(Long number) {
        ProductResponseDto productResponseDto = productService.getProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PostMapping()
    @Operation(summary = "상품 등록 API", description = "상품 정보를 받아와 상품을 등록합니다.")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto) {
        ProductResponseDto productResponseDto = productService.saveProduct(productDto);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PutMapping()
    @Operation(summary = "상품 수정 API", description = "변경할 상품 정보를 받아와 상품 정보를 수정합니다.")
    public ResponseEntity<ProductResponseDto> changeProductName(
            @RequestBody ChangeProductNameDto changeProductNameDto
    ) throws Exception {
        ProductResponseDto productResponseDto = productService.changeProductName(
                changeProductNameDto.getNumber(),
                changeProductNameDto.getName()
        );

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @DeleteMapping()
    @Operation(summary = "상품 삭제 API", description = "상품 number를 받아와 상품을 삭제합니다.")
    public ResponseEntity<String> deleteProduct(Long number) throws Exception {
        productService.deleteProduct(number);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}
