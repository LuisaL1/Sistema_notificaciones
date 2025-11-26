package clases_srp;

import interfaces_isp.IValidadorFormato;

public class ValidadorEmail implements IValidadorFormato {
    @Override
    public boolean esFormatoValido(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}