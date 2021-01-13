package hu.bakcsa.jetty_rest_example.rest.controller;

public class ResponseObject {
    String stringProp;
    Integer intProp;

    public ResponseObject() {
    }

    public String getStringProp() {
        return stringProp;
    }

    public void setStringProp(String stringProp) {
        this.stringProp = stringProp;
    }

    public Integer getIntProp() {
        return intProp;
    }

    public void setIntProp(Integer intProp) {
        this.intProp = intProp;
    }
}
