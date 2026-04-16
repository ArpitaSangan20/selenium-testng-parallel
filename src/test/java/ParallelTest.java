import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ParallelTest {

    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setup() {
        driver.set(new ChromeDriver());
    }

    @Test
    public void testApple() {
        driver.get().get("https://www.google.com");
        System.out.println("Thread ID: " + Thread.currentThread().getId());
    }

    @Test(priority = -1)
    public void testOrange() {
        driver.get().get("https://www.bing.com");
        System.out.println("Thread ID: " + Thread.currentThread().getId());
    }

    @AfterMethod
    public void tearDown() {
        driver.get().quit();
    }
}