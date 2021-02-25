package pl.dmcs.buarzej.configuration;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

//klasa inicjująca bo filtry muszą być uruchamiane w odpowiedniej kolejności(zapytania przychodzące w pierwszej kolejności przechodzą przez moduł springsecurity)
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
}
