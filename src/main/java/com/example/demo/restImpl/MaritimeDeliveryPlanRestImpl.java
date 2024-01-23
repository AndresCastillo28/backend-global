package com.example.demo.restImpl;

import com.example.demo.entity.MaritimeDeliveryPlan;
import com.example.demo.entity.Store;
import com.example.demo.rest.MaritimeDeliveryPlanRest;
import com.example.demo.service.DeliveryPlanService;
import com.example.demo.service.MaritimeDeliveryService;
import com.example.demo.service.StoreService;
import com.example.demo.serviceImpl.MaritimeDeliveryPlanServiceImpl;
import com.example.demo.utils.ApiResponse;
import com.example.demo.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MaritimeDeliveryPlanRestImpl implements MaritimeDeliveryPlanRest {

    private final MaritimeDeliveryService maritimeDeliveryService;

    public ResponseEntity<ApiResponse<MaritimeDeliveryPlan>> save(MaritimeDeliveryPlan maritimeDeliveryPlan) {
        try {
            return  ResponseEntity.ok(ApiResponse.success(maritimeDeliveryService.save(maritimeDeliveryPlan)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.SOMETHING_WENT_WRONG + ": " + e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<ApiResponse<MaritimeDeliveryPlan>> update(MaritimeDeliveryPlan maritimeDeliveryPlan) {
        try {
            return  ResponseEntity.ok(ApiResponse.success(maritimeDeliveryService.update(maritimeDeliveryPlan)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.SOMETHING_WENT_WRONG + ": " + e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<ApiResponse<Void>> delete(int id) {
        try {
            maritimeDeliveryService.delete(id);
            return  ResponseEntity.ok(ApiResponse.success(null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.SOMETHING_WENT_WRONG + ": " + e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<ApiResponse<MaritimeDeliveryPlan>> findById(int id) {
        try {
            return  ResponseEntity.ok(ApiResponse.success(maritimeDeliveryService.findById(id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.SOMETHING_WENT_WRONG + ": " + e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<ApiResponse<List<MaritimeDeliveryPlan>>> findAll() {
        try {
            return  ResponseEntity.ok(ApiResponse.success(maritimeDeliveryService.findAll()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.SOMETHING_WENT_WRONG + ": " + e.getMessage()));
        }
    }
}
