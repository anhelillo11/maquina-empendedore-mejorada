public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    private boolean maquinaConPremio ;
    private int numMaxBilletes;
    private int contador;
    
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, int max, boolean conPremio) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        numMaxBilletes = max;
        contador = 0;
        maquinaConPremio = conPremio;
        
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (contador <numMaxBilletes) {
            if (cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            } 
        }
        else {
            System.out.println("No quedan billetes");
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        double descuento =  (precioBillete *10.0)/100;
        if (contador < numMaxBilletes) {
            if (cantidadDeDineroQueFalta <= 0) { 
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();         
               
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                contador ++;
                if (maquinaConPremio == true && contador ==3) {
                    System.out.println("Tiene un descuento del " + descuento + " del coste del billete para compras en el comercio que elija");
                    contador = 0;
                }
                

            }  
            else {
                System.out.println("Necesitas introducir " + cantidadDeDineroQueFalta + " euros mas!");
    
            }   
        }
        else {
            System.out.println("No quedan billetes");
        }
    }
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 

    public int vaciarDineroDeLaMaquina() {
        int dineroVaciado = -1;
        if (balanceClienteActual == 0) {
            dineroVaciado = balanceClienteActual + totalDineroAcumulado;
            balanceClienteActual = 0;
            totalDineroAcumulado = 0;            
        }
        else{
            System.out.println("Error");
            System.out.println("Hay una operacion en curso");
        }
        return dineroVaciado;
    }

    public int getNumeroBilletesVendidos() {

        return totalDineroAcumulado / precioBillete;

    }

    public void imprimeNumeroBilletesVendidos() {
        System.out.println("El numero de billetes vendidos es " + getNumeroBilletesVendidos());
    }
}
