import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Pedido> pedidos = List.of(
                new Pedido("Luis", "Domicilio", "56-1937-3204"),
                new Pedido("Yaretzy", "Local", "56-1029-3040"),
                new Pedido("Ximena", "Domicilio", "56-3343-3404"),
                new Pedido("Martha", "Domicilio", null)
        );

        System.out.println("✅ Confirmación de pedidos a domicilio:");

        pedidos.stream()
//                map transforma Paciente -> Optional
                .map(Pedido::getTelefono)
//                Fliter permite solo los Optional
                .filter(Optional::isPresent)
//                map extrae el valor de Optional
                .map(Optional::get)
                .map(tel -> "📞 Confirmación enviada al número:" + tel)
//                foreach imprime los valores
                .forEach(System.out::println);


    }
}