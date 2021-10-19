package com.mindskip.xzs;

import cn.beecp.boot.EnableDataSourceMonitor;
import com.mindskip.xzs.configuration.property.SystemConfig;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//(exclude = {DataSourceAutoConfiguration.class})
/**
 * @author 武汉思维跳跃科技有限公司
 */
@Slf4j
@SpringBootApplication
@EnableTransactionManagement
@EnableConfigurationProperties(value = { SystemConfig.class})
@EnableCaching
@EnableDataSourceMonitor
@ServletComponentScan
@MapperScan("com.mindskip.xzs.repository")
public class XzsApplication {

    public static void main(String[] args) {

        SpringApplication.run(XzsApplication.class, args);

    }

}
