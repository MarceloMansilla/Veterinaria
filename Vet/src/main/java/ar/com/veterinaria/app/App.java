package ar.com.veterinaria.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App 
{
    public static void main( String[] args ) {
		SpringApplication bootApp = new SpringApplication(App.class);
	bootApp.setLogStartupInfo(false);
	bootApp.run(args);
}
}
