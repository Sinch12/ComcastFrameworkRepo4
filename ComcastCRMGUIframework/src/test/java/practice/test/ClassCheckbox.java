package practice.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class ClassCheckbox {

	public static void main(String[] args) {
WebDriver driver = new ChromeDriver();

LoginPage l = new LoginPage(driver);
l.logintoapp("http://localhost:8888/", "admin", "admin");
HomePage h = new HomePage(driver);
h.getOrgpage().click();

	}

}
