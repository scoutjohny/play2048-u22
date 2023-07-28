package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.MainPage;

public class GamePlay extends BaseTest{
    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser) throws Exception {
        init(browser);
    }

    @AfterMethod
    @Parameters({"quit"})
    public void tearDown(String quit){
        if(quit.equalsIgnoreCase("Yes")){
            quit();
        }
    }

    @Test(enabled = false)
    @Parameters({"env"})
    public void startNewGame(String env) throws Exception {
        openApp(env);
        MainPage mainPage = new MainPage(driver);
        mainPage.startNewGame();
        mainPage.checkNewTileCount("2");
        mainPage.startNewGame();
        mainPage.checkNewTileCount("2");
    }

    @Test(enabled = false)
    @Parameters({"env"})
    public void checkScore(String env) throws Exception {
        openApp(env);
        MainPage mainPage = new MainPage(driver);
        mainPage.play(10);
        mainPage.checkScore();
    }

    @Test(enabled = false)
    @Parameters({"env"})
    public void fullGame(String env) throws Exception {
        openApp(env);
        MainPage mainPage = new MainPage(driver);
        mainPage.playUntilGameOver();
        mainPage.checkScore();
    }

    @Test
    @Parameters({"env"})
    public void fullGameWin(String env) throws Exception {
        openApp(env);
        MainPage mainPage = new MainPage(driver);
        mainPage.playUntilGameOver("64");
    }
}
