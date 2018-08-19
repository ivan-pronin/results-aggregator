package com.sportmonks.client.rest.service.types;

public class TypeContainerData<T> {

    private final String basePath;
    private final Class<T> clazz;
    private final Class<T[]> arrayClazz;

    TypeContainerData(String basePath, Class<T> clazz, Class<T[]> arrayClazz) {
        this.basePath = basePath;
        this.clazz = clazz;
        this.arrayClazz = arrayClazz;
    }

    public String getBasePath() {
        return basePath;
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public Class<T[]> getArrayClazz() {
        return arrayClazz;
    }
}
