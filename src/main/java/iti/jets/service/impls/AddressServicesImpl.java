package iti.jets.service.impls;

import iti.jets.database.entities.Actor;
import iti.jets.database.entities.Address;
import iti.jets.database.repos.impls.ActorRepoImpl;
import iti.jets.database.repos.impls.AddressRepoImpl;
import iti.jets.service.dtos.ActorDto;
import iti.jets.service.dtos.AddressDto;
import iti.jets.service.interfaces.AddressServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.ActorMapper;
import iti.jets.utils.mappers.AddressMapper;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class AddressServicesImpl implements AddressServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    AddressRepoImpl actorRepoImpl = new AddressRepoImpl(entityManager);
    AddressMapper mapper = AddressMapper.INSTANCE;

    @Override
    public List<AddressDto> getAll() {
        List<Address> listOfAddress = actorRepoImpl.getAll();
        List<AddressDto> listOfAddressDto = new ArrayList<>();
        for (Address address : listOfAddress) {
            listOfAddressDto.add(mapper.toDto(address));
        }
        return listOfAddressDto;
    }

    @Override
    public AddressDto getById(Integer id) {
        return mapper.toDto(actorRepoImpl.getById(id));
    }

    @Override
    public void insert(AddressDto addressDto) {
        actorRepoImpl.insert(mapper.toEntity(addressDto));
    }

    @Override
    public void update(AddressDto addressDto) {
        actorRepoImpl.update(mapper.toEntity(addressDto));
    }

    @Override
    public void delete(AddressDto addressDto) {
        actorRepoImpl.delete(mapper.toEntity(addressDto));
    }
}
