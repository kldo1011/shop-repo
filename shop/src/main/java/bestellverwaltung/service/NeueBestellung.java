package bestellverwaltung.service;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.context.Dependent;
import javax.inject.Qualifier;

import util.interceptor.Log;

@Qualifier
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
@Documented
@Log
@Dependent
public @interface NeueBestellung {
}
