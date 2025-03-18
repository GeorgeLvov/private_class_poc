package com.test.core.reporting.domain;

import com.test.core.domain.Account;
import com.test.core.domain.AccountGroup;
import com.test.core.gateway.domain.GatewayAuditTransaction;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractReport {

  private final Account account;

  private final List<AccountGroup> accountGroups;

  private final GatewayAuditTransaction gatewayAuditTransaction;

  protected AbstractReport(Account account, List<AccountGroup> accountGroups,
                           GatewayAuditTransaction gatewayAuditTransaction) {
    this.gatewayAuditTransaction = gatewayAuditTransaction;
    this.account = account;

    if (accountGroups == null) {
      this.accountGroups = new LinkedList<>();
    } else {
      this.accountGroups = accountGroups;
    }
  }

  public Account getAccount() {
    return account;
  }
}
