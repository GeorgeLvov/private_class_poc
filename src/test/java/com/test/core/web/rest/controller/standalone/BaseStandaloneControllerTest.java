package com.test.core.web.rest.controller.standalone;

import com.test.core.web.rest.controller.BaseControllerTest;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@DirtiesContext
public class BaseStandaloneControllerTest extends BaseControllerTest {

  @InjectMocks
  @Spy
  public MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();

  public MockMvc mockMvc;

  @Autowired
  public WebApplicationContext webApplicationContext;

  HttpHeaders headers = new HttpHeaders();

}
