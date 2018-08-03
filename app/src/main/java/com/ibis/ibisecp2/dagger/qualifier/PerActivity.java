/**
 * Copyright (C) 2015 android10.org. All rights reserved.
 *
 * @author Fernando Cejas (the android10 coder)
 */
package com.ibis.ibisecp2.dagger.qualifier;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by danila on 08.11.15.
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}
