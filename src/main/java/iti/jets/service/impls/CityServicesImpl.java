package iti.jets.service.impls;

import iti.jets.database.entities.City;
import iti.jets.database.repos.impls.CityRepoImpl;
import iti.jets.service.dtos.CityDto;
import iti.jets.service.interfaces.CityServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.CityMapper;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CityServicesImpl implements CityServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    CityRepoImpl cityRepo = new CityRepoImpl(entityManager);
    CityMapper mapper = CityMapper.INSTANCE;

    @Override
    public List<CityDto> getAll() {
        List<City> listOfCity = cityRepo.getAll();
        List<CityDto> listOfCityDto = new ArrayList<>();
        for (City city : listOfCity) {
            listOfCityDto.add(mapper.toDto(city));
        }
        return listOfCityDto;
    }

    @Override
    public CityDto getById(Integer id) {
        return mapper.toDto(cityRepo.getById(id));
    }

    @Override
    public void insert(CityDto cityDto) {
        cityDto.setLastUpdate(Instant.now());
        cityRepo.insert(mapper.toEntity(cityDto));
    }

    @Override
    public void update(CityDto cityDto) {
        cityDto.setLastUpdate(Instant.now());
        cityRepo.update(mapper.toEntity(cityDto));
    }

    @Override
    public void delete(CityDto cityDto) {

        cityRepo.delete(cityRepo.getById(cityDto.getId()));
    }
}
