package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.microcontrolador.Programable;

public abstract class Comando implements Operable {

    Programable microBackUp;

    @Override
    public void undo(Programable micro) {
        micro.copiarDesde(microBackUp);
        
    }

    @Override
    public void execute(Programable micro) {

        microBackUp = micro.copiar();        
        doExecute(micro);
        micro.incProgramCounter();
        
    }

    protected abstract void doExecute(Programable micro);
   
       

}
