package io.github.vitalijr2.hellosoapworld;

import io.github.vitalijr2.hellosoapworld.client.HelloEndpoint;
import io.github.vitalijr2.hellosoapworld.client.HelloRequest;
import io.github.vitalijr2.hellosoapworld.client.HelloResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelloSoapWorldApplication {

  public static void main(String[] args) {
    SpringApplication.run(HelloSoapWorldApplication.class, args);
  }

  @Bean
  CommandLineRunner sayHello(HelloEndpoint helloEndpoint) {
    return args -> {
      var helloRequest = new HelloRequest();

      if (args.length > 0) {
        helloRequest.setName(args[0]);
      } else {
        helloRequest.setName("John");
      }
      HelloResponse helloResponse = helloEndpoint.sayHello(helloRequest);
      System.out.println(helloResponse.getMessage());
    };
  }

}
