package example.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"com.example.manage"})
//@ComponentScan(basePackages = {"com.example.manage.bean.Complain","com.example.manage.bean.Repair","com.example.manage.bean.User",
//        "com.example.manage.controller.Complain","com.example.manage.controller.Repair","com.example.manage.controller.User",
//        "com.example.manage.repository.Complain","com.example.manage.repository.Repair","com.example.manage.repository.User",
//        "com.example.manage.service.Complain","com.example.manage.service.Repair","com.example.manage.service.User",
//        "com.example.manage.serviceImpl.Complain","com.example.manage.serviceImpl.Repair","com.example.manage.serviceImpl.User",
//})
@ComponentScan({"example.manage.*"})
public class ManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageApplication.class, args);
    }

}
