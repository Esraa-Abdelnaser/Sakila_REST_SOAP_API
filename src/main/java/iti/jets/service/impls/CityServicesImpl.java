package iti.jets.service.impls;

import iti.jets.database.entities.Actor;
import iti.jets.database.entities.City;
import iti.jets.database.repos.impls.ActorRepoImpl;
import iti.jets.database.repos.impls.CityRepoImpl;
import iti.jets.service.dtos.ActorDto;
import iti.jets.service.dtos.CityDto;
import iti.jets.service.interfaces.CityServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.ActorMapper;
import iti.jets.utils.mappers.CityMapper;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class CityServicesImpl implements CityServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    CityRepoImpl actorRepoImpl = new CityRepoImpl(entityManager);
    CityMapper mapper = CityMapper.INSTANCE;

    @Override
    public List<CityDto> getAll() {
        List<City> listOfCity = actorRepoImpl.getAll();
        List<CityDto> listOfCityDto = new ArrayList<>();
        for (City city : listOfCity) {
            listOfCityDto.add(mapper.toDto(city));
        }
        return listOfCityDto;
    }

    @Override
    public CityDto getById(Integer id) {
        return mapper.toDto(actorRepoImpl.getById(id));
    }

    @Override
    public void insert(CityDto cityDto) {
        actorRepoImpl.insert(mapper.toEntity(cityDto));
    }

    @Override
    public void update(CityDto cityDto) {
        actorRepoImpl.update(mapper.toEntity(cityDto));
    }

    @Override
    public void delete(CityDto cityDto) {
        actorRepoImpl.delete(mapper.toEntity(cityDto));
    }
}
