package com.sportmonks.aggregate.rest.service;

import com.sportmonks.aggregate.rest.service.builder.IUriBuilder;
import com.sportmonks.aggregate.rest.service.types.TypeContainerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponents;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public class GetByIdOrAllRestDataService<T> implements IGetByIdOrAllRestDataService<T> {

    private final String basePath;
    private final String byIdPath;
    private final Class<T> clazz;
    private final Class<T[]> arrayClazz;

    @Autowired
    private ISportmonksRestService sportmonksRestService;
    @Autowired
    private IUriBuilder uriBuilder;

    @SuppressWarnings("unchecked")
    public GetByIdOrAllRestDataService(TypeContainerData<T> typeContainerData) {
        this.basePath = typeContainerData.getBasePath();
        byIdPath = typeContainerData.getBasePath() + "/{id}";
        this.clazz = typeContainerData.getClazz();
        this.arrayClazz = typeContainerData.getArrayClazz();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll() {
        UriComponents uriComponents = uriBuilder.getUriComponents(basePath);
        return sportmonksRestService.callForEntities(uriComponents.toUriString(), arrayClazz);
    }

    @Override
    public Optional<T> getById(long id) {
        UriComponents uriComponents = uriBuilder.getUriComponents(byIdPath);
        return sportmonksRestService.callForEntity(uriComponents.expand(id).toUriString(), clazz);
    }

    @SuppressWarnings("unchecked")
    private Class<T> getGenericClass() {
        String clazz = this.getClass().getGenericSuperclass().getTypeName();
        System.out.println("CLASS:" + clazz);
        Type[] actualTypeArguments = ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments();
        return (Class<T>) actualTypeArguments[0].getClass();
    }

    @SuppressWarnings("unchecked")

    private Class<T[]> getGenericArrayClass() {
        Type[] actualTypeArguments = ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments();
//        getGenericArrayClass
        Class<? extends Type[]> aClass = actualTypeArguments.getClass();
        return (Class<T[]>) getGenericClass();
    }
}
