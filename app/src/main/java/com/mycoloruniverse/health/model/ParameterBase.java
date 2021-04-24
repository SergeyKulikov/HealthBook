package com.mycoloruniverse.health.model;

abstract class ParameterBase {
    private String id;
    private String name;
    private Object object;

    abstract String getId();
    abstract void setId(String string);
}
