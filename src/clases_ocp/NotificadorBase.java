package clases_ocp;

import interfaces_isp.IValidadorFormato;
import interfaz_principal.INotificador;

public abstract class NotificadorBase implements INotificador {
    protected IValidadorFormato validador;

    // Constructor cambiado a protected
    protected NotificadorBase(IValidadorFormato validador) {
        this.validador = validador;
    }

    @Override
    public boolean validarDestinatario(String destinatario) {
        return validador.esFormatoValido(destinatario);
    }

    // Template method que define el flujo general
    @Override
    public void enviar(String destinatario, String mensaje) {
        if (!validarDestinatario(destinatario)) {
            throw new IllegalArgumentException("Destinatario inválido: " + destinatario);
        }

        if (mensaje == null || mensaje.isEmpty()) {
            throw new IllegalArgumentException("El mensaje no puede estar vacío");
        }

        ejecutarEnvio(destinatario, mensaje);
    }

    // Método abstracto que cada subclase implementará
    protected abstract void ejecutarEnvio(String destinatario, String mensaje);
}