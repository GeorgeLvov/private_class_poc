package com.test.core.web.rest.controller.standalone;

import com.test.core.web.rest.controller.BaseControllerTest;
import com.test.core.web.rest.controller.ReturnReversalController;
import com.test.core.web.rest.controller.StandaloneCreditReturnController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@DirtiesContext
@ExtendWith(RestDocumentationExtension.class)
public class BaseStandaloneControllerTest extends BaseControllerTest {

  @InjectMocks
  @Spy
  public MockHttpServletRequest mockHttpServletRequest = new MockHttpServletRequest();

  public MockMvc mockMvc;

  @Autowired
  public WebApplicationContext webApplicationContext;

  HttpHeaders headers = new HttpHeaders();

  /*
   *   StandaloneCreditReturnController was changed to ReturnReversalController, because it contains
   *   the /accounts/{accountId}/{returnReversalId} endpoint, which you apparently want to test, whereas
   *   StandaloneCreditReturnController doesn't contain any endpoint.
   *
   *   It was changed only for testing purposes, since StandaloneCreditReturnController is empty
   *
   * */
  @InjectMocks
  ReturnReversalController returnReversalController;


  // RestDocumentationContextProvider restDocumentation will be automatically instantiated
  @BeforeEach
  public void setUp(RestDocumentationContextProvider restDocumentation) {
    returnReversalController = new ReturnReversalController();

    mockMvc = standaloneSetup(returnReversalController)
            .apply(documentationConfiguration(restDocumentation).uris().withHost(MOCK_MVC_HOST).withPort(MOCK_MVC_PORT)
            )
            .build();
  }
}
