package vn.amela.todolist.Model;

public class ResponseTask {
    private String message;
    private Object data;

    public ResponseTask(String message, Object data) {
        this.message = message;
        this.data = data;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
