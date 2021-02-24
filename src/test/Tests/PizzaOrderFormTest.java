import com.sample.constants.PizzaToppings;
import com.sample.constants.PizzaTypes;
import com.sample.pages.PizzaOrderPage;

import org.testng.annotations.Test;
import com.sample.pages.TestBase;
import static org.testng.AssertJUnit.*;


public class PizzaOrderFormTest extends TestBase {
    PizzaOrderPage pizzaOrderPage = new PizzaOrderPage();


    @Test
    public void EnterInfoProducesNoError() throws InterruptedException {
        pizzaOrderPage.waitForPageToBeInteractable();
        pizzaOrderPage.selectPizzaTypesAndToppings(PizzaTypes.MEDIUM_TWOTOPPINGS.getDisplayName(),PizzaToppings.MANGOS.getDisplayName(),PizzaToppings.MOZZARELLA.getDisplayName(),"2");
        pizzaOrderPage.enterPersonalInfoAndSubmit("neena","wev@d.com","551-908-9089","Credit");
    }




    @Test
    public void MissingNameProducesError() throws InterruptedException {
        pizzaOrderPage.waitForPageToBeInteractable();
        pizzaOrderPage.selectPizzaTypesAndToppings(PizzaTypes.MEDIUM_TWOTOPPINGS.getDisplayName(),PizzaToppings.MANGOS.getDisplayName(),PizzaToppings.MOZZARELLA.getDisplayName(),"3");
        pizzaOrderPage.enterPersonalInfoAndSubmit("","wev@d.com","551-908-9089","Credit");
        assertTrue(pizzaOrderPage.verifyRequiredErrorDisplayed());
    }

    @Test
    public void MissingEmailProducesError() throws InterruptedException {
        pizzaOrderPage.waitForPageToBeInteractable();
        pizzaOrderPage.selectPizzaTypesAndToppings(PizzaTypes.MEDIUM_TWOTOPPINGS.getDisplayName(),PizzaToppings.MANGOS.getDisplayName(),PizzaToppings.MOZZARELLA.getDisplayName(),"2");
        pizzaOrderPage.enterPersonalInfoAndSubmit("Neena","","551-908-9089","Cash");
        assertTrue(pizzaOrderPage.verifyRequiredErrorDisplayed());
    }



}
