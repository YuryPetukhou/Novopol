package lv.javaguru.novopol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lv.javaguru.novopol.config.SpringAppConfig;


public class main {

	public static void main(String[] args) {
		ApplicationContext applicationContext
        = new AnnotationConfigApplicationContext(SpringAppConfig.class);


	}

}
