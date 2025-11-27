package clases_ocp.impl_ocp;

import clases_ocp.NotificadorBase;
import clases_srp.ValidadorTelefono;
import java.util.logging.Logger;
import java.util.logging.Level;

public class NotificadorWhatsApp extends NotificadorBase {

    private static final Logger logger = Logger.getLogger(NotificadorWhatsApp.class.getName());

    public NotificadorWhatsApp() {
        super(new ValidadorTelefono());
    }

    @Override
    protected void ejecutarEnvio(String destinatario, String mensaje) {
        logger.log(Level.INFO, "   WHATSAPP enviado:");
        logger.log(Level.INFO, "   Para: {0}", destinatario);
        logger.log(Level.INFO, "   Mensaje: {0}", mensaje);
    }
}