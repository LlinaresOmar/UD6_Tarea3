package es.iesmz.tests;
import java.math.BigInteger;

public class Compte {

    private String nomTitular;
    private String numCuenta;

    public Compte(String nomTitular, String numCuenta) {
        this.nomTitular = nomTitular;
        this.numCuenta = numCuenta;
    }

    public boolean compruebaIban(String numCuenta){
        boolean estaok = false;
        if (numCuenta.length() == 34){
            if (numCuenta.matches("ES\\d{32}")){
                String eS00 = "142800";
                String c8 = numCuenta.substring(13);
                BigInteger numComString = new BigInteger(c8+eS00);
                BigInteger digitos = (BigInteger.valueOf(98)).subtract(numComString.divide(BigInteger.valueOf(97)));
                int digtosControl = digitos.intValue();
                String digitosControlString;
                if (digtosControl > 10){
                    digitosControlString = String.valueOf(digtosControl);
                } else {
                    digitosControlString = "0" + digtosControl;
                }
                if (digitosControlString.matches(numCuenta.substring(1,3))){
                    estaok = true;
                }
            }
        }
        return estaok;
    }


}
