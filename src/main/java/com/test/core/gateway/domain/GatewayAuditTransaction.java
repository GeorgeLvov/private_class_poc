package com.test.core.gateway.domain;

import java.time.OffsetDateTime;
import java.util.UUID;

public class GatewayAuditTransaction {

  private UUID id;

  private Long executionTime;

  private String gatewayTxnId;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Long getExecutionTime() {
    return executionTime;
  }

  public void setExecutionTime(Long executionTime) {
    this.executionTime = executionTime;
  }

  public String getGatewayTxnId() {
    return gatewayTxnId;
  }

  public void setGatewayTxnId(String gatewayTxnId) {
    this.gatewayTxnId = gatewayTxnId;
  }

}
