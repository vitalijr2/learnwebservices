package io.github.vitalijr2.hellosoapworld;

import io.github.vitalijr2.hellosoapworld.client.HelloEndpoint;
import io.github.vitalijr2.hellosoapworld.client.HelloEndpointService;
import jakarta.xml.ws.BindingProvider;
import jakarta.xml.ws.handler.MessageContext;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloSoapWorldConfiguration {

  @Bean
  public HelloEndpointService helloService() {
    return new HelloEndpointService();
  }

  @Bean
  public HelloEndpoint helloEndpoint(HelloEndpointService service,
      @Value("${hello-client.user-agent}") String userAgent) {
    var helloEndpoint = service.getHelloEndpointPort();
    var headers = new HashMap<String, List<String>>();

    headers.put("User-Agent", List.of(userAgent));
    ((BindingProvider) helloEndpoint).getRequestContext()
        .put(MessageContext.HTTP_REQUEST_HEADERS, headers);

    return helloEndpoint;
  }

}
