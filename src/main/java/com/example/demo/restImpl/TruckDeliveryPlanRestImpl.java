package com.example.demo.restImpl;

import com.example.demo.entity.MaritimeDeliveryPlan;
import com.example.demo.entity.TruckDeliveryPlan;
import com.example.demo.rest.TruckDeliveryPlanRest;
import com.example.demo.service.TruckDeliveryService;
import com.example.demo.utils.ApiResponse;
import com.example.demo.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TruckDeliveryPlanRestImpl implements TruckDeliveryPlanRest {

    private final TruckDeliveryService truckDeliveryService;

    @Override
    public ResponseEntity<ApiResponse<TruckDeliveryPlan>> save(TruckDeliveryPlan truckDeliveryPlan) {
        try {
            TruckDeliveryPlan truckDeliveryPlan1 = truckDeliveryService.save(truckDeliveryPlan);
            return ResponseEntity.ok(ApiResponse.success(truckDeliveryPlan1));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.SOMETHING_WENT_WRONG + ": " + e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<ApiResponse<TruckDeliveryPlan>> update(TruckDeliveryPlan truckDeliveryPlan) {
        try {
            return  ResponseEntity.ok(ApiResponse.success(truckDeliveryService.update(truckDeliveryPlan)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.SOMETHING_WENT_WRONG + ": " + e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<ApiResponse<Void>> delete(int id) {
        try {
            truckDeliveryService.delete(id);
            return  ResponseEntity.ok(ApiResponse.success(null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.SOMETHING_WENT_WRONG + ": " + e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<ApiResponse<TruckDeliveryPlan>> findById(int id) {
        try {
            return  ResponseEntity.ok(ApiResponse.success(truckDeliveryService.findById(id)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.SOMETHING_WENT_WRONG + ": " + e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<ApiResponse<List<TruckDeliveryPlan>>> findAll() {
        try {
            return  ResponseEntity.ok(ApiResponse.success(truckDeliveryService.findAll()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.SOMETHING_WENT_WRONG + ": " + e.getMessage()));
        }
    }
}
