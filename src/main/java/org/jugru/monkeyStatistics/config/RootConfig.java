package org.jugru.monkeyStatistics.config;

import java.util.regex.Pattern;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


//    
//@Configuration
//@ComponentScan(basePackages = {"org.jugru"},
//        excludeFilters = {
//            @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
//        })

public class RootConfig {

}
