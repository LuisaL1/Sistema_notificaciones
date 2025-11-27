package app;

import clase_dip.GestorNotificaciones;
import clase_lsp.NotificadorEmail;
import clases_ocp.impl_ocp.NotificadorWhatsApp;
import impl_concreta.NotificadorPush;
import impl_concreta.NotificadorSMS;
import interfaz_principal.INotificador;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Scanner;

public class SistemaNotificaciones {

    private static final Logger logger = Logger.getLogger(SistemaNotificaciones.class.getName());
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        logger.info("=== SISTEMA DE NOTIFICACIONES - PRINCIPIOS SOLID ===\n");

        // Crear diferentes notificadores
        INotificador notifEmail = new NotificadorEmail();
        INotificador notifSMS = new NotificadorSMS();
        INotificador notifPush = new NotificadorPush();
        INotificador notifWhatsApp = new NotificadorWhatsApp();

        // Usar el gestor con diferentes notificadores (DIP + LSP)
        GestorNotificaciones gestor = new GestorNotificaciones(notifEmail);

        boolean continuar = true;

        while (continuar) {
            try {
                mostrarMenu();
                int opcion = leerOpcion();

                if (opcion == 0) {
                    continuar = false;
                    logger.info("\n=== ¡Gracias por usar el Sistema de Notificaciones! ===");
                } else {
                    INotificador notificadorSeleccionado = seleccionarNotificador(opcion, 
                        notifEmail, notifSMS, notifPush, notifWhatsApp);

                    if (notificadorSeleccionado == null) {
                        logger.warning("Opción inválida. Por favor, seleccione una opción válida.\n");
                    } else {
                        gestor.setNotificador(notificadorSeleccionado);

                        String destinatario = leerDestinatario(opcion);
                        String mensaje = leerMensaje();

                        logger.info("\n--- Enviando notificación ---");
                        gestor.enviarNotificacion(destinatario, mensaje);
                        logger.info("--- Notificación enviada exitosamente ---\n");
                    }
                }

            } catch (IllegalArgumentException e) {
                logger.log(Level.SEVERE, "Error: {0}\n", e.getMessage());
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error inesperado: {0}\n", e.getMessage());
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        logger.info("\n==========================================");
        logger.info("    SISTEMA DE NOTIFICACIONES");
        logger.info("==========================================");
        logger.info("Seleccione el tipo de notificación:");
        logger.info("1. Email");
        logger.info("2. SMS");
        logger.info("3. Push Notification");
        logger.info("4. WhatsApp");
        logger.info("0. Salir");
        logger.info("==========================================");

        logger.info("Opción: ");
    }

    private static int leerOpcion() {
        while (true) {
            try {
                String entrada = scanner.nextLine().trim();
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {

                logger.info("Por favor, ingrese un número válido: ");
            }
        }
    }

    private static INotificador seleccionarNotificador(int opcion, 
            INotificador email, INotificador sms, INotificador push, INotificador whatsapp) {
        switch (opcion) {
            case 1:
                return email;
            case 2:
                return sms;
            case 3:
                return push;
            case 4:
                return whatsapp;
            default:
                return null;
        }
    }

    private static String leerDestinatario(int tipoNotificacion) {
        String prompt = "";
        String ejemplo = "";

        switch (tipoNotificacion) {
            case 1: // Email
                prompt = "Ingrese el email del destinatario";
                ejemplo = "Ejemplo: usuario@example.com";
                break;
            case 2: // SMS
                prompt = "Ingrese el número de teléfono del destinatario";
                ejemplo = "Ejemplo: +573001234567";
                break;
            case 3: // Push
                prompt = "Ingrese el ID del dispositivo";
                ejemplo = "Ejemplo: device_abc123xyz";
                break;
            case 4: // WhatsApp
                prompt = "Ingrese el número de teléfono del destinatario";
                ejemplo = "Ejemplo: +573009876543";
                break;
            default:
                prompt = "Ingrese el destinatario";
                ejemplo = "Ejemplo: destinatario";
                break;
        }
        logger.log(Level.INFO, "{0} ({1}): ", new Object[]{prompt, ejemplo});
        return scanner.nextLine().trim();
    }

    private static String leerMensaje() {

        logger.info("Ingrese el mensaje a enviar: ");
        return scanner.nextLine().trim();
    }
}