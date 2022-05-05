package be.bxl.icc.reservation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nz.net.ultraq.thymeleaf.layoutdialect.*;


@Configuration
public class ThymeleafConfiguration {
	@Bean
	public LayoutDialect thymeleafDialect() {
	    return new LayoutDialect();
	}
}
