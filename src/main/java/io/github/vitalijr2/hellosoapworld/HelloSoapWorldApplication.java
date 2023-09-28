package io.github.vitalijr2.hellosoapworld;

import io.github.vitalijr2.hellosoapworld.client.HelloEndpoint;
import io.github.vitalijr2.hellosoapworld.client.HelloRequest;
import io.github.vitalijr2.hellosoapworld.client.HelloResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class HelloSoapWorldApplication {

  public static void main(String[] args) {
    SpringApplication.run(HelloSoapWorldApplication.class, args);
  }

}
