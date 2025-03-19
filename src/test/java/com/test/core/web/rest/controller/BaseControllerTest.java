package com.test.core.web.rest.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.apache.commons.validator.routines.UrlValidator;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
public class BaseControllerTest {

  static {
    System.setProperty("org.jboss.logging.provider", "slf4j");
  }

  public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("build/generated-snippets");

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
