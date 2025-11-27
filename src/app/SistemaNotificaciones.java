package app;

import clase_dip.GestorNotificaciones;
import clase_lsp.NotificadorEmail;
import clases_ocp.impl_ocp.NotificadorWhatsApp;
import impl_concreta.NotificadorPush;
import impl_concreta.NotificadorSMS;
import interfaz_principal.INotificador;
import java.util.logging.Logger;
import java.util.logging.Level;

public class SistemaNotificaciones {

    private static final Logger logger = Logger.getLogger(SistemaNotificaciones.class.getName());

    public static void main(String[] args) {
        logger.info("=== SISTEMA DE NOTIFICACIONES - PRINCIPIOS SOLID ===\n");

        // Crear diferentes notificadores
        INotificador notifEmail = new NotificadorEmail();
        INotificador notifSMS = new NotificadorSMS();
        INotificador notifPush = new NotificadorPush();
        INotificador notifWhatsApp = new NotificadorWhatsApp();

        // Usar el gestor con diferentes notificadores (DIP + LSP)
        GestorNotificaciones gestor = new GestorNotificaciones(notifEmail);

        try {
            // Enviar email
            logger.info("--- Enviando Email ---");
            gestor.enviarNotificacion("maria@example.com", "Tu pedido ha sido enviado");

            // Cambiar a SMS (LSP - podemos sustituir sin problemas)
            logger.info("--- Enviando SMS ---");
            gestor.setNotificador(notifSMS);
            gestor.enviarNotificacion("+573001234567", "Código de verificación: 123456");

            // Cambiar a Push
            logger.info("--- Enviando Push ---");
            gestor.setNotificador(notifPush);
            gestor.enviarNotificacion("device_abc123xyz", "Tienes un nuevo mensaje");

            // Cambiar a WhatsApp (OCP - nueva funcionalidad sin modificar código existente)
            logger.info("--- Enviando WhatsApp ---");
            gestor.setNotificador(notifWhatsApp);
            gestor.enviarNotificacion("+573009876543", "Tu cita es mañana a las 10:00 AM");

            // Demostrar validación
            logger.info("--- Probando validación ---");
            gestor.setNotificador(notifEmail);
            gestor.enviarNotificacion("email-invalido", "Esto fallará");

        } catch (IllegalArgumentException e) {
            logger.log(Level.SEVERE, " Error: {0}", e.getMessage());
        }
    }
}