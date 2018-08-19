package com.sportmonks.aggregate.rest.service.generic;

import com.sportmonks.aggregate.rest.service.ISportmonksRestService;
import com.sportmonks.aggregate.rest.service.builder.IUriBuilder;
import com.sportmonks.aggregate.rest.service.types.TypeContainerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponents;

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

    public GetByIdOrAllRestDataService(TypeContainerData<T> typeContainerData) {
        this.basePath = typeContainerData.getBasePath();
        byIdPath = typeContainerData.getBasePath() + "/{id}";
        this.clazz = typeContainerData.getClazz();
        this.arrayClazz = typeContainerData.getArrayClazz();
    }

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
}
