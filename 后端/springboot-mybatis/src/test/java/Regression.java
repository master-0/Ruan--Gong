import RegressionTest.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.spring.springboot.Application;
import org.spring.springboot.HttpClient;
import org.spring.springboot.service.ServiceImp.EmailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application.class)
@RunWith(Suite.class)
@Suite.SuiteClasses({
        SendEmail.class,
        UserControllerJunitTest.class,
        DeviceControllerJunitTest.class,
        LogControllerJunitTest.class,
        AttentionControllerJunitTest.class,
        EmailControllerJunitTest.class
})

public class Regression {

    @BeforeClass
    public static void before() throws Exception {
        HttpClient.record("------------------RegressionTest Start!!!------------------:");
        org.spring.springboot.RegressionTest.RegressionTestBegin();
    }

    @AfterClass
    public static void after() throws Exception {
        org.spring.springboot.RegressionTest.RegressionTestEnd();
        HttpClient.record("------------------RegressionTest End!!!------------------:");
    }
}
