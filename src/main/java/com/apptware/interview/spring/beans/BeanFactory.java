package com.apptware.interview.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class BeanFactory {

  @Autowired private ApplicationContext context;

  public OnDemand getOnDemandBean(SomeEnum someEnum, String someString) {

      switch (someEnum) {
        case SOME_ENUM_A:
          return context.getBean(OnDemandA.class, someString);
        case SOME_ENUM_B:
          return context.getBean(OnDemandB.class, someString);
        default:
          return context.getBean(BaseOnDemand.class, someString);
      }
  }
}
