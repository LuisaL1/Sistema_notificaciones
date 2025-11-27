package clase_lsp;

import clases_ocp.NotificadorBase;
import clases_srp.ValidadorEmail;
import interfaces_isp.IEnviadorCorreo;
import java.util.logging.Logger;
import java.util.logging.Level;

public class NotificadorEmail extends NotificadorBase implements IEnviadorCorreo {

    private static final Logger logger = Logger.getLogger(NotificadorEmail.class.getName());

    public NotificadorEmail() {
        super(new ValidadorEmail());
    }

    @Override
    protected void ejecutarEnvio(String destinatario, String mensaje) {
        enviarCorreo(destinatario, "Notificación", mensaje);
    }

    @Override
    public void enviarCorreo(String email, String asunto, String cuerpo) {
        // Simulación de envío de correo
        logger.log(Level.INFO, "   EMAIL enviado:");
        logger.log(Level.INFO, "   Para: {0}", email);
        logger.log(Level.INFO, "   Asunto: {0}", asunto);
        logger.log(Level.INFO, "   Mensaje: {0}", cuerpo);
    }
}