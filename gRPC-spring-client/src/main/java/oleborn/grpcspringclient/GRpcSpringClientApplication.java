package oleborn.grpcspringclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GRpcSpringClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(GRpcSpringClientApplication.class, args);
    }

}
