package com.sportmonks.aggregate.rest.service.generic;

import com.sportmonks.aggregate.rest.service.ISportmonksRestService;
import com.sportmonks.aggregate.rest.service.builder.IUriBuilder;
import com.sportmonks.aggregate.rest.service.types.TypeContainerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponents;

import java.util.List;
import java.util.Optional;

public class GetByIdOrSeasonRestDataService<T> implements IGetByIdOrSeasonRestDataService<T> {

    private final String byIdPath;
    private final String bySeasonIdPath;
    private final Class<T> clazz;
    private final Class<T[]> arrayClazz;

    @Autowired
    private ISportmonksRestService sportmonksRestService;
    @Autowired
    private IUriBuilder uriBuilder;

    public GetByIdOrSeasonRestDataService(TypeContainerData<T> typeContainerData) {
        String basePath = typeContainerData.getBasePath();
        byIdPath = basePath + "/{id}";
        bySeasonIdPath = basePath + "/season/{id}";
        this.clazz = typeContainerData.getClazz();
        this.arrayClazz = typeContainerData.getArrayClazz();
    }

    @Override
    public List<T> getBySeasonId(long seasonId) {
        UriComponents uriComponents = uriBuilder.getUriComponents(bySeasonIdPath);
        return sportmonksRestService.callForEntities(uriComponents.expand(seasonId).toUriString(), arrayClazz);
    }

    @Override
    public Optional<T> getById(long id) {
        UriComponents uriComponents = uriBuilder.getUriComponents(byIdPath);
        return sportmonksRestService.callForEntity(uriComponents.expand(id).toUriString(), clazz);
    }
}
