package ke.innv8.library.response;

import java.util.List;

public class GenericResponse<T> {
    private boolean success;
    private List<T> errors;
    private String message;
    private T data;

    public GenericResponse(boolean success,  List<T> errors, String message) {
        this.success = success;
        this.errors = errors;
        this.message = message;
    }

    public GenericResponse(boolean success,  String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }



    public List<T> getErrors() {
        return errors;
    }

    public void setErrors(List<T> errors) {
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
