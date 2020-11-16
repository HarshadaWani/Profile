package com.example.demo;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import io.jaegertracing.Configuration;
import io.jaegertracing.internal.JaegerTracer;
//import org.hibernate.cfg.Configuration;
//import javax.security.auth.login.Configuration;
//import org.springframework.context.annotation.Configuration;
//import io.jaegertracing.internal.samplers.ProbabilisticSampler;
//import io.opentracing.contrib.java.spring.jaeger.starter.JaegerConfigurationProperties.ProbabilisticSampler;

@SpringBootApplication
public class DemoProfile1Application {
	
	/*@Bean
	
	public io.opentracing.Tracer jaegertracer() {
	
	    return new Configuration("spring-boot" ,new Configuration.SamplerConfiguration(ProbabilisticSampler.TYPE, 1),
	    		new Configuration.ReporterConfiguration()).getTracer();
	}*/
	
	@Bean
	public static JaegerTracer getTracer() {
	    Configuration.SamplerConfiguration samplerConfig = Configuration.SamplerConfiguration.fromEnv().withType("const").withParam(1);
	    Configuration.ReporterConfiguration reporterConfig = Configuration.ReporterConfiguration.fromEnv().withLogSpans(true);
	    Configuration config = new Configuration("jaeger tutorial").withSampler(samplerConfig).withReporter(reporterConfig);
	    return config.getTracer();
	}
	
	/*@Bean
	public  io.opentracing.Tracer jaegerTracer(){
		return new Configuration(serviceName "spring-boot", new Configuration.SamplerConfiguration(ProbabilisticsSampler.TYPE,1),
				new Configuration.ReporterConfiguration())
				.getTracer();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(DemoProfile1Application.class, args);
	}

}
