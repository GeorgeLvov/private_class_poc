package com.test.core.web.rest.controller.standalone;

import org.junit.jupiter.api.Test;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class StandaloneControllerGetByIdTest
    extends BaseStandaloneControllerTest {

  @Test
  public void lookupStandaloneReturnsIsSuccessful() throws Exception {

    mockMvc.perform(
                    get("/accounts", "123", "04d71b9379ef4db49c28e113485ea76d")
                            .contentType(APPLICATION_JSON_VALUE))
            .andDo(print()).andExpect(status().isOk());
  }
}
