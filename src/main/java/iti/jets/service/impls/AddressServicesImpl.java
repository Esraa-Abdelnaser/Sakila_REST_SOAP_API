package iti.jets.service.impls;

import iti.jets.database.entities.Address;
import iti.jets.database.repos.impls.AddressRepoImpl;
import iti.jets.service.dtos.AddressDto;
import iti.jets.service.interfaces.AddressServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.AddressMapper;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class AddressServicesImpl implements AddressServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    AddressRepoImpl addressRepo = new AddressRepoImpl(entityManager);
    AddressMapper mapper = AddressMapper.INSTANCE;

    @Override
    public List<AddressDto> getAll() {
        List<Address> listOfAddress = addressRepo.getAll();
        List<AddressDto> listOfAddressDto = new ArrayList<>();
        for (Address address : listOfAddress) {
            listOfAddressDto.add(mapper.toDto(address));
        }
        return listOfAddressDto;
    }

    @Override
    public AddressDto getById(Integer id) {
        return mapper.toDto(addressRepo.getById(id));
    }

    @Override
    public void insert(AddressDto addressDto) {
        addressDto.setLastUpdate(Instant.now());
        addressRepo.insert(mapper.toEntity(addressDto));
    }

    @Override
    public void update(AddressDto addressDto) {
        addressDto.setLastUpdate(Instant.now());
        addressRepo.update(mapper.toEntity(addressDto));
    }

    @Override
    public void delete(AddressDto addressDto) {

        addressRepo.delete(addressRepo.getById(addressDto.getId()));
    }
}
