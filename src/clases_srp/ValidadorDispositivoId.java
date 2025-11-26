package clases_srp;

import interfaces_isp.IValidadorFormato;

public class ValidadorDispositivoId implements IValidadorFormato {
    @Override
    public boolean esFormatoValido(String dispositivoId) {
        return dispositivoId != null && dispositivoId.length() >= 10;
    }
}
