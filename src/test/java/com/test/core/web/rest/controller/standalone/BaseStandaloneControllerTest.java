package com.test.core.web.rest.controller.standalone;

import com.test.core.web.rest.controller.BaseControllerTest;
import com.test.core.web.rest.controller.StandaloneCreditReturnController;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@DirtiesContext
public class BaseStandaloneControllerTest extends BaseControllerTest {

  @InjectMocks
  @Spy
  public MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();

  public MockMvc mockMvc;

  @Autowired
  public WebApplicationContext webApplicationContext;

  HttpHeaders headers = new HttpHeaders();

  @InjectMocks
  StandaloneCreditReturnController standaloneCreditReturnController;

  public BaseStandaloneControllerTest() {
    super();
    mockMvc = standaloneSetup(standaloneCreditReturnController)
            .apply(documentationConfiguration(this.restDocumentation).uris().withHost(MOCK_MVC_HOST))
            .build();
  }

  @BeforeEach
  public void setUp() throws Exception {
    standaloneCreditReturnController = new StandaloneCreditReturnController();
  }

}
