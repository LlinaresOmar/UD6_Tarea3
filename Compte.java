package es.iesmz.tests;
import java.math.BigInteger;

public class Compte {

    private String numCuenta;

    public Compte(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public boolean compruebaIban(){
        boolean estaok = false;
        if (numCuenta.length() == 24){
            if (numCuenta.matches("ES\\d{22}")){
                String digitosControlString = getControlString();
                if (digitosControlString.matches(numCuenta.substring(2,4))){
                    estaok = true;
                }
            }
        }
        return estaok;
    }

    private String getControlString() {
        String eS00 = "142800";
        String c8 = numCuenta.substring(4);
        BigInteger numComString = new BigInteger(c8+ eS00);
        BigInteger digitos = (new BigInteger("98")).subtract(numComString.remainder(new BigInteger("97")));
        int digtosControl = digitos.intValue();
        String digitosControlString;
        if (digtosControl > 10){
            digitosControlString = String.valueOf(digtosControl);
        } else {
            digitosControlString = "0" + digtosControl;
        }
        return digitosControlString;
    }

    public String generaIBAN(String entidad, String oficina, String dc, String cuenta) {
        String iban = "ES" + entidad + oficina + dc + cuenta;
        String digitosControlString = getControlStringForIBAN(iban);
        return "ES" + digitosControlString + entidad + oficina + dc + cuenta;
    }


    private String getControlStringForIBAN(String iban) {
        String eS00 = "142800";
        String c8 = iban.substring(4);
        BigInteger numComString = new BigInteger(c8 + eS00);
        BigInteger digitos = (new BigInteger("98")).subtract(numComString.remainder(new BigInteger("97")));
        int digitosControl = digitos.intValue();
        String digitosFinal;
        if (digitosControl > 10){
            digitosFinal = String.valueOf(digitosControl);
        } else {
            digitosFinal = "0" + digitosControl;
        }
        return digitosFinal;
    }
}
