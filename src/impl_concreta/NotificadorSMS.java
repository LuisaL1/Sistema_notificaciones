package impl_concreta;

import clases_ocp.NotificadorBase;
import clases_srp.ValidadorTelefono;
import interfaces_isp.IEnviadorSMS;

class NotificadorSMS extends NotificadorBase implements IEnviadorSMS {

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
        System.out.println("📱 SMS enviado:");
        System.out.println("   Para: " + telefono);
        System.out.println("   Mensaje: " + mensaje);
        System.out.println();
    }
}