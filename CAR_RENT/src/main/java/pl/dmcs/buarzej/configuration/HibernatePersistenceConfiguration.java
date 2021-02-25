package pl.dmcs.buarzej.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
//wiadomość dla springa że to jest klasa konfiguracyjna(na tej podstawie będzie ona odpowiednio traktowana)
@EnableJpaRepositories(basePackages = {"pl.dmcs.buarzej.dao"})
//wskazanie pakietu w którym będziemy dodawać repozytoria/warstwę DAO/warstwa dostępu do baazy danych
@EnableTransactionManagement
//wszystko odbywa się na zasadzie tranzakcji - ściśle powiązane operacje, tak jak tranzakcja bankowa, dane muszą być spójne
public class HibernatePersistenceConfiguration {                            //jakiś błąd w czasie tranzakcji - cała tranzakcja wycofywana, tzw. rollback. Atomowość tranzakcji, współbieżność tranzakcji.

    // Hibernate configuration
    @Bean(name = "dataSource")      //źródło danych
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");         //zdefiniowanie z jakiej bazy danych korzystamy + z jakiego sterownika bazy danych będziemy korzystać
        dataSource.setUrl("jdbc:postgresql://localhost:5432/SpringProjectUD?characterEncoding=utf-8");
        dataSource.setUsername("postgres");
        dataSource.setPassword("pgsqlpass");
        return dataSource;
    }

    private Properties getHibernateProperties() {       //właściwości hibernate
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");       //pokaż zapytanie sqlowe, nie musimy pisać zapytań sqlowych
        properties.put("hibernate.hbm2ddl.auto", "update"); //pozwala zarządzanie strukturą bazy danych w początkowej fazie rozwoju aplikacji, będzie aktualizowana struktura bazy danych
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect"); //odmiana języka SQL-owego używana przez postgre
        properties.put("hibernate.default_schema", "public");   //rodzaj schematu == publiczny
        return properties;
    }

    // JPA
    //ustawienia tranzakcji, wyjątków i wskazanie hibernatowi który pakiet jest pakietem modelu
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(getDataSource());
        em.setPackagesToScan(new String[]{"pl.dmcs.buarzej.domain"});

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(getHibernateProperties());
        return em; //zwracane do kontekstu springa jako bean/ziarno
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager; //menedżer tranzakcji
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor(); //obsługa wyjątków na poziomie postprocesora, błędy związane z bazą danych
    }
}
