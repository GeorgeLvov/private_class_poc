package com.test.core.reporting.resource;

import com.test.core.gateway.domain.GatewayReturnReversalResponse;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.hateoas.RepresentationModel;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class ReportingResource extends RepresentationModel {

  @JsonProperty("id")
  private UUID eventId;

  @JsonProperty
  private GatewayReturnReversalResponse returnReversal;

  @JsonAlias({"additionalData", "reportingData"})
  private Map<String, Object> additionalData;

  public UUID getEventId() {
    return eventId;
  }

  public void setEventId(UUID eventId) {
    this.eventId = eventId;
  }

  public GatewayReturnReversalResponse getReturnReversal() {
    return returnReversal;
  }

  public void setReturnReversal(GatewayReturnReversalResponse returnReversal) {
    this.returnReversal = returnReversal;
  }

  public Map<String, Object> getAdditionalData() {
    if (additionalData == null) {
      this.additionalData = new LinkedHashMap<>();
    }
    return additionalData;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    ReportingResource that = (ReportingResource) obj;

    return new EqualsBuilder()
        .appendSuper(super.equals(obj))
        .append(getEventId(), that.getEventId())
        .append(getAdditionalData(), that.getAdditionalData())
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .appendSuper(super.hashCode())
        .append(getEventId())
        .append(getAdditionalData())
        .toHashCode();
  }
}
