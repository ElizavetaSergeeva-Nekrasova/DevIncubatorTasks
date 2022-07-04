package by.incubator.task10;

public class EmptyFileException extends Exception{
    String filePath;

    public EmptyFileException(String message, String filePath) {
        super(message);
        this.filePath = filePath;
    }

    public EmptyFileException(String message, Throwable cause, String filePath) {
        super(message, cause);
        this.filePath = filePath;
    }
}
