package com.avbravo.jmoordb.core.annotation ;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
*
* @author 
*/


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface Referenced {
 String collection();
 String field();
 String javatype() default "String";
 String repository();
 boolean lazy() default false;
}

