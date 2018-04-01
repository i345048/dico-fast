package cn.diconet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = { "cn.diconet.modules.sys.repository" })
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

