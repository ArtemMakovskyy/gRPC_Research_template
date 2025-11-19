# gRPC_Research
https://www.youtube.com/watch?v=OZqkdnjNNNo

## Обзор

Этот репозиторий представляет собой исследовательский проект, посвященный изучению и демонстрации работы gRPC (Google Remote Procedure Call). Проект включает в себя примеры реализации gRPC-сервера, REST-сервера для сравнения, а также различные gRPC-клиенты (на основе Java и Spring Boot) для взаимодействия с gRPC-сервером. Цель проекта — предоставить практические примеры и базовые знания для ознакомления с gRPC.

## Особенности

*   **gRPC-сервер**: Реализация gRPC-сервера на Java с использованием Spring Boot, демонстрирующая обработку удаленных вызовов процедур.
*   **REST-сервер**: Простой REST-сервер для сравнения с gRPC по производительности и удобству использования.
*   **gRPC-клиенты**: Примеры клиентов на Java для взаимодействия с gRPC-сервером:
    *   **gRPC-devh-client**: Базовый gRPC-клиент на чистом Java.
    *   **gRPC-spring-client**: gRPC-клиент, интегрированный со Spring Boot.
*   **Protocol Buffers**: Использование Protocol Buffers для определения сервисов и сообщений.
*   **Сравнение gRPC и REST**: Возможность сравнения двух подходов к построению API.

## Технологии

*   **Java 21**
*   **Spring Boot 3.5.6**
*   **gRPC 1.74.0**
*   **Protocol Buffers 4.31.1**
*   **Maven**

## Начало работы

### Предварительные требования

Для запуска этого проекта вам потребуется:

*   Java Development Kit (JDK) 21
*   Apache Maven

### Сборка проекта

Перейдите в корневой каталог каждого подпроекта (`gRPC-server`, `RestServer`, `gRPC-devh-client`, `gRPC-spring-client`) и выполните сборку с помощью Maven:

```bash
cd gRPC_Research/gRPC-server
mvn clean install

cd ../RestServer
mvn clean install

cd ../gRPC-devh-client
mvn clean install

cd ../gRPC-spring-client
mvn clean install
```

### Запуск компонентов

#### 1. Запуск gRPC-сервера

Перейдите в директорию `gRPC-server` и запустите приложение Spring Boot:

```bash
cd gRPC_Research/gRPC-server
mvn spring-boot:run
```

Сервер будет запущен на порту по умолчанию (обычно 6565 для gRPC).

#### 2. Запуск REST-сервера (для сравнения)

Перейдите в директорию `RestServer` и запустите приложение Spring Boot:

```bash
cd gRPC_Research/RestServer
mvn spring-boot:run
```

REST-сервер будет запущен на порту по умолчанию (обычно 8080).

#### 3. Запуск gRPC-клиентов

После запуска gRPC-сервера вы можете запустить один из клиентов для взаимодействия с ним.

##### gRPC-devh-client (чистый Java-клиент)

Перейдите в директорию `gRPC-devh-client` и запустите приложение:

```bash
cd gRPC_Research/gRPC-devh-client
mvn spring-boot:run
```

##### gRPC-spring-client (Spring Boot клиент)

Перейдите в директорию `gRPC-spring-client` и запустите приложение:

```bash
cd gRPC_Research/gRPC-spring-client
mvn spring-boot:run
```

Каждый клиент выполнит вызовы к gRPC-серверу и выведет результаты в консоль.

## Структура проекта

```
gRPC_Research/
├── gRPC-server/             # gRPC-сервер на Spring Boot
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/oleborn/grpcserver/ # Исходный код сервера
│   │   │   └── proto/car.proto          # Определение Protocol Buffers
│   │   └── resources/
│   ├── pom.xml
│   └── ...
├── RestServer/              # REST-сервер на Spring Boot (для сравнения)
│   ├── src/
│   │   ├── main/
│   │   │   └── java/oleborn/restserver/ # Исходный код REST-сервера
│   │   └── resources/
│   ├── pom.xml
│   └── ...
├── gRPC-devh-client/        # gRPC-клиент на чистом Java
│   ├── src/
│   │   ├── main/
│   │   │   └── java/oleborn/grpcclient/ # Исходный код клиента
│   │   └── resources/
│   ├── pom.xml
│   └── ...
├── gRPC-spring-client/      # gRPC-клиент на Spring Boot
│   ├── src/
│   │   ├── main/
│   │   │   └── java/oleborn/grpcspringclient/ # Исходный код клиента
│   │   └── resources/
│   ├── pom.xml
│   └── ...
├── README.md                # Этот файл
└── INTRO.md                 # Файл содержащий ознакомительную ифнормацию про gRPC
```

## Использование

После запуска сервера и клиентов вы увидите в консоли клиентов результаты взаимодействия с gRPC-сервером. Вы можете изменять код в сервисах и клиентах для экспериментов с различными типами gRPC-вызовов (унарные, серверные стримы, клиентские стримы, двунаправленные стримы).

## Контакты

Если у вас есть вопросы, свяжитесь с автором: @Oleborn.


