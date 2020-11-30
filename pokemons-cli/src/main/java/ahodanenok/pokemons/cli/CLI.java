package ahodanenok.pokemons.cli;

import ahodanenok.pokemons.cli.command.MainCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

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
}
