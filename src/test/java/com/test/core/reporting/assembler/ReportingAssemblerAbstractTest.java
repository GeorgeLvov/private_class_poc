package com.test.core.reporting.assembler;

import com.test.core.domain.Account;
import com.test.core.domain.AccountGroup;
import com.test.core.gateway.domain.GatewayAuditTransaction;
import com.test.core.reporting.resource.ReportingResource;
import com.test.core.util.StaticPathLinkBuilder;
import com.test.core.web.rest.assembler.AccountAssembler;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class ReportingAssemblerAbstractTest {
  protected Account account;
  protected List<AccountGroup> accountGroups;
  protected GatewayAuditTransaction gatewayAuditTransaction;

  @Mock
  protected AccountAssembler accountAssembler;

  @Spy
  protected StaticPathLinkBuilder staticPathLinkBuilder =
      new StaticPathLinkBuilder(UriComponentsBuilder.fromHttpUrl("http://localhost"));
  protected ReportingResource reportingResource;

  @InjectMocks
  ReportingAssembler reportingAssembler;

  protected ReportingAssemblerAbstractTest() {
  }

  protected void createAccount() {
    account = new Account();
    account.setId("1234567890");
  }

  protected void createAccountGroups() {
    accountGroups = new ArrayList<>();
    AccountGroup accountGroup = new AccountGroup();
    accountGroup.setId(UUID.randomUUID());
    accountGroups.add(accountGroup);
  }

  protected void createGatewayAuditTransaction() {
    gatewayAuditTransaction = new GatewayAuditTransaction();
  }

  @BeforeEach
  public void setup() {
    reportingResource = new ReportingResource();
    createAccount();
    createAccountGroups();
    createGatewayAuditTransaction();
  }
}
