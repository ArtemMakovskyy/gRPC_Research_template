package oleborn.grpcdevhclient.service;

import com.google.protobuf.Timestamp;
import com.grpc.common.CarBuyRequest;
import com.grpc.common.CarServiceGrpc;
import com.grpc.common.ListCarResponse;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import oleborn.grpcdevhclient.dto.CarBuyRequestDto;
import oleborn.grpcdevhclient.dto.CarInfoResponseDto;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GetAutoGrpcClientService {

    @GrpcClient("get-auto-service")
    private CarServiceGrpc.CarServiceBlockingStub syncClient;

    public CarInfoResponseDto getInfoCar(CarBuyRequestDto request){
        log.info("Отправляем запрос с данными: {}", request);

        CarBuyRequest carBuyRequest = CarBuyRequest.newBuilder()
                .setUserName(request.userName())
                .setUserBirthDate(Timestamp.newBuilder()
                        .setSeconds(request.userBirthDate().getEpochSecond())
                        .setNanos(request.userBirthDate().getNano())
                        .build())
                .setBudget(request.budget())
                .build();

        ListCarResponse response = syncClient.buyCar(carBuyRequest);

        log.info("Получен ответ, возвращаю клиенту: {}", response);

        return CarInfoResponseDto.builder()
                .id(response.getId())
                .carStatus(response.getCarStatus())
                .details(response.getDetailsList())
                .metadata(response.getMetadataMap())
                .modelName(response.getModelName())
                .yearCreated(response.getYearCreated())
                .build();

    }
}