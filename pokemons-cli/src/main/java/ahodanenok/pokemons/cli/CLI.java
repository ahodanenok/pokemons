package ahodanenok.pokemons.cli;

import ahodanenok.pokemons.cli.command.MainCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
@ImportResource({"ahodanenok/pokemons/importer/context.xml"})
public class CLI {

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
//        context.setConfigLocation("ahodanenok/pokemons/cli/context.xml");
//        context.setParent(new ClassPathXmlApplicationContext("ahodanenok/pokemons/core/context.xml", "ahodanenok/pokemons/importer/context.xml"));
//        context.refresh();
//
//        MainCommand main = context.getBean("cliMain", MainCommand.class);
//        main.execute();

        ApplicationContext context = SpringApplication.run(CLI.class, args);
        context.getBean("cliMain", MainCommand.class).execute();
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer1() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setIgnoreUnresolvablePlaceholders(true);
        configurer.setLocation(new ClassPathResource("ahodanenok/pokemons/cli/commands.properties"));
        return configurer;
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer2() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setIgnoreUnresolvablePlaceholders(true);
        return configurer;
    }
}
