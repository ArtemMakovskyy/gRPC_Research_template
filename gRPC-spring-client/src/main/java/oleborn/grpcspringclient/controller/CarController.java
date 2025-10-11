package oleborn.grpcspringclient.controller;

import lombok.RequiredArgsConstructor;
import oleborn.grpcspringclient.dto.CarBuyRequestDto;
import oleborn.grpcspringclient.dto.CarInfoResponseDto;
import oleborn.grpcspringclient.service.GetAutoGrpcClientSpringService;
import oleborn.grpcspringclient.service.RestServiceFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final GetAutoGrpcClientSpringService service;
    private final RestServiceFacade serviceFacade;

    @PostMapping("/get-car")
    public ResponseEntity<CarInfoResponseDto> getCar(@RequestBody CarBuyRequestDto dto) {
        return ResponseEntity.ok(service.getInfoCar(dto));
    }

    @PostMapping("/getRest-car")
    public ResponseEntity<CarInfoResponseDto> createViaFeign(
            @RequestBody CarBuyRequestDto dto
    ) {
        return ResponseEntity.ok(serviceFacade.createEntity(dto));
    }
}