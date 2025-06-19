import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        double limite = 0;
        
        // Manejo seguro de la entrada del límite
        while (true) {
            try {
                System.out.println("Ingrese el limite de la tarjeta de credito: ");
                limite = lectura.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Por favor, ingrese un número válido (use punto decimal)");
                lectura.nextLine(); // Limpiar el buffer
            }
        }
        
        TarjertaDeCredito tarjeta = new TarjertaDeCredito(limite);
        int salir = 1;
        
        while (salir != 0) {
            lectura.nextLine(); // Limpiar el buffer antes de leer la descripción
            
            System.out.println("Ingrese la descripcion de la compra: ");
            String descripcion = lectura.nextLine();
            
            double precio = 0;
            while (true) {
                try {
                    System.out.println("Ingrese el precio de la compra: ");
                    precio = lectura.nextDouble();
                    break;
                } catch (Exception e) {
                    System.out.println("Por favor, ingrese un número válido (use punto decimal)");
                    lectura.nextLine(); // Limpiar el buffer
                }
            }

            Compra compra = new Compra(precio, descripcion);
            boolean compraRealizada = tarjeta.LanzarCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra realizada");
                while (true) {
                    try {
                        System.out.println("Escriba 0 para salir o 1 para continuar");
                        salir = lectura.nextInt();
                        if (salir == 0 || salir == 1) break;
                        System.out.println("Por favor, ingrese 0 o 1");
                    } catch (Exception e) {
                        System.out.println("Por favor, ingrese un número válido (0 o 1)");
                        lectura.nextLine(); // Limpiar el buffer
                    }
                }
            } else {
                System.out.println("Saldo insuficiente!!, intentelo de nuevo");
                salir = 1;
            }
        }

        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");
        Collections.sort(tarjeta.getLanzarCompra());
        for (Compra compra : tarjeta.getLanzarCompra()) {
            System.out.println(compra.getDescripcion() + " - " + compra.getPrecio());
        }
        System.out.println("\n***********************");
        System.out.println("\nSaldo de la tarjeta: " + tarjeta.getSaldo());
        System.out.println("\n***********************");
    }
}