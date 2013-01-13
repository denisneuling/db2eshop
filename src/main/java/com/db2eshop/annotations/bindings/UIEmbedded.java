package com.db2eshop.annotations.bindings;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>UIEmbedded class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UIEmbedded {

}
