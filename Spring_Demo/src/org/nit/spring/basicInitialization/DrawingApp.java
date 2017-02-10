package org.nit.springs;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// Triangle t = new Triangle(); // Spring is not using here. 
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("Spring.xml"));
		Triangle t = (Triangle) factory.getBean("triangle");
		t.draw();
	}

}
