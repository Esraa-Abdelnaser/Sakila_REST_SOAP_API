package iti.jets.service.impls;

import iti.jets.database.entities.Actor;
import iti.jets.database.entities.Rental;
import iti.jets.database.repos.impls.ActorRepoImpl;
import iti.jets.database.repos.impls.RentalRepoImpl;
import iti.jets.service.dtos.ActorDto;
import iti.jets.service.dtos.RentalDto;
import iti.jets.service.interfaces.RentalServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.ActorMapper;
import iti.jets.utils.mappers.RentalMapper;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class RentalServicesImpl implements RentalServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    RentalRepoImpl actorRepoImpl = new RentalRepoImpl(entityManager);
    RentalMapper mapper = RentalMapper.INSTANCE;

    @Override
    public List<RentalDto> getAll() {
        List<Rental> listOfRental = actorRepoImpl.getAll();
        List<RentalDto> listOfRentalDto = new ArrayList<>();
        for (Rental rental : listOfRental) {
            listOfRentalDto.add(mapper.toDto(rental));
        }
        return listOfRentalDto;
    }

    @Override
    public RentalDto getById(Integer id) {
        return mapper.toDto(actorRepoImpl.getById(id));
    }

    @Override
    public void insert(RentalDto rentalDto) {
        actorRepoImpl.insert(mapper.toEntity(rentalDto));
    }

    @Override
    public void update(RentalDto rentalDto) {
        actorRepoImpl.update(mapper.toEntity(rentalDto));
    }

    @Override
    public void delete(RentalDto rentalDto) {
        actorRepoImpl.delete(mapper.toEntity(rentalDto));
    }
}
