package tasks;

import interactions.DarClic;
import models.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.actions.Scroll;
import userinterfaces.ResultadoDeBusqueda;

import java.util.List;

import static enums.Llave.DESDE_BUSQUEDA;
import static enums.Llave.DESDE_DETALLE_PRODUCTO;
import static enums.Llave.LLAVE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterfaces.ResultadoDeBusqueda.BTN_AGREGAR_AL_CARRITO;
import static userinterfaces.ResultadoDeBusqueda.BTN_STOCK;


public class AgregarProductoAlCarrito implements Task {

    private final List<Producto> producto = theActorInTheSpotlight().recall(LLAVE.getValor());

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (producto.get(0).getDesde().equals(DESDE_DETALLE_PRODUCTO.getValor())){
            actor.attemptsTo(
                    DarClic.enElemento(ResultadoDeBusqueda.TEXT_PRODUCTO(producto.get(0).getNombreDelProducto())),
                    Scroll.to(BTN_AGREGAR_AL_CARRITO),
                    DarClic.enElemento(BTN_AGREGAR_AL_CARRITO));
        }
        if (producto.get(0).getDesde().equals(DESDE_BUSQUEDA.getValor())){
            actor.attemptsTo(Scroll.to(BTN_STOCK),
                    MoveMouse.to(BTN_STOCK),
                    Scroll.to(BTN_AGREGAR_AL_CARRITO),
                    DarClic.enElemento(BTN_AGREGAR_AL_CARRITO));
        }
    }

    public static AgregarProductoAlCarrito agregarProductoAlCarrito() {
        return instrumented(AgregarProductoAlCarrito.class);
    }

}