/*
 * Dulce Rebeca Ambrosio Jimenez - 231143
 * Fecha de Creación: 11/08/2023
 * Fecha de última modificación: 12/08/2023
 */
import java.util.Random;

public class Comprador { //se crea la clase comprador
    private int ticketNum; //se declaran las variables
    private boolean valido;
    private String nombre;
    private String email;
    private int cant_boletos;
    private int pres_Max;

    public Comprador(String nombre, String email, int cant_boletos, int pres_Max) { //
        this.nombre = nombre;
        this.email = email;
        this.cant_boletos = cant_boletos;
        this.pres_Max = pres_Max;
        generarTicket();
        validarTicket();
    }

    private void generarTicket() { //se genera los dos números al azar
        Random random = new Random();
        ticketNum = random.nextInt(15000) + 1;
    }

    private void validarTicket() {
        Random random = new Random();
        int a = random.nextInt(15000) + 1;
        int b = random.nextInt(15000) + 1;

        int min = Math.min(a, b);
        int max = Math.max(a, b);

        valido = (min <= ticketNum) && (ticketNum <= max);
    }

    public boolean puedeComprar(int disponibles, int precio) { //se genera las condiciones para poder comprar
        return valido && cant_boletos > 0 && cant_boletos <= disponibles && precio <= pres_Max;
    }

    public int getCantidad() {
        return cant_boletos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail(){
        return email;
    }
}
