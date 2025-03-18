package com.test.core.reporting.assembler;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.test.core.domain.Account;
import com.test.core.domain.ReturnReversal;
import com.test.core.gateway.domain.GatewayAuditTransaction;
import com.test.core.reporting.domain.ReturnReversalReport;
import com.test.core.reporting.resource.ReportingResource;
import com.test.core.reporting.resource.ReportingReturnReversalResource;
import com.test.core.web.rest.assembler.ReturnReversalAssembler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class ReportingAssemblerReturnReversalTest extends ReportingAssemblerAbstractTest {

  @Mock
  private ReturnReversalAssembler returnReversalAssembler;

  private ReportingReturnReversalResource reportingReturnReversalResource;
  private ReturnReversalReport returnReversalReport;

  @Override
  @BeforeEach
  public void setup() {
    super.setup();
    returnReversalReport = createReturnReversalReport();
    reportingReturnReversalResource = createReportingReturnReversalResource();

    reportingResource.setReturnReversal(reportingReturnReversalResource);

    when(returnReversalAssembler.fromReturnReversal(any(), any()))
        .thenReturn(reportingReturnReversalResource);
  }

  @Test
  public void testMergeReturnCompletesSuccessfully() {
    ReportingResource reportingResource = reportingAssembler.mergeReturnReversal(returnReversalReport,
        this.reportingResource);
    assertNotNull(reportingResource.getReturnReversal());
  }

  private ReturnReversalReport createReturnReversalReport() {

    Account account = new Account();

    ReturnReversal returnReversal = new ReturnReversal();

    ReturnReversalReport returnReversalReport =
        new ReturnReversalReport(account,
            Collections.emptyList(),
            new GatewayAuditTransaction(),
            returnReversal,
            UUID.randomUUID(),
            UUID.randomUUID()
            );
    return returnReversalReport;
  }

  private ReportingReturnReversalResource createReportingReturnReversalResource() {
    ReportingReturnReversalResource returnReversalResource = new ReportingReturnReversalResource();
    returnReversalResource.setGatewayReconciliationId(UUID.randomUUID().toString());
    return returnReversalResource;
  }
}
