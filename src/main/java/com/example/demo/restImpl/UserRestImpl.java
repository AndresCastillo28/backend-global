package com.example.demo.restImpl;

import com.example.demo.dto.request.UserRequestDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.rest.UserRest;
import com.example.demo.service.UserService;
import com.example.demo.utils.ApiResponse;
import com.example.demo.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserRestImpl implements UserRest {

    private final UserService userService;

    @Override
    public ResponseEntity<ApiResponse<UserEntity>> save(UserRequestDTO userRequestDTO) {
        try {
            return ResponseEntity.ok(ApiResponse.success(userService.save(userRequestDTO)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.SOMETHING_WENT_WRONG + ": " + e.getMessage()));
        }
    }
}
