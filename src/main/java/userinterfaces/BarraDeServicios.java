package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BarraDeServicios {

    private BarraDeServicios() {
    }


    public static final Target TEXT_BUSCAR = Target.the("Campo donde escribo el producto a buscar")
            .located(By.id("search_query_top"));

}
