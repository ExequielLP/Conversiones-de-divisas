package servis;

import com.google.gson.internal.GsonTypes;
import entity.Moneda;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MonedaServis {

    public Double ObtenerValoresDivisas(String divisa1,Double cantidad1,String divisa2) {
        FetchApi api = new FetchApi();
        Moneda moneda = api.buscaMoneda();
        Map<String,Double>monedasValores=moneda.conversion_rates();
        Double cotizacionDolar=monedasValores.get(divisa2);
        Double resultado=(cotizacionDolar*cantidad1)/monedasValores.get(divisa1);
        System.out.println("LA CANTIDAD ES DE "+resultado+" "+divisa2);
        return resultado;
    }
    public Double calcularDivisas(){

        return null;
    }

    public void menu(){
        boolean salir=true;
        do {
            try {
            System.out.println("bienvenido ! selecciona el numero de la opcion que quieras \n1 convertir pesos ars en dolares  \n2 convertir dolares en pesos ars \n3 convertir reales en dolares \n4 convertir dolares en reales \n5 convertir peso colombiano en dolares \n6 convertir dolares en peso colombiano \n7 salir");
            Scanner scanner = new Scanner(System.in);
            Scanner scannerDivisa = new Scanner(System.in);
            int opsion = scanner.nextInt();

                switch (opsion) {
                    case 1:
                        System.out.println("ingresa cantidad en pesos");
                        double cantidad = scannerDivisa.nextDouble();
                        ObtenerValoresDivisas("ARS", cantidad, "USD");
                        break;
                    case 2:
                        System.out.println("ingrese cantidad en dolares");
                        double cantidad1 = scannerDivisa.nextDouble();
                        ObtenerValoresDivisas("USD", cantidad1, "ARS");
                        break;
                    case 3:
                        System.out.println("ingrese cantidad de reales");
                        double cantidad3 = scannerDivisa.nextDouble();
                        ObtenerValoresDivisas("BRL", cantidad3, "USD");
                        break;
                    case 4:
                        System.out.println("ingrese cantidad de dolares");
                        double cantidad4 = scannerDivisa.nextDouble();
                        ObtenerValoresDivisas("USD", cantidad4, "BRL");
                        break;
                    case 5:
                        System.out.println("ingrese cantidad de peso colombiano");
                        double cantidad5 = scannerDivisa.nextDouble();
                        ObtenerValoresDivisas("COP", cantidad5, "USD");
                        break;
                    case 6:
                        System.out.println("ingrese cantidad de dolares");
                        double cantidad6 = scannerDivisa.nextDouble();
                        ObtenerValoresDivisas("USD", cantidad6, "COP");
                        break;
                    case 7:
                        System.out.println("adios");
                        salir = false;
                        break;

                }
            }catch (Exception e){
                System.out.println("UN NUMERO");
            }


        } while (salir);

    }


}