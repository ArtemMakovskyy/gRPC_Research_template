package oleborn.restserver.controller;

import lombok.extern.slf4j.Slf4j;
import oleborn.restserver.domain.dto.CarBuyRequestDto;
import oleborn.restserver.domain.dto.CarInfoResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/v1")
@Slf4j
public class RestController {

    @PostMapping("/test-feign")
    public ResponseEntity<CarInfoResponseDto> greet(@RequestBody CarBuyRequestDto requestDto) {

        log.info("Пользователю с именем {}, родившемуся: {}, на бюджет: {}, предложена машина.",
                requestDto.userName(),
                requestDto.userBirthDate(),
                requestDto.budget()
        );

        return ResponseEntity.ok(
                CarInfoResponseDto.builder()
                        .id(1)
                        .carStatus(CarStatus.ACTIVE)
                        .details(List.of("Дверь", "Колесо"))
                        .metadata(Map.of("Color", "RED"))
                        .modelName("LADA")
                        .yearCreated(2000)
                        .build()
        );
    }

}
