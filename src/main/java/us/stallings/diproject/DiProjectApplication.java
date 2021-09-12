package us.stallings.diproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import us.stallings.diproject.config.DiConfiguration;
import us.stallings.diproject.config.DiConstructorConfig;
import us.stallings.diproject.controllers.*;
import us.stallings.diproject.datasource.FakeDataSource;

@SpringBootApplication
public class DiProjectApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(DiProjectApplication.class, args);

        PetController petController = (PetController) ctx.getBean("petController");
        System.out.println("--- The Best Pet is ---");
        System.out.println(petController.whichPetIsTheBest());

        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayGreeting());

        MyController myController = (MyController) ctx.getBean("myController");

        System.out.println("----- Primary");
        System.out.println(myController.sayHello());

        System.out.println("----- Property");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("----- Setter");
        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("----- Constructor");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

        System.out.println("----- Fake Data Source");
        FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUsername());
        System.out.println(fakeDataSource.getPassword());
        System.out.println(fakeDataSource.getJdbcurl());

        System.out.println("----- Config Props Bean");
        DiConfiguration diConfiguration = (DiConfiguration) ctx.getBean(DiConfiguration.class);
        System.out.println(diConfiguration.getUsername());
        System.out.println(diConfiguration.getPassword());
        System.out.println(diConfiguration.getJdbcurl());

        System.out.println("----- Constructor Binding");
        DiConstructorConfig diConstructorConfig = (DiConstructorConfig) ctx.getBean(DiConstructorConfig.class);
        System.out.println(diConstructorConfig.getUsername());
        System.out.println(diConstructorConfig.getPassword());
        System.out.println(diConfiguration.getJdbcurl());
    }

}
