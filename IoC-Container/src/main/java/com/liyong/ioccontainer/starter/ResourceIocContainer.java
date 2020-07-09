package com.liyong.ioccontainer.starter;

import cn.hutool.core.io.resource.InputStreamResource;
import com.alibaba.druid.util.Utils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className ResourceIocContainer
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-07-09 21:02    
 *
 *
**/
public class ResourceIocContainer {

    public static void main(String[] args) throws Exception {

        urlResource();

        classPathResource();

        fileSystemResource();

        inputStreamResource();

        byteArrayResource();

    }

    private static void byteArrayResource() throws IOException {

        ByteArrayResource byteArrayResource = new ByteArrayResource("Hello world".getBytes());

        print("ByteArrayResource",byteArrayResource.getInputStream());

    }

    private static void inputStreamResource() throws IOException {

        ClassPathResource classPathResource = new ClassPathResource("config/app.properties");

        InputStream inputStream = classPathResource.getInputStream();

        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);

        print("InputStreamResource",inputStreamResource.getStream());

    }

    private static void fileSystemResource() throws IOException {

        FileSystemResource fileSystemResource = new FileSystemResource("/Users/liyong/work/code/SpringFramework5.2.6/IoC-Container/src/main/resources/config/app.properties");

        print("FileSystemResource",fileSystemResource.getInputStream());

    }

    private static void classPathResource() throws IOException {

        ClassPathResource classPathResource = new ClassPathResource("config/app.properties");

        print("ClassPathResource",classPathResource.getInputStream());

    }

    private static void urlResource() throws Exception {

        UrlResource urlResource = new UrlResource("file:/Users/liyong/work/code/SpringFramework5.2.6/IoC-Container/src/main/resources/config/app.properties");
//        URL url = new URL("file:/Users/liyong/work/code/SpringFramework5.2.6/IoC-Container/src/main/resources/config/app.properties");
//        try(InputStream is = urlResource.getInputStream()) {
//            String read = Utils.read(is);
//            System.out.println(read);
//        }

        InputStream inputStream = urlResource.getInputStream();

        print("UrlResource",inputStream);

    }

    public static void print(String flag , InputStream inputStream){

        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);

        String urlResourceStr = inputStreamResource.readUtf8Str();

        System.out.println(flag+":"+urlResourceStr);

    }

}
