package oleborn.grpcdevhclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GRpcDevhClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(GRpcDevhClientApplication.class, args);
    }

}
