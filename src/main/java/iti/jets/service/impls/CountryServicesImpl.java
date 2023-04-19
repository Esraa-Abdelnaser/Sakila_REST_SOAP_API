package iti.jets.service.impls;

import iti.jets.database.entities.Country;
import iti.jets.database.repos.impls.CountryRepoImpl;
import iti.jets.service.dtos.CountryDto;
import iti.jets.service.interfaces.CountryServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.CountryMapper;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CountryServicesImpl implements CountryServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    CountryRepoImpl countryRepo = new CountryRepoImpl(entityManager);
    CountryMapper mapper = CountryMapper.INSTANCE;

    @Override
    public List<CountryDto> getAll() {
        List<Country> listOfCountries = countryRepo.getAll();
        List<CountryDto> listOfCountryDto = new ArrayList<>();
        for (Country country : listOfCountries) {
            listOfCountryDto.add(mapper.toDto(country));
        }
        return listOfCountryDto;
    }

    @Override
    public CountryDto getById(Integer id) {
        return mapper.toDto(countryRepo.getById(id));
    }

    @Override
    public void insert(CountryDto countryDto) {
        countryDto.setLastUpdate(Instant.now());
        countryRepo.insert(mapper.toEntity(countryDto));
    }

    @Override
    public void update(CountryDto countryDto) {
        countryDto.setLastUpdate(Instant.now());
        countryRepo.update(mapper.toEntity(countryDto));
    }

    @Override
    public void delete(CountryDto countryDto) {

        countryRepo.delete(countryRepo.getById(countryDto.getId()));
    }
}
