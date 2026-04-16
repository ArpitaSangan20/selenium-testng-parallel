import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DataProviderTest {

    @Test(dataProvider = "urlData")
    public void testGoogleData(String url) {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        System.out.println("Title: " + driver.getTitle() +
                " | Thread: " + Thread.currentThread().getId());

        driver.quit();
    }

    @Test(dataProvider = "urlData")
    public void testBingData(String url) {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        System.out.println("Title: " + driver.getTitle());
        driver.quit();
    }

    @DataProvider(name = "urlData", parallel = true)
    public Object[][] getData() {
        return new Object[][]{
                {"https://www.google.com"},
                {"https://www.bing.com"}
        };
    }
}