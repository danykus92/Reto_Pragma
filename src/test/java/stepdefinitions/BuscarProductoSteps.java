package stepdefinitions;


import enums.Llave;
import enums.Portal;
import models.Producto;
import questions.ValidarCarrito;
import tasks.AgregarProductoAlCarrito;
import tasks.BuscarProducto;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;
import java.util.Map;

import static utilities.Constantes.CLIENTE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActor;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class BuscarProductoSteps {

    @DataTableType
    public Producto prodructoEntry(Map<String, String> entry) {
        return new Producto(
                entry.get("nombreDelProducto"),
                entry.get("precio"),
                entry.get("precioTotal"),
                entry.get("desde"));

    }

    @Before
    public void prepararEscenario() {
        OnStage.setTheStage(new OnlineCast());
    }

     @Dado("el cliente ingresa al portal de compras de my store")
    public void queElClienteIngresaAlPortalDeComprasDeMyStore() {
        theActor(CLIENTE).wasAbleTo(Open.url(Portal.MY_STORE.getPortal()));
    }

    @Cuando("el cliente agrega al carrito de compras el producto buscado")
    public void elClienteAgrgeaAlCarritoDeComprasElProductoBuscado(List<Producto> productos) {
        theActorInTheSpotlight().remember(Llave.LLAVE.getValor(), productos);
        theActorInTheSpotlight().attemptsTo(BuscarProducto.conLosDatos(productos.get(0)));
        theActorInTheSpotlight().attemptsTo(AgregarProductoAlCarrito.agregarProductoAlCarrito());
    }

    @Entonces("el cliente podra visualizar los datos del producto en el carrito de compras")
    public void elClientePodraVisualizarLosDatosDelProductoEnElCarritoDeCompras() {;
        theActorInTheSpotlight().should(seeThat(ValidarCarrito.enCarrito(), equalTo(true)));

    }
}
