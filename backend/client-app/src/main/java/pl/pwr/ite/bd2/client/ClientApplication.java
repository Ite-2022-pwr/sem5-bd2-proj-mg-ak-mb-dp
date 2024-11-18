package pl.pwr.ite.bd2.client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.wrss.wita.common.model.querydsl.CustomJpaRepositoryFactoryBean;

@SpringBootApplication(scanBasePackages = "pl.pwr.ite.bd2")
@EntityScan(basePackages = "pl.pwr.ite.bd2")
@ComponentScan(basePackages = "pl.pwr.ite.bd2")
@EnableJpaRepositories(basePackages = "pl.pwr.ite.bd2", repositoryFactoryBeanClass = CustomJpaRepositoryFactoryBean.class)
public class ClientApplication {

    private static final String APP_ID = "client-app";

    private static class AppIdInitializer implements ApplicationContextInitializer {

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            applicationContext.setId(APP_ID);
        }
    }

    public static void main(String... args) {
        new SpringApplicationBuilder(ClientApplication.class)
                .initializers(new AppIdInitializer())
                .run(args);
    }
}