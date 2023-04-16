package iti.jets.service.impls;

import iti.jets.database.entities.Actor;
import iti.jets.database.entities.Language;
import iti.jets.database.repos.impls.ActorRepoImpl;
import iti.jets.database.repos.impls.LanguageRepoImpl;
import iti.jets.service.dtos.ActorDto;
import iti.jets.service.dtos.LanguageDto;
import iti.jets.service.interfaces.LanguageServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.ActorMapper;
import iti.jets.utils.mappers.LanguageMapper;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class LanguageServicesImpl implements LanguageServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    LanguageRepoImpl actorRepoImpl = new LanguageRepoImpl(entityManager);
    LanguageMapper mapper = LanguageMapper.INSTANCE;

    @Override
    public List<LanguageDto> getAll() {
        List<Language> listOfLanguage = actorRepoImpl.getAll();
        List<LanguageDto> listOfLanguageDto = new ArrayList<>();
        for (Language language : listOfLanguage) {
            listOfLanguageDto.add(mapper.toDto(language));
        }
        return listOfLanguageDto;
    }

    @Override
    public LanguageDto getById(Integer id) {
        return mapper.toDto(actorRepoImpl.getById(id));
    }

    @Override
    public void insert(LanguageDto languageDto) {
        actorRepoImpl.insert(mapper.toEntity(languageDto));
    }

    @Override
    public void update(LanguageDto languageDto) {
        actorRepoImpl.update(mapper.toEntity(languageDto));
    }

    @Override
    public void delete(LanguageDto languageDto) {
        actorRepoImpl.delete(mapper.toEntity(languageDto));
    }
}
