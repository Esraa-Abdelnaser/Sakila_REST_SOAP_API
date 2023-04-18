package iti.jets.service.impls;

import iti.jets.database.entities.Language;
import iti.jets.database.repos.impls.LanguageRepoImpl;
import iti.jets.service.dtos.LanguageDto;
import iti.jets.service.interfaces.LanguageServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.LanguageMapper;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class LanguageServicesImpl implements LanguageServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    LanguageRepoImpl languageRepo = new LanguageRepoImpl(entityManager);
    LanguageMapper mapper = LanguageMapper.INSTANCE;

    @Override
    public List<LanguageDto> getAll() {
        List<Language> listOfLanguage = languageRepo.getAll();
        List<LanguageDto> listOfLanguageDto = new ArrayList<>();
        for (Language language : listOfLanguage) {
            listOfLanguageDto.add(mapper.toDto(language));
        }
        return listOfLanguageDto;
    }

    @Override
    public LanguageDto getById(Integer id) {
        return mapper.toDto(languageRepo.getById(id));
    }

    @Override
    public void insert(LanguageDto languageDto) {
        languageRepo.insert(mapper.toEntity(languageDto));
    }

    @Override
    public void update(LanguageDto languageDto) {
        languageRepo.update(mapper.toEntity(languageDto));
    }

    @Override
    public void delete(LanguageDto languageDto) {

        languageRepo.delete(languageRepo.getById(languageDto.getId()));
    }
}
