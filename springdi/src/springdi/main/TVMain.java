package springdi.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springdi.domain.TV;

public class TVMain {

	// bean을 생성/관리하는 빈 컨테이너
	private ApplicationContext context;
	
	public TVMain() {
		context = new GenericXmlApplicationContext("/springdi/conf/applicationContext.xml");
	}

	public static void main(String[] args) { 
		
		TVMain tvmain = new TVMain();
		
		// spring의 bean은 기본적으로 singleton (객체를 하나만 생성)
		// <bean> 태그로 설정하면 기본적으로 singleton으로 생성
		
		// getBean : 스프링 빈컨테이너내의 빈을 찾음(Lookup)
		TV tv_constructor = (TV)tvmain.context.getBean("tv_constructor");
		System.out.println(tv_constructor);
		
		TV tv_constructor2 = (TV)tvmain.context.getBean("tv_constructor");
		System.out.println(tv_constructor2);
		
		TV tv_setter = (TV)tvmain.context.getBean("tv_setter");
		System.out.println(tv_setter);
		
		TV tv_setter2 = (TV)tvmain.context.getBean("tv_setter");
		System.out.println(tv_setter2);
		
	}
	
} // class
