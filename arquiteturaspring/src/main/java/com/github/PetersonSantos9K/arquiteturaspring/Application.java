package com.github.PetersonSantos9K.arquiteturaspring;

import org.hibernate.id.Configurable;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

	 static void main(String[] args) {
		 //SpringApplication.run(Application.class, args);
		 var builder = new SpringApplicationBuilder(Application.class);
		 builder.bannerMode(Banner.Mode.OFF);
		 builder.profiles("producao", "homologação");
		 // builder.lazyInitialization(true);
		 builder.run(args);
		 // contexto da aplicação
		 // ConfigurableApplicationContext context = builder.context();
		 ApplicationContext applicationContext = builder.context();
		 var motor = applicationContext.getBean("motorAspirado");

		 // builder.properties("spring.datasource.url = jdbc...");

		 Environment environment = applicationContext.getEnvironment();
		 String property = environment.getProperty("spring.application.name");

		 //applicationContext.getBean("exampleValue");
		 ExampleValue example = applicationContext.getBean(ExampleValue.class);
		 example.imprimirVariavel();

		 IO.println("Nome da aplicação: " + property);
	 }

}
