package interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class DarClic implements Interaction {

    private Target elemento;

    public DarClic(Target elemento) {
        this.elemento = elemento;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(elemento));
    }

    public static DarClic enElemento(Target elemento) {
        return Tasks.instrumented(DarClic.class, elemento);
    }

}
