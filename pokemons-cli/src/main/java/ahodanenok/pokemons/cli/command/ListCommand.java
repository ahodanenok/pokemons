package ahodanenok.pokemons.cli.command;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class ListCommand implements CliCommand, Ordered {

    private int order;

    @Override
    public void execute() {
        System.out.println("Pokemons list");
    }

    @Value("${command.list.order}")
    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return order;
    }

    @Override
    public String getMenuTitle() {
        return "List";
    }
}
