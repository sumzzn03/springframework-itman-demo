package com.liyong.ioccontainer.properties;

import org.springframework.util.PatternMatchUtils;

import java.util.Collection;

/**
 * @author <a href="http://youngitman.tech">青年IT男</a>
 * @version v1.0.0
 * @className PatternPropertyNamePatternsMatcher
 * @description {@link org.springframework.boot.bind.PatternPropertyNamePatternsMatcher}
 * @JunitTest: {@link  }
 * @date 2020-08-31 16:17
 **/
public class PatternPropertyNamePatternsMatcher implements PropertyNamePatternsMatcher {

    private final String[] patterns;

    PatternPropertyNamePatternsMatcher(Collection<String> patterns) {
        this.patterns = (patterns == null ? new String[] {}
                : patterns.toArray(new String[patterns.size()]));
    }

    @Override
    public boolean matches(String propertyName) {
        return PatternMatchUtils.simpleMatch(this.patterns, propertyName);
    }

}

