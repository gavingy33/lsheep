package com.lsheep.common.core.annotation;

import org.springframework.stereotype.Component;

@Component
public @interface Business {

	String value() default "";

}
