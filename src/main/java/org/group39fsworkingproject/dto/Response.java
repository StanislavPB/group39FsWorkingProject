package org.group39fsworkingproject.dto;

import java.util.List;

public class Response <T>{
    T data;
    List<String> errors;

    public Response(T data, List<String> errors) {
        this.data = data;
        this.errors = errors;
    }

    public T getData() {
        return data;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void addError(String error){
        errors.add(error);
    }

    @Override
    public String toString() {
        return "Response{" +
                "data=" + data +
                ", errors=" + errors +
                '}';
    }
}
