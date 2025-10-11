package oleborn.grpcspringclient.service;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oleborn.grpcspringclient.dto.CarBuyRequestDto;
import oleborn.grpcspringclient.dto.CarInfoResponseDto;
import oleborn.grpcspringclient.feign.client.RestServiceFeignClient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestServiceFacade {

    private final RestServiceFeignClient feignClient;

    public CarInfoResponseDto createEntity(CarBuyRequestDto dto) {
        try {
            log.info("Получен запрос с данными: {}", dto);

            CarInfoResponseDto response = feignClient.createEntity(dto);

            log.info("Получен ответ через feign: {}", response);

            return response;

        } catch (FeignException e) {
            log.error("Feign call failed: {}", e.getMessage());
            throw new RuntimeException("Remote service unavailable", e);
        }
    }
}
