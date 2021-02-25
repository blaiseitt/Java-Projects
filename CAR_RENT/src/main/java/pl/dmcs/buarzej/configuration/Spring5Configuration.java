package pl.dmcs.buarzej.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import pl.dmcs.buarzej.service.AppUserRoleService;
import pl.dmcs.buarzej.service.OrderService;
import pl.dmcs.buarzej.utils.AppUserRoleConverter;
import pl.dmcs.buarzej.utils.AppUserRoleListConverter;
import pl.dmcs.buarzej.utils.OrderConverter;

import javax.annotation.Resource;
import java.util.Locale;

@Configuration
@EnableWebMvc
@EnableScheduling
@ComponentScan("pl.dmcs.buarzej")
@Import({SecurityConfiguration.class})
public class Spring5Configuration implements WebMvcConfigurer {

    //konfiguracja tilesów przy pomocy konfiguratora
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[]{"tilesConfiguration/tiles.xml"});
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    // Configure ViewResolvers to deliver preferred views.
    //niezależna konfiguracja rozwiązania widoków w oparciu o bibliotekę tilesów
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }

    // Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    // Configure message source directory
    //ścieżka do tłumaczeń z któych korzystamy ---> do plików properties
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("/resources/i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    // Configure LocaleResolver with default locale as 'en'
    //ustalanie w jakim języku ma się domyślnie wyświetlać strona
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(new Locale("en"));
        resolver.setCookieName("myLocaleCookie");
        resolver.setCookieMaxAge(4800); //informacja o tym że domyślnym językiem jest angielski jest trzymana w ciasteczkach
        return resolver;
    }

    // Configure interceptor to switch language when 'lang' parameter found in request
    //interceptor - przechwytywanie zapytan w locie, korzystamy z kontrolera springa który obsługuj e linki
    @Override       //zmieniające język(mechanizm interceptoraprzchwytujacy zapytania w locie
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
    }

    // Configure validator bean to read error codes from properties files
    //informacja żeby korzystać z metody messageSource
    @Bean
    @Override
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Resource(name = "appUserRoleService")
    private AppUserRoleService appUserRoleService;

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {
        formatterRegistry.addConverter(getMyUserRoleConverter());
        formatterRegistry.addConverter(getMyUserRoleListConverter());
    }

    @Bean
    public AppUserRoleConverter getMyUserRoleConverter() {
        return new AppUserRoleConverter(appUserRoleService);
    }

    @Bean
    public AppUserRoleListConverter getMyUserRoleListConverter() {
        return new AppUserRoleListConverter(appUserRoleService);
    }


    @Resource(name = "orderService")
    private OrderService orderService;

    @Bean
    public OrderConverter getMyOrderConverter() {
        return new OrderConverter(orderService);
    }

}