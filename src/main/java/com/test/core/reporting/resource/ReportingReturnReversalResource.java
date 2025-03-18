package com.test.core.reporting.resource;

import com.test.core.gateway.domain.GatewayReturnReversalResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReportingReturnReversalResource extends GatewayReturnReversalResponse {

  private UUID parentPaymentId;

  private UUID merchantRequestAppliedTo;

  public ReportingReturnReversalResource() {
    //intentionally leave it empty.
  }

  public ReportingReturnReversalResource(GatewayReturnReversalResponse
      gatewayReturnReversalResponse) {
    super(gatewayReturnReversalResponse);
  }

  public UUID getParentPaymentId() {
    return parentPaymentId;
  }

  public void setParentPaymentId(UUID parentPaymentId) {
    this.parentPaymentId = parentPaymentId;
  }

  public UUID getMerchantRequestAppliedTo() {
    return merchantRequestAppliedTo;
  }

  public void setMerchantRequestAppliedTo(UUID merchantRequestAppliedTo) {
    this.merchantRequestAppliedTo = merchantRequestAppliedTo;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    ReportingReturnReversalResource that = (ReportingReturnReversalResource) obj;

    return new EqualsBuilder()
        .appendSuper(super.equals(obj))
        .append(parentPaymentId, that.parentPaymentId)
        .append(merchantRequestAppliedTo, that.merchantRequestAppliedTo)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .appendSuper(super.hashCode())
        .append(parentPaymentId)
        .append(merchantRequestAppliedTo)
        .toHashCode();
  }
}
