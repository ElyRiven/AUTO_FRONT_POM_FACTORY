package org.example.paginas;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.example.utilidades.Constantes;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl(Constantes.URL_REGISTRO)
public class PaginaRegistro extends PageObject {

    @FindBy(id = "displayName")
    private WebElement campoNombreCompleto;

    @FindBy(id = "email")
    private WebElement campoCorreo;

    @FindBy(id = "password")
    private WebElement campoContrasena;

    @FindBy(id = "confirmPassword")
    private WebElement campoConfirmacionContrasena;

    @FindBy(xpath = "//button[@type='submit' and text()='Crear Cuenta']")
    private WebElement botonCrearCuenta;

    public void ingresarNombreCompleto(String nombreCompleto) {
        campoNombreCompleto.sendKeys(nombreCompleto);
    }

    public void ingresarCorreo(String correo) {
        campoCorreo.sendKeys(correo);
    }

    public void ingresarContrasena(String contrasena) {
        campoContrasena.sendKeys(contrasena);
    }

    public void ingresarConfirmacionContrasena(String confirmacionContrasena) {
        campoConfirmacionContrasena.sendKeys(confirmacionContrasena);
    }

    public void hacerClicEnCrearCuenta() {
        botonCrearCuenta.click();
    }

    public String obtenerUrlActual() {
        return getDriver().getCurrentUrl();
    }
}
