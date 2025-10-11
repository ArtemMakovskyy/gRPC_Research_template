# Введение в gRPC

## Что такое gRPC?

gRPC (Google Remote Procedure Call) — это современный высокопроизводительный фреймворк удаленного вызова процедур (RPC) с открытым исходным кодом, который может работать в любой среде. Он был создан Google в 2016 году как переработка внутренней инфраструктуры RPC компании. gRPC основан на идее определения сервиса, который указывает методы, вызываемые удаленно, с их параметрами и типами возвращаемых значений.

Ключевые особенности gRPC включают:

*   **Высокая производительность**: Использует HTTP/2 в качестве транспортного протокола, что обеспечивает мультиплексирование, потоковую передачу и эффективное использование соединений.
*   **Protocol Buffers**: Использует Protocol Buffers (Protobuf) в качестве языка определения интерфейса (IDL) и формата сериализации сообщений. Protobuf обеспечивает компактную и эффективную сериализацию данных, что способствует высокой производительности.
*   **Многоязычность**: Поддерживает множество языков программирования, позволяя клиентам и серверам быть написанными на разных языках.
*   **Двунаправленная потоковая передача**: Поддерживает четыре типа сервисных методов: унарные, серверные потоки, клиентские потоки и двунаправленные потоки, что делает его идеальным для приложений, требующих обмена данными в реальном времени.
*   **Генерация кода**: Автоматически генерирует клиентские и серверные заглушки (stubs) из файлов `.proto`, что упрощает разработку и обеспечивает согласованность.

## gRPC против REST

Выбор между gRPC и REST (Representational State Transfer) зависит от конкретных требований проекта, существующей инфраструктуры и опыта команды. Оба являются популярными подходами к созданию API, но имеют существенные различия.

| Характеристика          | gRPC                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 | REST                                                                                                                                                                                                                                                                                                                      - **Транспорт**: HTTP/1.1
- **Формат данных**: JSON (чаще всего), XML
- **Определение API**: OpenAPI (Swagger)
- **Типы вызовов**: Запрос-ответ (Request-Response)
- **Производительность**: Медленнее из-за текстового формата JSON и особенностей HTTP/1.1
- **Поддержка браузерами**: Полная поддержка
- **Генерация кода**: Требуются сторонние инструменты

## Protocol Buffers

Protocol Buffers (Protobuf) — это язык определения интерфейса (IDL) и формат сериализации данных, разработанный Google. Он используется для определения структуры данных и сервисов в gRPC.

### Пример определения Protobuf

```protobuf
syntax = "proto3";

package oleborn.grpcserver;

option java_multiple_files = true;
option java_package = "oleborn.grpcserver";
option java_outer_classname = "GreetingProto";

// Сервис для приветствия
service GreetingService {
  // Унарный RPC
  rpc greet(GreetingRequest) returns (GreetingResponse);
}

// Запрос на приветствие
message GreetingRequest {
  string name = 1;
}

// Ответ с приветствием
message GreetingResponse {
  string greeting = 1;
}
```

В этом примере мы определяем:

*   **Сервис `GreetingService`** с одним унарным методом `greet`.
*   **Сообщение `GreetingRequest`**, которое содержит одно поле `name` типа `string`.
*   **Сообщение `GreetingResponse`**, которое содержит одно поле `greeting` типа `string`.

### Типы данных Protobuf

Protobuf поддерживает различные скалярные типы данных, такие как `string`, `int32`, `int64`, `float`, `double`, `bool` и `bytes`. Также поддерживаются составные типы, такие как `enum` и `message`.

## Типы RPC в gRPC

gRPC поддерживает четыре типа RPC:

1.  **Унарный RPC (Unary RPC)**: Клиент отправляет один запрос и получает один ответ. Это самый простой тип RPC.

    ```protobuf
    rpc SayHello(HelloRequest) returns (HelloResponse);
    ```

2.  **Серверный потоковый RPC (Server streaming RPC)**: Клиент отправляет один запрос и получает поток сообщений от сервера.

    ```protobuf
    rpc LotsOfReplies(HelloRequest) returns (stream HelloResponse);
    ```

3.  **Клиентский потоковый RPC (Client streaming RPC)**: Клиент отправляет поток сообщений на сервер и получает один ответ.

    ```protobuf
    rpc LotsOfGreetings(stream HelloRequest) returns (HelloResponse);
    ```

4.  **Двунаправленный потоковый RPC (Bidirectional streaming RPC)**: Клиент и сервер могут отправлять друг другу потоки сообщений.

    ```protobuf
    rpc BidiHello(stream HelloRequest) returns (stream HelloResponse);
    ```

## Примеры кода

### Сервер gRPC (Java)

```java
package oleborn.grpcserver.service;

import io.grpc.stub.StreamObserver;
import oleborn.grpcserver.GreetingRequest;
import oleborn.grpcserver.GreetingResponse;
import oleborn.grpcserver.GreetingServiceGrpc;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greet(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        String name = request.getName();
        String greeting = "Hello, " + name;

        GreetingResponse response = GreetingResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
```

### Клиент gRPC (Java)

```java
package oleborn.grpcclient;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import oleborn.grpcserver.GreetingRequest;
import oleborn.grpcserver.GreetingResponse;
import oleborn.grpcserver.GreetingServiceGrpc;

public class GreetingClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub =
                GreetingServiceGrpc.newBlockingStub(channel);

        GreetingResponse response = stub.greet(GreetingRequest.newBuilder()
                .setName("World")
                .build());

        System.out.println(response.getGreeting());

        channel.shutdown();
    }
}
```
