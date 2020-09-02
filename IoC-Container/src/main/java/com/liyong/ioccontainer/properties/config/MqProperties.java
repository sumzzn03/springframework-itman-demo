package com.liyong.ioccontainer.properties.config;

import com.liyong.ioccontainer.properties.ConfigurationProperties;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className MivsMqProperties
 * @description mq配置信息
 * @JunitTest: {@link  }
 * @date 2020-08-31 16:59
 **/
@ConfigurationProperties(prefix = "custom.mq")
public class MqProperties {

    /** ccsid编号 */
    private Integer ccsid;

    /** ip */
    private String ip;

    /** port */
    private Integer port;

    /** MQ通道名称 */
    private String channel;

    /** 队列管理器名称 */
    private String mqName;

    /** 往帐队列名 */
    private String oqueueName;

    public Integer getCcsid() {
        return ccsid;
    }

    public void setCcsid(Integer ccsid) {
        this.ccsid = ccsid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getMqName() {
        return mqName;
    }

    public void setMqName(String mqName) {
        this.mqName = mqName;
    }

    public String getOqueueName() {
        return oqueueName;
    }

    public void setOqueueName(String oqueueName) {
        this.oqueueName = oqueueName;
    }

    @Override
    public String toString() {
        return "MqProperties{" +
                "ccsid=" + ccsid +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", channel='" + channel + '\'' +
                ", mqName='" + mqName + '\'' +
                ", oqueueName='" + oqueueName + '\'' +
                '}';
    }
}
