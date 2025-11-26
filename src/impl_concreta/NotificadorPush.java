package impl_concreta;

import clases_ocp.NotificadorBase;
import clases_srp.ValidadorDispositivoId;
import interfaces_isp.IEnviadorPush;

class NotificadorPush extends NotificadorBase implements IEnviadorPush {

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
        System.out.println("🔔 PUSH enviado:");
        System.out.println("   Dispositivo: " + dispositivoId);
        System.out.println("   Título: " + titulo);
        System.out.println("   Mensaje: " + cuerpo);
        System.out.println();
    }
}