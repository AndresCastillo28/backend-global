package com.example.demo.restImpl;

import com.example.demo.dto.request.TypeProductRequestDTO;
import com.example.demo.entity.TypeProduct;
import com.example.demo.rest.TypeProductRest;
import com.example.demo.service.TypeProductService;
import com.example.demo.utils.ApiResponse;
import com.example.demo.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TypeProductRestImpl implements TypeProductRest {

    private final TypeProductService typeProductService;

    @Override
    public ResponseEntity<ApiResponse<TypeProduct>> save(TypeProductRequestDTO typeProductRequestDTO) {
        try {
            return ResponseEntity.ok(ApiResponse.success(typeProductService.save(typeProductRequestDTO)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.SOMETHING_WENT_WRONG + ": " + e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<ApiResponse<List<TypeProduct>>> findAll() {
        try {
            return ResponseEntity.ok(ApiResponse.success(typeProductService.findAll()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.SOMETHING_WENT_WRONG + ": " + e.getMessage()));
        }
    }
}
