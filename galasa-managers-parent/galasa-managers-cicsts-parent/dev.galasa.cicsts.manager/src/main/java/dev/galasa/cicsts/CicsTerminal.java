/*
 * Licensed Materials - Property of IBM
 * 
 * (c) Copyright IBM Corp. 2020.
 */
package dev.galasa.cicsts;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import dev.galasa.framework.spi.ValidAnnotatedFields;

/**
 * A zOS 3270 Terminal for use with a CICS TS Region that has access to the default CICS screens
 * 
 * <p>
 * Used to populate a {@link ICicsTerminal} field
 * </p>
 * 
 * @author Michael Baylis
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@CicstsManagerField
@ValidAnnotatedFields({ ICicsTerminal.class })
public @interface CicsTerminal {

    /**
     * The tag of the CICS region terminal is to be associated with
     */
    String cicsTag() default "PRIMARY";
    
}