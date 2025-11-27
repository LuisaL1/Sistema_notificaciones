package clase_dip;

import interfaz_principal.INotificador;

public class GestorNotificaciones {
    private INotificador notificador;

    // Inyección de dependencias - depende de la interfaz, no de la implementación
    public GestorNotificaciones(INotificador notificador) {
        this.notificador = notificador;
    }

    public void setNotificador(INotificador notificador) {
        this.notificador = notificador;
    }

    public void enviarNotificacion(String destinatario, String mensaje) {
        notificador.enviar(destinatario, mensaje);
    }
}
