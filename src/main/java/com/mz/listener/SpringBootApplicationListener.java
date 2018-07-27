package com.mz.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

/**
 *
 * ==ApplicationPreparedEvent事件在 spring boot上下文context创建完成后触发==
 *
 * ApplicationEnvironmentPreparedEvent 环境变量初始化事件
 * ApplicationPreparedEvent            环境变量初始化完成事件
 * ApplicationReadyEvent               启动完成
 *
 * ContextRefreshedEvent               应用刷新
 * ContextStartedEvent                 应用启动事件
 * ContextStoppedEvent                 应用停止
 * ContextClosedEvent                  应用关闭
 *
 * ContextRefreshedEvent
 * @author zhangZhenfei
 *
 */
@Slf4j
public class SpringBootApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            log.info("ApplicationEnvironmentPreparedEvent");
        }
        if (event instanceof ApplicationPreparedEvent) {
            log.info("ApplicationPreparedEvent");
        }
        if (event instanceof ApplicationReadyEvent) {
            log.info("ApplicationReadyEvent");
        }
        if (event instanceof ContextRefreshedEvent) {
            log.info("ContextRefreshedEvent");
        }
        if (event instanceof ContextStartedEvent) {
            log.info("ContextStartedEvent");
        }
        if (event instanceof ContextStoppedEvent) {
            log.info("ContextStoppedEvent");
        }
        if (event instanceof ContextClosedEvent) {
            log.info("ContextClosedEvent");
        }
    }
}
