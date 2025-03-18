package com.test.core.util;

import org.springframework.hateoas.Affordance;
import org.springframework.hateoas.server.LinkBuilder;
import org.springframework.hateoas.server.core.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriTemplate;

import java.lang.reflect.Method;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class StaticPathLinkBuilder extends LinkBuilderSupport<StaticPathLinkBuilder> {

  private static final AnnotationMappingDiscoverer ANNOTATION_MAPPING_DISCOVERER =
      new AnnotationMappingDiscoverer(RequestMapping.class);

  public StaticPathLinkBuilder(UriComponentsBuilder builder) {
    super(builder.build());
  }

  public LinkBuilder linkTo(Class<?> clazz, String method, Object... parameters) {
    return linkTo(lookupMethod(clazz, method, parameters), parameters);
  }

  public LinkBuilder linkTo(Method method, Object... parameters) {
    URI relativeUri = createRelativeUri(method, parameters);
    return slash(UriComponentsBuilder.fromUri(relativeUri).build(), true);
  }

  public LinkBuilder linkTo(Object dummyInvocation) {
    if (!(dummyInvocation instanceof LastInvocationAware)) {
      IllegalArgumentException cause =
              new IllegalArgumentException("linkTo(Object) must be call with a dummyInvocation");
    }

    LastInvocationAware lastInvocationAware =
            (LastInvocationAware) dummyInvocation;

    MethodInvocation methodInvocation = lastInvocationAware.getLastInvocation();

    StaticPathLinkBuilder staticPathLinkBuilder = getThis();
    return staticPathLinkBuilder.linkTo(methodInvocation.getMethod(), methodInvocation.getArguments());
  }

  @Override
  protected StaticPathLinkBuilder getThis() {
    return this;
  }

  private StaticPathLinkBuilder(UriComponents components, List<Affordance> affordances) {
    super(components, affordances);
  }

  @Override
  protected StaticPathLinkBuilder createNewInstance(UriComponents components, List<Affordance> affordances) {
    return new StaticPathLinkBuilder(components, affordances);
  }

  private URI createRelativeUri(Method method, Object... parameters) {
    String mapping = ANNOTATION_MAPPING_DISCOVERER.getMapping(method.getDeclaringClass(), method);
    UriTemplate template = new UriTemplate(mapping);
    return template.expand(parameters);
  }

  private Method lookupMethod(Class<?> clazz, String method, Object... parameters) {
    Class[] parameterTypes = Arrays.stream(parameters)
        .map(Object::getClass)
        .toArray(Class[]::new);
    try {
      return clazz.getMethod(method, parameterTypes);
    } catch (ReflectiveOperationException e) {
        try {
            throw new Exception("error");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
  }
}
