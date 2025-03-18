package com.test.core.gateway.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GatewayReturnReversalResponse {
  private UUID id;
  private String gatewayReconciliationId;
  private Boolean liveMode = Boolean.TRUE;
  private Map<String, Object> gatewayResponse;

  private UUID returnId;

  public GatewayReturnReversalResponse() {
  }

  public GatewayReturnReversalResponse(GatewayReturnReversalResponse response) {
    if (response != null) {
      this.gatewayReconciliationId = response.getGatewayReconciliationId();
      this.liveMode = response.getLiveMode();
      this.gatewayResponse = response.gatewayResponse;
      this.returnId = response.getReturnId();
    }
  }

  public void setResponseId(UUID id) {
    this.id = id;
  }

  public String getGatewayReconciliationId() {
    return gatewayReconciliationId;
  }

  public void setGatewayReconciliationId(String gatewayReconciliationId) {
    this.gatewayReconciliationId = gatewayReconciliationId;
  }

  public Boolean getLiveMode() {
    return liveMode == null || liveMode.booleanValue() ? null : liveMode;
  }

  public void setLiveMode(Boolean liveMode) {
    this.liveMode = liveMode;
  }

  public UUID getReturnId() {
    return returnId;
  }

  public void setReturnId(UUID returnId) {
    this.returnId = returnId;
  }

}
