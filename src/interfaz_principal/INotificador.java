package interfaz_principal;

public interface INotificador {
    void enviar(String destinatario, String mensaje);
    boolean validarDestinatario(String destinatario);
}
