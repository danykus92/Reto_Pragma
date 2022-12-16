package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ResultadoDeBusqueda {

	private ResultadoDeBusqueda() {

	}


	public static final Target TEXT_PRODUCTO(String valorOpcion) {
		return Target.the("Opcion para selccionar genero")
				.located(By.xpath("//h5[@itemprop='name']//child::a[@title='"+valorOpcion+"']"));
	}

	public static final Target BTN_AGREGAR_AL_CARRITO = Target.the("Boton agregar al carrito")
			.located(By.xpath("//span[.='Add to cart']"));

	public static final Target BTN_STOCK = Target.the("Boton stock")
			.located(By.cssSelector(".available-now"));

}
