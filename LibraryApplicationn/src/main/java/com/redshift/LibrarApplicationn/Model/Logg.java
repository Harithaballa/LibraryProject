package com.redshift.LibrarApplicationn.Model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Logg {
    boolean enable() default false;
}
