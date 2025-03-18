package com.test.core.reporting.domain;

import com.test.core.domain.Account;
import com.test.core.domain.AccountGroup;
import com.test.core.domain.ReturnReversal;
import com.test.core.gateway.domain.GatewayAuditTransaction;

import java.util.List;
import java.util.UUID;

public class ReturnReversalReport extends AbstractReport {

  private final ReturnReversal returnReversal;

  private final UUID parentPaymentId;

  private final UUID merchantRequestAppliedTo;

  public ReturnReversalReport(Account account, List<AccountGroup> accountGroups,
                              GatewayAuditTransaction gatewayAuditTransaction,
                              ReturnReversal returnReversal, UUID parentPaymentId, UUID merchantRequestAppliedTo) {
    super(account, accountGroups, gatewayAuditTransaction);
    this.returnReversal = returnReversal;
    this.parentPaymentId = parentPaymentId;
    this.merchantRequestAppliedTo = merchantRequestAppliedTo;
  }

  public ReturnReversal getReturnReversal() {
    return returnReversal;
  }

  public UUID getParentPaymentId() {
    return parentPaymentId;
  }

  public UUID getMerchantRequestAppliedTo() {
    return merchantRequestAppliedTo;
  }
}
