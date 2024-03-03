import java.util.List;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;

/**
 * Aplicação de exemplo de princípios de programação funcional em Java,
 * Expressões Lambda e API de Streams do Java 8.
 *
 * Para aprofundar nestes assuntos, veja os links abaixo:
 *
 * <ul>
 * <li><a href=
 * "https://www.oracle.com/technetwork/pt/articles/java/streams-api-java-8-3410098-ptb.html">Curso
 * Streams e Expressões Lambda do Java 8</a></li>
 * <li><a href= "http://bit.ly/2I2U5bU">Curso JDK 8 MOOC: Lambdas and Streams
 * Introduction</a></li>
 * </ul>
 *
 * @author Manoel Campos da Silva Filho
 */
public class AppProgramacaoFuncional {
    private static final int TOTAL_STUDENTS = 10;
    private final List<Estudante> estudantes;

    public AppProgramacaoFuncional(){
        estudantes = StudentGenerator.generate(TOTAL_STUDENTS);

        var estudantes = estudantes
                            .stream()
                            .filter(Estudante::hasCourse)
                            .collect(
                                    groupingBy(
                                            Estudante::getCourse,
                                            averagingDouble(Estudante::getNota)
                                    )
                            );

        estudantes.forEach((course, average) -> System.out.println(course.getNome() + ": " + average));

        /*
        paraiso
        palmas
        */

    }

    public static void main(String[] args) {
        new AppProgramacaoFuncional();
    }

}
