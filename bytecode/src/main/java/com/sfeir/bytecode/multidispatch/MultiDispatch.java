package com.sfeir.bytecode.multidispatch;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO : explain.me
 * Date: 20/09/12
 * Time: 20:13
 *
 * @author françois LAROCHE
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface MultiDispatch {
}
