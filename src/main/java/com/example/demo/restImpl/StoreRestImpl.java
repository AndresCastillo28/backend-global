package com.example.demo.restImpl;

import com.example.demo.dto.request.StoreRequestDTO;
import com.example.demo.entity.Store;
import com.example.demo.rest.StoreRest;
import com.example.demo.service.StoreService;
import com.example.demo.utils.ApiResponse;
import com.example.demo.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoreRestImpl implements StoreRest {

    private final StoreService storeService;

    @Override
    public ResponseEntity<ApiResponse<Store>> save(StoreRequestDTO storeRequestDTO) {
        try {
            return  ResponseEntity.ok(ApiResponse.success(storeService.save(storeRequestDTO)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.SOMETHING_WENT_WRONG + ": " + e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<ApiResponse<List<Store>>> findAll() {
        try {
            return  ResponseEntity.ok(ApiResponse.success(storeService.findAll()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.SOMETHING_WENT_WRONG + ": " + e.getMessage()));
        }
    }
}
