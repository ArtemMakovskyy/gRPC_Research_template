package oleborn.grpcspringclient.feign.client;


import oleborn.grpcspringclient.dto.CarBuyRequestDto;
import oleborn.grpcspringclient.dto.CarInfoResponseDto;
import oleborn.grpcspringclient.feign.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "rest-service-client",
        url = "${feign.client.rest-service.url:http://localhost:8080}",
        configuration = FeignConfig.class
)
public interface RestServiceFeignClient {

    @PostMapping("/v1/test-feign")
    CarInfoResponseDto createEntity(@RequestBody CarBuyRequestDto requestDto);

}