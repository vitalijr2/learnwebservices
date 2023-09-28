package io.github.vitalijr2.hellosoapworld;

import io.github.vitalijr2.hellosoapworld.client.HelloEndpoint;
import io.github.vitalijr2.hellosoapworld.client.HelloRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloSoapWorldController {

  private static final String NAME = "name";
  private static final String DEFAULT_NAME = "world";
  public static final String SOAP_RESPONSE = "helloResponse";

  @Autowired
  private HelloEndpoint helloEndpoint;

  private static final String SHOW_RESPONSE = "show-response";

  @GetMapping({"/", "/send"})
  public String send(
      @RequestParam(name = NAME, required = false, defaultValue = DEFAULT_NAME) String name,
      Model model) {
    var helloRequest = new HelloRequest();

    helloRequest.setName(name);
    var helloResponse = helloEndpoint.sayHello(helloRequest);

    model.addAttribute(SOAP_RESPONSE, helloResponse);

    return SHOW_RESPONSE;
  }

}
