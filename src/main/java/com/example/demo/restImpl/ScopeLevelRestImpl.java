package com.example.demo.restImpl;

import com.example.demo.entity.ScopeLevel;
import com.example.demo.rest.ScopeLevelRest;
import com.example.demo.service.ScopeLevelService;
import com.example.demo.utils.ApiResponse;
import com.example.demo.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScopeLevelRestImpl implements ScopeLevelRest {

    private final ScopeLevelService scopeLevelService;

    @Override
    public ResponseEntity<ApiResponse<List<ScopeLevel>>> findAll() {
        try {
            return  ResponseEntity.ok(ApiResponse.success(scopeLevelService.findAll()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.SOMETHING_WENT_WRONG + ": " + e.getMessage()));
        }
    }
}
