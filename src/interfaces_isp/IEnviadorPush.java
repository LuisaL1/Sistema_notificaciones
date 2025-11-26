package interfaces_isp;

public interface IEnviadorPush {
    void enviarNotificacionPush(String dispositivoId, String titulo, String cuerpo);
}