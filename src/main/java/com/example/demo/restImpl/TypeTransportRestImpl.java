package com.example.demo.restImpl;

import com.example.demo.entity.TypeTransport;
import com.example.demo.rest.TypeTransportRest;
import com.example.demo.service.TypeTransportService;
import com.example.demo.utils.ApiResponse;
import com.example.demo.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TypeTransportRestImpl implements TypeTransportRest {

    private final TypeTransportService typeTransportService;

    @Override
    public ResponseEntity<ApiResponse<List<TypeTransport>>> finAll() {
        try {
            return ResponseEntity.ok(ApiResponse.success(typeTransportService.findAll()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.SOMETHING_WENT_WRONG + ": " + e.getMessage()));
        }
    }
}
