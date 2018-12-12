/*HACER MAS PAGEOBJETCS, SEPARAR EN METODOS LAS FUNCIONALIDADES.*/
package pageObjetc;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import structs.structProducto;

public class ZapatillasPuma {
	
	private By botonBuscador;
	private By brand;
	private By size;
	private By resultados;
	private By envioGratis;
	private int topeZapatilla;
	WebDriver driver;
	
	public ZapatillasPuma (WebDriver driver) {
		
		botonBuscador= By.id("gh-btn");
		brand = By.xpath("//span[contains(text(),'PUMA')]");
		size = By.xpath("//span[(text()='10')]");
		envioGratis = By.xpath("//span[contains(text(),'Envío internacional')]");
		resultados = By.xpath("//*[@id='w4']/div[2]/div[1]/div[1]/h1");
		topeZapatilla = 0;
		this.driver= driver;
			
		}
	
	public void busqueda (String busqueda) {
		String urlbarato;
		urlbarato="https://www.ebay.com/sch/i.html?_from=R40&_nkw="+busqueda+ "&_sacat=0&LH_TitleDesc=0&_sop=15";
		driver.navigate().to(urlbarato);
		driver.findElement(botonBuscador).click();
		driver.findElement(brand).click();
		driver.findElement(size).click();
		driver.findElement(envioGratis).click(); 
		System.out.println(driver.findElement(resultados).getText());
		List<WebElement> precios = driver.findElements(By.className("s-item__price"));
		List<WebElement> titulos = driver.findElements(By.className("s-item__title"));
		List<structProducto> datosProductos = new ArrayList<structProducto>();
		for (int i =0; i < topeZapatilla; i++) {
			structProducto datosProducto = new structProducto();
			datosProducto.setPrice(precios.get(i).getText());
			datosProducto.setTitle(titulos.get(i).getText());
			datosProductos.add(datosProducto);
			System.out.println("El titulo del producto es: " + datosProducto.getTitle());
			System.out.println("Y su precio es: " + datosProducto.getPrice());
		}
		
	}
}