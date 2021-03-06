package main;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class HomeScreen {
    private AppiumDriver<MobileElement> driver ;
    public HomeScreen(AppiumDriver<MobileElement>AppiumDriver) {
        this.driver= this.driver;
    }

    @AndroidFindBy(id = "imgMyShaadi")
    private MobileElement myShaadiLogo;

    @AndroidFindBy(id = "textView_upgrade_title")
    private MobileElement lockdownTitle;

    @AndroidFindBy(id = "menu_skip")
    private MobileElement skipLockdown;

    @AndroidFindBy(id = "tvDashboard")
    private MobileElement myShaadiTabTitle;

    @AndroidFindBy(id = "tv_title")
    private List<MobileElement> matchesPremiumNew;

    @AndroidFindBy(id = "profile_card")
    private List<MobileElement> profiles;

    @AndroidFindBy(id = "llConnect")
    private List<MobileElement> connectNow;


    public void skipLockdownPage() {
        if (lockdownTitle.isDisplayed())
            skipLockdown.click();
    }

    public void selectMyShaadiTab() {
        if (myShaadiLogo.isDisplayed())
            myShaadiLogo.click();
    }

    public boolean verifyMyShaadiTabTitle() {
        return myShaadiTabTitle.isDisplayed() && myShaadiTabTitle.getText().equals("My Shaadi");
    }

    public boolean verifyPremiumMatch() {
        return verifyMatchTitle(0, "Premium Matches");
    }

    public boolean verifyNewMatch() {
        return verifyMatchTitle(1, "New Matches");
    }

    public boolean verifyMatchTitle(int i, String matchName) {
        return matchesPremiumNew.get(i).isDisplayed() && matchesPremiumNew.get(i).getText().contains(matchName);
    }

    public void selectMatch(int j){
        if (profiles.get(j).isDisplayed() && connectNow.get(j).isDisplayed())
            connectNow.get(j).click();
        else
            connectNow.get(j+1).click();
    }

    public void selectPremiumMatch(){
        selectMatch(0);
    }

    public void selectNewMatch(){
        selectMatch(2);
    }

}
