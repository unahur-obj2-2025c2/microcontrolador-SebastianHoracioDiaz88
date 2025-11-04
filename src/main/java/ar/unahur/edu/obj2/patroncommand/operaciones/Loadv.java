package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public class Loadv extends Comando{

    private Integer val;
  

    public Loadv(Integer val) {
        this.val = val;
    }


    @Override
    protected void doExecute(Programable micro) {
        micro.setAcumuladorA(val);
    }

}
