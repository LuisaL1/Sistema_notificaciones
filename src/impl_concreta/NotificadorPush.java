package impl_concreta;

import clases_ocp.NotificadorBase;
import clases_srp.ValidadorDispositivoId;
import interfaces_isp.IEnviadorPush;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NotificadorPush extends NotificadorBase implements IEnviadorPush {

    private static final Logger logger = Logger.getLogger(NotificadorPush.class.getName());

    public NotificadorPush() {
        super(new ValidadorDispositivoId());
    }

    @Override
    protected void ejecutarEnvio(String destinatario, String mensaje) {
        enviarNotificacionPush(destinatario, "Nueva Notificación", mensaje);
    }

    @Override
    public void enviarNotificacionPush(String dispositivoId, String titulo, String cuerpo) {
        // Simulación de envío de notificación push

        logger.log(Level.INFO, "PUSH enviado");
        logger.log(Level.INFO, "Dispositivo: {0}", dispositivoId);
        logger.log(Level.INFO, "Título: {0}", titulo);
        logger.log(Level.INFO, "Mensaje: {0}", cuerpo);
    }
}
