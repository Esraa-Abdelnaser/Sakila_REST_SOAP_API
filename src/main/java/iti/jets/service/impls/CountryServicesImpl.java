package iti.jets.service.impls;

import iti.jets.database.entities.Actor;
import iti.jets.database.entities.Country;
import iti.jets.database.repos.impls.ActorRepoImpl;
import iti.jets.database.repos.impls.CountryRepoImpl;
import iti.jets.service.dtos.ActorDto;
import iti.jets.service.dtos.CountryDto;
import iti.jets.service.interfaces.CountryServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.ActorMapper;
import iti.jets.utils.mappers.CountryMapper;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class CountryServicesImpl implements CountryServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    CountryRepoImpl actorRepoImpl = new CountryRepoImpl(entityManager);
    CountryMapper mapper = CountryMapper.INSTANCE;

    @Override
    public List<CountryDto> getAll() {
        List<Country> listOfCountries = actorRepoImpl.getAll();
        List<CountryDto> listOfCountryDto = new ArrayList<>();
        for (Country country : listOfCountries) {
            listOfCountryDto.add(mapper.toDto(country));
        }
        return listOfCountryDto;
    }

    @Override
    public CountryDto getById(Integer id) {
        return mapper.toDto(actorRepoImpl.getById(id));
    }

    @Override
    public void insert(CountryDto countryDto) {
        actorRepoImpl.insert(mapper.toEntity(countryDto));
    }

    @Override
    public void update(CountryDto countryDto) {
        actorRepoImpl.update(mapper.toEntity(countryDto));
    }

    @Override
    public void delete(CountryDto countryDto) {
        actorRepoImpl.delete(mapper.toEntity(countryDto));
    }
}
