package org.example.pasos;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.paginas.PaginaRegistro;
import org.example.utilidades.Constantes;

import static org.assertj.core.api.Assertions.assertThat;

public class PasosRegistroUsuario {

    PaginaRegistro paginaRegistro;

    @Given("que el usuario está en la página de registro")
    public void usuarioEnPaginaRegistro() {
        paginaRegistro.open();
    }

    @When("el usuario ingresa {string} en el campo nombre")
    public void ingresarNombre(String nombreCompleto) {
        paginaRegistro.ingresarNombreCompleto(nombreCompleto);
    }

    @And("el usuario ingresa {string} en el campo correo electrónico")
    public void ingresarCorreo(String correo) {
        paginaRegistro.ingresarCorreo(correo);
    }

    @And("el usuario ingresa {string} en el campo contraseña")
    public void ingresarContrasena(String contrasena) {
        paginaRegistro.ingresarContrasena(contrasena);
    }

    @And("el usuario ingresa {string} en el campo confirmación de contraseña")
    public void ingresarConfirmacionContrasena(String confirmacionContrasena) {
        paginaRegistro.ingresarConfirmacionContrasena(confirmacionContrasena);
    }

    @And("hace clic en el botón \"Crear Cuenta\"")
    public void hacerClicEnCrearCuenta() {
        paginaRegistro.hacerClicEnCrearCuenta();
    }

    @Then("la cuenta se crea a través de Firebase Authentication")
    public void cuentaCreadaEnFirebase() {
        paginaRegistro.waitForCondition()
                .until(driver -> !driver.getCurrentUrl().contains(Constantes.URL_REGISTRO));
    }

    @And("el usuario es redirigido al dashboard")
    public void usuarioRedirigidoAlDashboard() {
        assertThat(paginaRegistro.obtenerUrlActual())
                .as("El usuario debería haber sido redirigido al dashboard tras el registro")
                .contains("/dashboard");
    }
}
