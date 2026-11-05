package edu.course.lab05;

public final class ValidationError {

    private final int lineNumber;
    private final String field;
    private final String message;

    public ValidationError(int lineNumber, String field, String message){
        if (lineNumber < 1){
            throw new IllegalArgumentException("Uncorrect lineNumber");
        }
        if (field == null || field.isBlank() || message == null || message.isBlank()){
            throw new IllegalArgumentException("String types is uncorrect");
        }
        this.lineNumber = lineNumber;
        this.field = field;
        this.message = message;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public String getField() {
        return this.field;
    }

    public String getMessage() {
        return this.message;
    }
    
}
