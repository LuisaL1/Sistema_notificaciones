package clases_srp;

import interfaces_isp.IValidadorFormato;

public class ValidadorTelefono implements IValidadorFormato {
    @Override
    public boolean esFormatoValido(String telefono) {
        return telefono != null && telefono.matches("^\\+?\\d{10,15}$");
    }
}