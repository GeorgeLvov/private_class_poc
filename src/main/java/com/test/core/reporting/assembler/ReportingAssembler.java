package com.test.core.reporting.assembler;

import static org.springframework.hateoas.server.core.DummyInvocationUtils.methodOn;
import com.test.core.reporting.domain.ReturnReversalReport;
import com.test.core.reporting.resource.ReportingResource;
import com.test.core.util.StaticPathLinkBuilder;
import com.test.core.web.rest.assembler.AccountAssembler;
import com.test.core.web.rest.assembler.ReturnReversalAssembler;
import com.test.core.web.rest.controller.ReturnReversalController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

@Component
public class ReportingAssembler {

  private AccountAssembler accountAssembler;
  private ReturnReversalAssembler returnReversalAssembler;
  private StaticPathLinkBuilder staticPathLinkBuilder;

  @Autowired
  public ReportingAssembler(AccountAssembler accountAssembler,  ReturnReversalAssembler returnReversalAssembler,
                            StaticPathLinkBuilder staticPathLinkBuilder) {
    this.accountAssembler = accountAssembler;
    this.returnReversalAssembler = returnReversalAssembler;
    this.staticPathLinkBuilder = staticPathLinkBuilder;
  }

  public ReportingResource mergeReturnReversal(ReturnReversalReport returnReversalReport,
                                               ReportingResource reportingResource) {

    Link link = staticPathLinkBuilder.linkTo(
            methodOn(ReturnReversalController.class).getReturnReversalById(
                    returnReversalReport.getAccount().getId(),
                    returnReversalReport.getReturnReversal().getId())
    ).withSelfRel();

    return reportingResource;
  }
}
