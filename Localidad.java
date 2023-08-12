import java.util.Scanner;

public class Localidad {
    private int local1 = 65;
    private int local2 = 85;
    private int local10 = 100;

    public int getDisponibles(int localidad) {
        switch (localidad) {
            case 1:
                return local1;
            case 2:
                return local2;
            case 10:
                return local10;
            default:
                return 0;
        }
    }

    public void venderBoletos(int localidad, int cantidad) {
        switch (localidad) {
            case 1:
                local1 -= cantidad;
                break;
            case 2:
                local2 -= cantidad;
                break;
            case 10:
                local10 -= cantidad;
                break;
        }
    }

    public void DisponibilidadTotal() {
        System.out.println("Disponibilidad en Localidad 1: " + local1);
        System.out.println("Disponibilidad en Localidad 2: " + local2);
        System.out.println("Disponibilidad en Localidad 10: " + local10);
    }

    public void DisponibilidadIndividual() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la localidad (1, 2 o 10):");
        int localidadConsulta = scanner.nextInt();
        int disponibles = getDisponibles(localidadConsulta);
        System.out.println("Boletos disponibles en Localidad " + localidadConsulta + ": " + disponibles);
        scanner.close();
    }

    public int calcularVendido() {
        return (getDisponibles(1) - local1) * 100 +
               (getDisponibles(2) - local2) * 500 +
               (getDisponibles(10) - local10) * 1000;
    }
}
