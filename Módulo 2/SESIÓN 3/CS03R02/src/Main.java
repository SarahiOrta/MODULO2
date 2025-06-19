import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Sucursal> sucursales = List.of(
                new Sucursal("Centro", List.of(
                        new Encuesta("Antonio", null, 4),
                        new Encuesta("Juan", "El tiempo de espera fue largo", 3),
                        new Encuesta("Maria", "null", 5),
                        new Encuesta("Juan", "La atención fue buena, pero la limpieza puede mejorar", 3)
                )),
                new Sucursal("Norte", List.of(
                        new Encuesta("Luis", null, 4),
                        new Encuesta("Jaime", null, 5),
                        new Encuesta("Karla", "La atención no fue la adecuada", 2)
                ))
        );


        sucursales.stream()
                .flatMap(sucursal ->
                                sucursal.getEncuestas().stream()

                                        .filter(encuesta -> encuesta.getCalificacion() <= 3)


                                        .flatMap(encuesta -> encuesta.getComentario()


                                                        .filter(c -> !c.equalsIgnoreCase("null"))
                                                        .map(comentario ->
                                                                "Sucursal " + sucursal.getNombre() + ": Seguimiento a paciente con comentario: \"" + comentario + "\""
                                                        )
                                                        .stream()
                                        )
                )
                .forEach(System.out::println);
    }
}