package ar.unahur.edu.obj2.patroncommand.invocador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Microcontrolador;
import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;
import ar.unahur.edu.obj2.patroncommand.operaciones.Add;
import ar.unahur.edu.obj2.patroncommand.operaciones.Loadv;
import ar.unahur.edu.obj2.patroncommand.operaciones.Nop;
import ar.unahur.edu.obj2.patroncommand.operaciones.Swap;

public class ProgramaTest {
    
    private Programa programa = new Programa();
    private Programable micro = new Microcontrolador();

    @BeforeEach 

    void setUp(){
        programa.vaciarLista();
        programa.resetearMicro(micro);
    }

    @Test
    void avanzar3PosicionesElProgramCounter(){
        programa.agregarOperacion(new Nop());
        programa.agregarOperacion(new Nop());
        programa.agregarOperacion(new Nop());

        programa.ejecutar(micro);

        assertEquals(3, micro.getProgramCounter());
    }

    @Test
    void sumar20Mas17YObtener37EnAcumuladorA () {
        programa.agregarOperacion(new Loadv(20));
        programa.agregarOperacion(new Swap());
        programa.agregarOperacion(new Loadv(17));
        programa.agregarOperacion(new Add());

        programa.ejecutar(micro);

        assertEquals(37, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
        assertEquals(4, micro.getProgramCounter());

    }

}
