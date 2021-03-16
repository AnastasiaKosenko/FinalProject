package pages;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//button[@class=\'profile js-profile_desktop js_profile_user_name\']")
    private WebElement profileButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/";
    }
    @Step
    public boolean isButtonSignOutVisible() {
        return isElementDisplayed(profileButton);
    }

    public HomePage checkIsButtonSignOutVisible(){
        checkIsElementVisible(profileButton);
        return this;
    }

    public boolean isButtonSignOutNotVisible() {
        return !isButtonSignOutVisible();
    }


    public HomePage openHomePage() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.openLoginPage();
        if (!isButtonSignOutVisible()){
            loginPage.loginWithValidCred();
        }
        logger.info("Home Page was opened");
        return this;
    }

    public ProfilePage clickOnProfileButton() {
        clickOnElement(profileButton);
        return new ProfilePage(webDriver);
    }
}