package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarritoDeCompra {

    private CarritoDeCompra() {

    }

    public static final Target CARRITO = Target.the("Boton para ir al carrito")
            .located(By.xpath("//span[contains(.,'Proceed to checkout')]"));

    public static final Target PRECIO_UNITARIO_DESCUENTO = Target.the("Precio unitario del producto con descuento")
            .located(By.cssSelector(".special-price"));

    public static final Target PRECIO_UNITARIO = Target.the("Precio unitario del producto sin descuento")
            .located(By.xpath("//td[@class='cart_unit']/span[@class='price']"));

    public static final Target PRECIO_TOTAL = Target.the("Precio con descuento del producto")
            .located(By.id("total_price"));


}
