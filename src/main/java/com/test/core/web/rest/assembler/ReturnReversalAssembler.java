package com.test.core.web.rest.assembler;

import com.test.core.domain.Account;
import com.test.core.domain.ReturnReversal;
import com.test.core.gateway.domain.GatewayReturnReversalResponse;
import org.springframework.stereotype.Component;

@Component
public class ReturnReversalAssembler {

  public GatewayReturnReversalResponse fromReturnReversal(Account account, ReturnReversal returnReversal) {
    if (returnReversal == null) {
      return null;
    }

    GatewayReturnReversalResponse resource =
        new GatewayReturnReversalResponse(returnReversal.getGatewayReturnReversalResponse());
    resource.setResponseId(returnReversal.getId());
    resource.setReturnId(null);

    return resource;
  }

}
