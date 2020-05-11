package com.liyong.ioccontainer.service;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 *@author <a href="http://youngitman.tech">青年IT男</a>
 *@version v1.0.0
 *@className CollectionsService
 *@description
 *@JunitTest: {@link  } 
 *@date 2020-05-10 22:16    
 *
 *
**/
public class CollectionsService {

    private Properties properties;

    private List<String> names;

    private Map<String,String> maps;

    private Set<String> datas;

    private InnerService target;


    public CollectionsService(){}

    public CollectionsService(InnerService target) {
        this.target = target;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public Set<String> getDatas() {
        return datas;
    }

    public void setDatas(Set<String> datas) {
        this.datas = datas;
    }

    public InnerService getTarget() {
        return target;
    }

    public void setTarget(InnerService target) {
        this.target = target;
    }
}
