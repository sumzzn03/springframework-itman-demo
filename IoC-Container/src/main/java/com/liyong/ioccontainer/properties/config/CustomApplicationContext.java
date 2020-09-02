package com.liyong.ioccontainer.properties.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className CustomApplicationContext
 * @description 自定义环境切换变量参考 SpringBoot
 * @JunitTest: {@link  }
 * @date 2020-08-31 15:25
 **/
@Component
public class CustomApplicationContext implements ApplicationListener<ContextRefreshedEvent>, ApplicationContextAware {

    private static Logger logger = Logger.getLogger(CustomApplicationContext.class.getName());

    public static final String SPRING_PROFILE_ACTIVE = "spring.profiles.active";

    private ApplicationContext applicationContext;

    private void initialize() {

        new ApplicationContextHolder().setApplicationContext(applicationContext);

        ConfigurableEnvironment environment = (ConfigurableEnvironment) this.applicationContext.getEnvironment();

        new EnvironmentHolder().setEnvironment(environment);

        String[] activeProfiles = environment.getActiveProfiles();

        if(activeProfiles == null || activeProfiles.length == 0){

            environment.setActiveProfiles("local");

            System.setProperty(SPRING_PROFILE_ACTIVE, "local");

            activeProfiles = new String[]{"local"};

        }

        String profile = System.getProperty(SPRING_PROFILE_ACTIVE);

        Arrays.stream(activeProfiles).forEach(_profile->{

            if(_profile.equals(profile)){

                //加载对应配置文件

                MutablePropertySources propertySources = environment.getPropertySources();

                Properties properties = new Properties();

                StringBuilder sb = new StringBuilder("application-").append(profile).append(".properties");

                try {

                    String fileName = sb.toString();

                    ClassPathResource resource = new ClassPathResource(sb.toString());

                    properties.load(resource.getInputStream());

                    PropertiesPropertySource propertiesPropertySource = new PropertiesPropertySource(fileName,properties);

                    propertySources.addLast(propertiesPropertySource);

                } catch (Exception e) {

                    throw new RuntimeException(e);

                }

            }

        });

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        initialize();

        contextInitialized();

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void contextInitialized() {

    }

}
