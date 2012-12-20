package com.db2eshop.annotations.bindings;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>UIComponent class.</p>
 *
 * @author ska
 * @version $Id: $Id
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UIComponent {

	Class<java.awt.Component> value();

}
