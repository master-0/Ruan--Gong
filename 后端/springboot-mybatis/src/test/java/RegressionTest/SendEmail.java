package RegressionTest;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.springboot.Application;
import org.spring.springboot.service.ServiceImp.EmailClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SendEmail {
    @Autowired
    EmailClient emailClient;

    @Test
    public void mail(){
//        emailClient.sendMail("164878954@qq.com",
//                "RegressionTest Start!!!",
//                "开始时间：" + new Date().toString());
//        emailClient.sendMail("296684505@qq.com",
//                "RegressionTest Start!!!",
//                "开始时间：" + new Date().toString());
    }
}
