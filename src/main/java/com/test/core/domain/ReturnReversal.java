package com.test.core.domain;

import com.test.core.gateway.domain.GatewayReturnReversalResponse;

import java.util.UUID;

public class ReturnReversal {

  private UUID returnId;

  private GatewayReturnReversalResponse gatewayReturnReversalResponse;
    private UUID id;

  public UUID getReturnId() {
    return returnId;
  }

  public void setReturnId(UUID returnId) {
    this.returnId = returnId;
  }

  public GatewayReturnReversalResponse getGatewayReturnReversalResponse() {
    return gatewayReturnReversalResponse;
  }

  public void setGatewayReturnReversalResponse(
      GatewayReturnReversalResponse gatewayReturnReversalResponse) {
    this.gatewayReturnReversalResponse = gatewayReturnReversalResponse;
  }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
