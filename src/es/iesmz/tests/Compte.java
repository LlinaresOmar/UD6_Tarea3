package es.iesmz.tests;
import java.math.BigInteger;

public class Compte {

    private String nomTitular;
    private String numCuenta;

    public Compte(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public boolean compruebaIban(){
        boolean estaok = false;
        if (numCuenta.length() == 24){
            if (numCuenta.matches("ES\\d{22}")){
                String eS00 = "142800";
                String c8 = numCuenta.substring(4);
                BigInteger numComString = new BigInteger(c8+eS00);
                BigInteger digitos = (new BigInteger("98")).subtract(numComString.remainder(new BigInteger("97")));
                int digtosControl = digitos.intValue();
                String digitosControlString;
                if (digtosControl > 10){
                    digitosControlString = String.valueOf(digtosControl);
                } else {
                    digitosControlString = "0" + digtosControl;
                }
                if (digitosControlString.matches(numCuenta.substring(2,4))){
                    estaok = true;
                }
            }
        }
        return estaok;
    }

    public String generaIBAN(String entidad, String oficina, String dc, String cuenta){
        /*
        String iban = String.format("ES" + digitosControl + entidad + oficina + dc + cuenta);
        if (compruebaIban(iban)){
            return iban;
        } else {
            return null;
        }*/
    }

    public String digitosControl(String entidad, String oficina, String dc, String cuenta){
        String ibanSinControl =
    }

}
