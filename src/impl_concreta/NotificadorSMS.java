package impl_concreta;

import clases_ocp.NotificadorBase;
import clases_srp.ValidadorTelefono;
import interfaces_isp.IEnviadorSMS;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NotificadorSMS extends NotificadorBase implements IEnviadorSMS {

    private static final Logger logger = Logger.getLogger(NotificadorSMS.class.getName());

    public NotificadorSMS() {
        super(new ValidadorTelefono());
    }

    @Override
    protected void ejecutarEnvio(String destinatario, String mensaje) {
        enviarSMS(destinatario, mensaje);
    }

    @Override
    public void enviarSMS(String telefono, String mensaje) {
        // Simulación de envío de SMS
        logger.log(Level.INFO, "SMS enviado");
        logger.log(Level.INFO, "Para: {0}", telefono);
        logger.log(Level.INFO, "Mensaje: {0}", mensaje);
    }
}
