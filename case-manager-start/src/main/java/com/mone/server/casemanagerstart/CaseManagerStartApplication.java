package com.mone.server.casemanagerstart;

import com.mone.server.casemanagerframework.util.PrintApplicationInfo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties
@MapperScan({"com.mone.server.**.mapper", "com.mone.server.casemanagerframework.**.mapper"})
@SpringBootApplication(scanBasePackages = {"com.mone.server.casemanagerframework","com.mone.server.casemanagerstart",
"com.mone.server.config"})
public class CaseManagerStartApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(CaseManagerStartApplication.class, args);
        // 打印项目信息
        PrintApplicationInfo.print(context);
        // 打印项目提示
        PrintApplicationInfo.printTip(context);
    }

}
