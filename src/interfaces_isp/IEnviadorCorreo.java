package interfaces_isp;

public interface IEnviadorCorreo {
    void enviarCorreo(String email, String asunto, String cuerpo);
}