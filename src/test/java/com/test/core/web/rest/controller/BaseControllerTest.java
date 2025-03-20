package com.test.core.web.rest.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.apache.commons.validator.routines.UrlValidator;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
public class BaseControllerTest {

  // Remove http part and port from here to have it properly documented.
  // Otherwise you will  have smth like: http://http://localhost:8011:8080/account...
  protected static final String MOCK_MVC_HOST = "localhost";

  // use port as separate variable
  protected static final int MOCK_MVC_PORT = 8011;

  static {
    System.setProperty("org.jboss.logging.provider", "slf4j");
  }

  // JUnitRestDocumentation removed

  @Mock
  protected UrlValidator urlValidator;

  public BaseControllerTest() {
    MockitoAnnotations.openMocks(this);
  }

  @BeforeEach
  public void setupUrlValidatorMock() {
    when(urlValidator.isValid(any())).thenReturn(true);
  }

}
