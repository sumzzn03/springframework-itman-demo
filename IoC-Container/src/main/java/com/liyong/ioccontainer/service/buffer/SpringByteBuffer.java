package com.liyong.ioccontainer.service.buffer;

import org.springframework.core.io.buffer.DefaultDataBuffer;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className SpringByteBuffer
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-04-27 22:35    
 *
 *
**/
public class SpringByteBuffer {

    public static void main(String[] args) {

        DefaultDataBufferFactory bufferFactory = new DefaultDataBufferFactory();

        DefaultDataBuffer defaultDataBuffer = bufferFactory.allocateBuffer(4);

        Integer integer = new Integer(1);

        defaultDataBuffer.write(integer.byteValue());

        System.out.println(defaultDataBuffer.read());

    }
}
