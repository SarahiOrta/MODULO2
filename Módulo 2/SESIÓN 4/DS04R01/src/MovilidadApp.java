import java.util.concurrent.CompletableFuture;
import java.util.concurrent.*;

public class MovilidadApp {

    public static void main(String[] args) {


        CompletableFuture<String> rutaFuture = obtenerRuta();

        CompletableFuture<Double> tarifaFuture = obtenerTarifa();

        CompletableFuture<Void> rutaTarifa = rutaFuture.thenCombine(tarifaFuture,
                        (ruta, tarifa) -> {
                            return "🛣️ Ruta caculada: " + ruta + " | Tarifa: " + tarifa;
                        })
                .thenAccept(System.out::println)
                .exceptionally(ex -> {
                    System.out.println("Error al calcular la ruta: " + ex.getMessage());
                    return null;
                });

        rutaTarifa.join();
    }

    public static CompletableFuture<String> obtenerRuta(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🚦Calculando ruta...");
            dormir(3);
            return "Ruta: Centro -> Norte";
        });
    }

    public static CompletableFuture<Double> obtenerTarifa(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("💵 Estimando tarifa...");
            dormir(2);

            String tarifaTexto = "$75.50";

            double tarifa = Double.parseDouble(tarifaTexto.replace("$", ""));

            return tarifa;
        });
    }

    public static void dormir(int segundos){
        try{
            TimeUnit.SECONDS.sleep(segundos);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}