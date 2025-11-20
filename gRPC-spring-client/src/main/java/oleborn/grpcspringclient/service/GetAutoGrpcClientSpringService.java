package oleborn.grpcspringclient.service;

import com.google.protobuf.Timestamp;
import io.grpc.Channel;
import lombok.extern.slf4j.Slf4j;
import com.grpc.common.CarBuyRequest;
import com.grpc.common.CarServiceGrpc;
import com.grpc.common.ListCarResponse;
import oleborn.grpcspringclient.dto.CarBuyRequestDto;
import oleborn.grpcspringclient.dto.CarInfoResponseDto;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GetAutoGrpcClientSpringService {

    private final CarServiceGrpc.CarServiceBlockingStub syncClient;

    public GetAutoGrpcClientSpringService(Channel channel) {
        this.syncClient = CarServiceGrpc.newBlockingStub(channel);
    }

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