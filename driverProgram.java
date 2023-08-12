
import java.util.Scanner;

public class driverProgram {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Localidad localidad = new Localidad();
            Comprador comprador = null;

            while (true) {
                System.out.println("MENÚ:");
                System.out.println("1. Nuevo comprador");
                System.out.println("2. Nueva solicitud de boletos");
                System.out.println("3. Consultar disponibilidad total");
                System.out.println("4. Consultar disponibilidad individual");
                System.out.println("5. Reporte de caja");
                System.out.println("6. Salir");

                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese los siguientes datos:");
                        System.out.println("Nombre: ");
                        System.out.println("Email: ");
                        System.out.println("Cantidad de Boletos: ");
                        System.out.println("Presupuesto Máximo: ");
                        String nombre = scanner.next();
                        String email = scanner.next();
                        int cant_boletos = scanner.nextInt();
                        int pres_Max = scanner.nextInt();
                        comprador = new Comprador(nombre, email, cant_boletos, pres_Max);
                        break;
                    case 2:
                        if (comprador != null) {
                            System.out.println("Ingrese la localidad (1, 2 o 10):");
                            int localElegida = scanner.nextInt();
                            int disponibles = localidad.getDisponibles(localElegida);

                            if (disponibles > 0) {
                                if (comprador.puedeComprar(disponibles, getPrecio(localElegida))) {
                                    localidad.venderBoletos(localElegida, comprador.getCantidad());
                                    System.out.println("Compra realizada por: " + comprador.getNombre());
                                } else {
                                    System.out.println("No es posible realizar la compra por: " + comprador.getNombre());
                                }
                            } else {
                                System.out.println("No hay boletos disponibles en la localidad seleccionada.");
                            }
                        } else {
                            System.out.println("Primero ingrese los datos del comprador.");
                        }
                        break;
                    case 3:
                        localidad.DisponibilidadTotal();
                        break;
                    case 4:
                        localidad.DisponibilidadIndividual();
                        break;
                    case 5:
                        int vendido = localidad.calcularVendido();
                        System.out.println("Vendido: $" + vendido);
                        break;
                    case 6:
                        System.out.println("Se finalizó el programa");
                        return;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
            }
        }
    }

    private static int getPrecio(int localidad) {
        switch (localidad) {
            case 1:
                return 100;
            case 2:
                return 500;
            case 10:
                return 1000;
            default:
                return 0;
        }
    }
}
