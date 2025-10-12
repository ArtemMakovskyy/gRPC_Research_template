package oleborn.grpcserver.service;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import oleborn.grpc.common.CarBuyRequest;
import oleborn.grpc.common.CarServiceGrpc;
import oleborn.grpc.common.CarStatus;
import oleborn.grpc.common.ListCarResponse;
import org.springframework.grpc.server.service.GrpcService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

// Аннотация, которая помечает класс как gRPC сервис для автоматического сканирования Spring'ом
// Spring gRPC автоматически найдет этот класс и зарегистрирует его как gRPC endpoint
@GrpcService
@Slf4j
public class CarServiceImpl extends CarServiceGrpc.CarServiceImplBase {

    @Override
    public void buyCar(
            CarBuyRequest request,  // Входящий запрос от клиента (автоматически десериализован из Protobuf)
            StreamObserver<ListCarResponse> responseObserver // Колбэк для отправки ответа клиенту (асинхронный поток)
    ) {

        // Преобразуем Timestamp в читаемую дату
        String formattedBirthDate = formatTimestamp(request.getUserBirthDate());

        log.info("Пользователю с именем {}, родившемуся: {}, на бюджет: {}, предложена машина.",
                request.getUserName(),
                formattedBirthDate,
                request.getBudget()
        );

        // Создание ответа используя Builder паттерн от сгенерированного Protobuf класса
        // Protobuf автоматически генерирует классы с Builder паттерном для создания иммутабельных объектов
        ListCarResponse response = ListCarResponse.newBuilder()
                .setId(1L)
                .setModelName("Tesla Model S")
                .setYearCreated(2023)
                .addDetails("Electric")
                .putMetadata("color", "red")
                .setCarStatus(CarStatus.ACTIVE)
                .build();

        // Отправка ответа клиенту через потоковый observer
        // onNext() отправляет один ответ в поток (для unary call - один ответ)
        responseObserver.onNext(response);

        // Завершение gRPC вызова - сигнализирует клиенту, что ответ завершен
        // Без этого вызова клиент будет ждать продолжения потока
        responseObserver.onCompleted();
    }

    private String formatTimestamp(com.google.protobuf.Timestamp timestamp) {
        if (timestamp == null) {
            return "не указана";
        }

        try {
            Instant instant = Instant.ofEpochSecond(timestamp.getSeconds(), timestamp.getNanos());

            LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));
            
            return DateTimeFormatter.ofPattern("dd.MM.yyyy в HH:mm:ss").format(dateTime);


        } catch (Exception e) {
            log.warn("Ошибка при форматировании даты: {}", e.getMessage());
            return "ошибка формата";
        }
    }
}