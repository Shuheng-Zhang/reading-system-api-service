package com.heng.reading.apiservice.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * 应用启动初始化
 */
@Slf4j
@Order(100)
@Component
public class AppLaunchInit implements ApplicationRunner {

    @Value("${extendStorage.accountDataDirRoot}")
    private String extendStoragePath;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        checkStorageDir();
    }

    /**
     * 检查数据根目录
     */
    private void checkStorageDir() {
        File dir = new File(extendStoragePath);
        if (!dir.exists()) {
            log.warn("Data Storage Root Directory NOT FOUND: {}", extendStoragePath);
            log.warn("Auto Creating Target Directory...");
            dir.mkdirs();
        } else {
            log.info("Found Data Storage Root Directory: {}", extendStoragePath);
        }
    }
}
