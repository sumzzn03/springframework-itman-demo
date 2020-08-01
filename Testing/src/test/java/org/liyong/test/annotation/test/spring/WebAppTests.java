package org.liyong.test.annotation.test.spring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletContext;
import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className WebAppTests
 * @description Web容器加载配置
 * @JunitTest: {@link  }
 * @date 2020-08-01 22:39
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class WebAppTests {

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    protected MockServletContext mockServletContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }


    @Test
    public void verifyWac() {
        ServletContext servletContext = wac.getServletContext();
        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        for (String beanName : wac.getBeanDefinitionNames()) {
            if (beanName.contains("springCustomContextConfigurationExample")) {
                System.out.println("Bean Name: " + beanName);
                System.out.println("Bean " + wac.getBean(beanName));
            }
        }
    }

    /**
     * 模拟get请求
     *
     * @param
     * @return void
     * @throws
     * @author liyong
     * @date 10:56 PM 2020/8/1
     **/

    @Test
    public void testGetRequest() throws Exception {
        String id = "hello world";
        URI url = UriComponentsBuilder.fromUriString("/greet").pathSegment(id)
                .build().encode().toUri();
        System.out.println("Call " + url + ", result: " +
                mockMvc.perform(get(url)).andReturn().getResponse().getContentAsString());
        mockMvc.perform(get(url)).andExpect(status().isOk())
                .andExpect(content().string("hello world"));
    }

    @Configuration
    @EnableWebMvc
    static class WebConfig extends WebMvcConfigurerAdapter {

        @Bean
        public GreetController greetController() {
            return new GreetController();
        }
    }

    @Controller
    private static class GreetController {

        @RequestMapping(value = "/greet/{id}", method = RequestMethod.GET)
        @ResponseBody
        public String getCircuit(@PathVariable String id) {

            return id;

        }

    }


}
