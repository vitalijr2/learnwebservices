package io.github.vitalijr2.hellosoapworld;

import io.github.vitalijr2.hellosoapworld.client.HelloEndpoint;
import io.github.vitalijr2.hellosoapworld.client.HelloEndpointService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloSoapWorldConfiguration {

  @Bean
  public HelloEndpointService helloService() {
    return new HelloEndpointService();
  }

  @Bean
  public HelloEndpoint helloEndpoint(HelloEndpointService service) {
    return service.getHelloEndpointPort();
  }

}
