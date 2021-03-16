package loginTests;

import baseTest.BaseTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class LoginTestWithPageObject extends BaseTest {
    @Test
    public void validLogin() {
        loginPage.openLoginPage();
//кнопка Войти
        loginPage.enterLoginSignIn("people.1198@gmail.com");
        loginPage.enterPassWordSignIn("finalproject");
        loginPage.clickButtonSignIn();
        checkExpectedResult("Button SignOut is not visible", homePage.isButtonSignOutVisible());
    }

    @Test
    @Parameters({
            "WrongLogin,123456qwerty",
            ",123456qwerty"
    })
    @TestCaseName("inValidLogin: login = {0}, passWord = {1}")
    public void inValidLogin(String login, String pass) {
        loginPage.fillLoginFormAndSubmit(login, pass);

        checkExpectedResult("Button SignOut is visible, but should `t"
                , !homePage.isButtonSignOutVisible());
    }
}
