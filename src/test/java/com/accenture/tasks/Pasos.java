package com.accenture.tasks;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.accenture.features.search.*;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.matches;

import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.ini4j.spi.IniFormatter;
import org.openqa.selenium.By;

public class Pasos {

	private ResourceBundle rb;
	private String usuario;
	private String contraseña;
	private String asunto;
	private String descripcion;
	
	private void initConfig() {
		rb = ResourceBundle.getBundle("com/accenture/features/search/config");
		usuario = rb.getString("username");
		contraseña = rb.getString("password");
		asunto = "Prueba con serenity y screenplay";
		descripcion = "Serenity"; 
	}
	
	LecturaArchivoExcel lectura = new LecturaArchivoExcel();
	
	public WebDriver driver;
	@Step("Ingresar al Login de gmail")
	public void paso1(WebDriver driver) throws InterruptedException {
		initConfig();
		this.driver = driver;
		driver.get("https://www.google.com.co");
		WebElement iniciaGmail = driver.findElement(By.xpath("//*[@class='gb_P']")); //*[@id='gb_70']
		iniciaGmail.click();
		System.out.println("Retoserenity paso a paso");
		//que se quiere hacer en estas lineas
		//String resultado = driver.switchTo().activeElement().getAttribute("name");
		Thread.sleep(1000);
		//assertThat(resultado, is("identifier"));

	}
	@Step("Ingresar usuario y contraseña")
	public void paso2() throws InterruptedException {
		WebElement user = driver.findElement(By.xpath("//*[@id='identifierId']"));
		user.sendKeys(usuario + "\n");
		WebElement pass = driver.findElement(By.xpath("//*[@id=\'password\']/div[1]/div/div[1]/input"));
		pass.sendKeys(contraseña + "\n");
		Thread.sleep(1000);
		
		//para que sirve el switchto
		//String resultado1 = driver.switchTo().activeElement().getAttribute("name");
		//assertThat(resultado1, is("q"));

	}
	@Step("Ingresar a redactar , escribor correos, asunto , descripcion ")
	public void paso3() throws InterruptedException {
	
		

		for (Dato informacion :lectura.leer()) {
		
	   
		WebElement btnRedactar = driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']"));
		btnRedactar.click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement btnPara = driver.findElement(By.xpath("//textarea[@name='to']"));
		btnPara.sendKeys(informacion.getCorreo() + "\n");
		WebElement btnAsunto = driver.findElement(By.xpath("//input[@name='subjectbox']"));
		btnAsunto.sendKeys(asunto + "\n");
		WebElement btnDescripcion = driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf']"));
		btnDescripcion.sendKeys(descripcion + "\n");
		WebElement btnEnviar = driver.findElement(By.xpath("//div[text()='Enviar']"));
		btnEnviar.click();
		
		System.out.println("correo se el envia a "  + informacion.getCorreo());
		Thread.sleep(1200);
	}
	
	}
	
}
