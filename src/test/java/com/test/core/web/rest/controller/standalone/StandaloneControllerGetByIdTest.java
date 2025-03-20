package com.test.core.web.rest.controller.standalone;

import org.junit.jupiter.api.Test;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;

public class StandaloneControllerGetByIdTest
        extends BaseStandaloneControllerTest {

  @Test
  public void lookupStandaloneReturnsIsSuccessful() throws Exception {

    /*
     * 1. Url was updated to include path variables
     * 2. Added package name, where the report will be added -> .andDo(document("home"))
     *
     *
     *
     * !!!!! The full report you can find now in build/generated-snippets/home !!!!!
     *
     * */
    mockMvc.perform(
                    get("/accounts/{accountId}/{returnReversalId}", "123", "04d71b93-79ef-4db4-9c28-e113485ea76d")
                            .contentType(APPLICATION_JSON_VALUE))
            .andDo(print())
            .andDo(document("home"))
            .andExpect(status().isOk());
  }
}
