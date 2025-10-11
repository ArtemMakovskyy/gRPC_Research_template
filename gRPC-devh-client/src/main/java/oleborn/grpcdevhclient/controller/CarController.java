package oleborn.grpcdevhclient.controller;

import lombok.RequiredArgsConstructor;
import oleborn.grpcdevhclient.dto.CarBuyRequestDto;
import oleborn.grpcdevhclient.dto.CarInfoResponseDto;
import oleborn.grpcdevhclient.service.GetAutoGrpcClientService;
import oleborn.grpcdevhclient.service.RestServiceFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final GetAutoGrpcClientService service;
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