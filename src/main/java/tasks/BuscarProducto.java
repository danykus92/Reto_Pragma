package tasks;

import models.Producto;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;


import static userinterfaces.BarraDeServicios.TEXT_BUSCAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarProducto implements Task {

    private Producto producto;

    public BuscarProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(producto.getNombreDelProducto()).into(TEXT_BUSCAR).thenHit(Keys.ENTER));
    }

    public static BuscarProducto conLosDatos(Producto producto) {
        return instrumented(BuscarProducto.class, producto);
    }

}