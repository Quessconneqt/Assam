package pomTest;

import java.io.IOException;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

	@Test(priority = 1)
	
	public void login() throws IOException {
		
		lp.loginToApp();
	}
}
