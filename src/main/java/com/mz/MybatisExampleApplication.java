package com.mz;

import com.mz.listener.SpringBootApplicationListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mz.mapper") // mybatis接口扫描路径
public class MybatisExampleApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MybatisExampleApplication.class);
        // 添加监听
        application.addListeners(new SpringBootApplicationListener());
        application.run(args);
    }
}
