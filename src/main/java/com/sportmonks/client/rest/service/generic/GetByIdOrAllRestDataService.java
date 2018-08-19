package com.sportmonks.client.rest.service.generic;

import com.sportmonks.client.rest.service.ISportmonksRestService;
import com.sportmonks.client.rest.service.builder.IUriBuilder;
import com.sportmonks.client.rest.service.types.TypeContainerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.UriComponents;

import java.util.List;
import java.util.Optional;

import static com.sportmonks.client.rest.service.constants.Constants.INCLUDES;

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
        return getAll("");
    }

    @Override
    public List<T> getAll(String includes) {
        UriComponents uriComponents = uriBuilder.getUriComponents(basePath, INCLUDES);
        return sportmonksRestService.callForEntities(uriComponents.expand(includes).toUriString(), arrayClazz);
    }

    @Override
    public Optional<T> getById(long id) {
        return getById(id, "");
    }

    @Override
    public Optional<T> getById(long id, String includes) {
        UriComponents uriComponents = uriBuilder.getUriComponents(byIdPath, INCLUDES);
        return sportmonksRestService.callForEntity(uriComponents.expand(id, includes).toUriString(), clazz);
    }
}
