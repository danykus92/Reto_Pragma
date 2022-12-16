package questions;

import enums.Llave;
import exceptions.ExcepcionGeneral;
import interactions.DarClic;
import models.Producto;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.List;

import static enums.Llave.DESDE_BUSQUEDA;
import static enums.Llave.DESDE_DETALLE_PRODUCTO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterfaces.CarritoDeCompra.CARRITO;
import static userinterfaces.CarritoDeCompra.PRECIO_TOTAL;
import static userinterfaces.CarritoDeCompra.PRECIO_UNITARIO;
import static userinterfaces.CarritoDeCompra.PRECIO_UNITARIO_DESCUENTO;

public class ValidarCarrito implements Question<Boolean> {


    private List<Producto> producto = theActorInTheSpotlight().recall(Llave.LLAVE.getValor());


    @Override
    public Boolean answeredBy(Actor actor) {
        Boolean resultado = false;
        actor.attemptsTo(DarClic.enElemento(CARRITO));
        if (producto.get(0).getDesde().equals(DESDE_DETALLE_PRODUCTO.getValor())){
        actor.attemptsTo(Scroll.to(PRECIO_UNITARIO_DESCUENTO));

            PRECIO_UNITARIO_DESCUENTO.resolveFor(actor).getText()
                    .equals(producto.get(0).getPrecio());
            PRECIO_TOTAL.resolveFor(actor).getText()
                    .equals(producto.get(0).getPrecioTotal());
            resultado = true;

        }
        if (producto.get(0).getDesde().equals(DESDE_BUSQUEDA.getValor())){
            actor.attemptsTo(Scroll.to(PRECIO_UNITARIO));

            PRECIO_UNITARIO.resolveFor(actor).getText()
                    .equals(producto.get(0).getPrecio());
            PRECIO_TOTAL.resolveFor(actor).getText()
                    .equals(producto.get(0).getPrecioTotal());
            resultado= true;
        }
        return  resultado;
    }

    public static ValidarCarrito enCarrito() {
        return new ValidarCarrito();
    }
}