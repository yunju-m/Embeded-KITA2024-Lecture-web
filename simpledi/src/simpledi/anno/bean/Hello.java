package simpledi.anno.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import simpledi.anno.service.Printer;

@Component("hello")
public class Hello {

	@Value("Spring")
	private String name;
	@Autowired
	@Qualifier("stringPrinter")
	private Printer printer;

	public Hello() {
	}

	public Hello(String name, Printer printer) {
		super();
		this.name = name;
		this.printer = printer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	@Override
	public String toString() {
		return "Hello [name=" + name + ", printer=" + printer + "]";
	}

}
