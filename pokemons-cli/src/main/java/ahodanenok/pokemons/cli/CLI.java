package ahodanenok.pokemons.cli;

import ahodanenok.pokemons.cli.command.MainCommand;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CLI {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation("ahodanenok/pokemons/cli/context.xml");
        context.setParent(new ClassPathXmlApplicationContext("ahodanenok/pokemons/core/context.xml", "ahodanenok/pokemons/importer/context.xml"));
        context.refresh();

        MainCommand main = context.getBean("cliMain", MainCommand.class);
        main.execute();
    }
}
