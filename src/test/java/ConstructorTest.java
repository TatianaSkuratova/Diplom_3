import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.diplom3.pageobject.ConstructorPage;
import ru.praktikum.diplom3.pageobject.MainPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ConstructorTest extends BaseTest {

    private final String ingredient;
    private MainPage mainPage;

    public ConstructorTest(String ingredient) {
        this.ingredient = ingredient;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {ConstructorPage.BUNS},
                {ConstructorPage.SOUCES},
                {ConstructorPage.FILLINGS}
        };
    }

    @Before
    public void init() {
        mainPage = new MainPage(webDriver);
    }

    @Test
    @DisplayName("Проверка переходов по разделам в конструкторе")
    public void clickOnlink() {
        Boolean isSelectCurrentTab = mainPage.clickButtonConstructor()
                .clickOnLabel(ingredient);
        assertTrue(isSelectCurrentTab);
    }
}
