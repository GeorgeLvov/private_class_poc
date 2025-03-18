package com.test.core.web.rest.controller;

import com.test.core.gateway.domain.GatewayReturnReversalResponse;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RefreshScope
@RestController
public class ReturnReversalController {

  public static final String RETURN_REVERSAL_GET = "/accounts";

  @RequestMapping(method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE, value = RETURN_REVERSAL_GET)
  @ResponseBody
  @PreAuthorize("hasAuthority('ROLE_ALTERNATE_PAYMENTS')")
  public ResponseEntity<GatewayReturnReversalResponse> getReturnReversalById(
      @PathVariable("accountId") String accountId,
      @PathVariable("returnReversalId") UUID returnReversalId) {
      GatewayReturnReversalResponse response = new GatewayReturnReversalResponse();
      return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
