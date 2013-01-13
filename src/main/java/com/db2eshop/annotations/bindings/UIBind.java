package com.db2eshop.annotations.bindings;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.db2eshop.gui.component.io.LabeledInput;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UIBind {

	Class<? extends LabeledInput<?>> value();
}
