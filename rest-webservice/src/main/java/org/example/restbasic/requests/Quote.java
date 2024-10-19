package org.example.restbasic.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//to indicate that any properties not bound in this type should be ignored.
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    public String type;
    public Value value;

    public Quote(String type, Value value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
