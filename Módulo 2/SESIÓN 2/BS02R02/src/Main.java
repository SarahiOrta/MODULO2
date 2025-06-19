import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        System.out.println("🏥 Iniciando acceso a la Sala de cirugía...");

        RecursoMedico salaDeCirugia = new RecursoMedico("Sala de cirugía");

        Runnable medico1 = () -> salaDeCirugia.usar("Dra. Sánchez");
        Runnable medico2 = () -> salaDeCirugia.usar("Dr. Gómez");
        Runnable medico3 = () -> salaDeCirugia.usar("Enfermera Laura");
        Runnable medico4 = () -> salaDeCirugia.usar("Dr. Mosqueda");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.execute(medico1);
        executor.execute(medico2);
        executor.execute(medico3);
        executor.execute(medico4);

        executor.shutdown();



    }
}