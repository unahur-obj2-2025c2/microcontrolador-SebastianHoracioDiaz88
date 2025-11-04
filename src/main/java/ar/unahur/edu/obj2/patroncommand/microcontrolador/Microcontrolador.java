package ar.unahur.edu.obj2.patroncommand.microcontrolador;

import java.util.Arrays;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.excepciones.FueraDeLRangoDeMemoriaException;
import ar.unahur.edu.obj2.patroncommand.operaciones.Operable;

public class Microcontrolador implements Programable {

    private Integer acumuladorA;
    private Integer acumuladorB;
    private Integer programCounter;
    private List<Integer> memoria;

    public Microcontrolador() {
        this.reset();
    }

    @Override
    public void run(List<Operable> operaciones) {
        operaciones.stream().forEach(o -> o.execute(this));
    }

    @Override
    public void incProgramCounter() {
        programCounter = programCounter + 1;
    }
    @Override
    public Integer getProgramCounter() {
        return programCounter;
    }
    @Override
    public void setAcumuladorA(Integer value) {
        acumuladorA = value;
    }
    @Override
    public Integer getAcumuladorA() {
       return acumuladorA;
    }
    @Override
    public void setAcumuladorB(Integer value) {
       acumuladorB = value;
    }
    @Override
    public Integer getAcumuladorB() {
        return acumuladorB;
    }
    @Override
    public void setAddr(Integer addr) {
        estaFueraDelRangoDeMemoria (addr);
        memoria.set(addr, acumuladorA);
    }

    @Override
    public Integer getAddr(Integer addr) {
        estaFueraDelRangoDeMemoria (addr);
        return memoria.get(addr);
    }

    public void estaFueraDelRangoDeMemoria (Integer direccionEnMemoria) {
        if(direccionEnMemoria <0 || direccionEnMemoria >= memoria.size()) {
            throw new FueraDeLRangoDeMemoriaException();
        }
    }

    @Override
    public void reset() {
        acumuladorA = 0;
        acumuladorB = 0;
        programCounter = 0;
        Arrays.asList(new Integer[1024]);
    }

}
