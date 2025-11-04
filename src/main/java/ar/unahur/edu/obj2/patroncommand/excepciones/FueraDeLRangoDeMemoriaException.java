package ar.unahur.edu.obj2.patroncommand.excepciones;

public class FueraDeLRangoDeMemoriaException extends RuntimeException{

    public FueraDeLRangoDeMemoriaException() {
        super("estas fuera del rango de memoria");
    }

}
