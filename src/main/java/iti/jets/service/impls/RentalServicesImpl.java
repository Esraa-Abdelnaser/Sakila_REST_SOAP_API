package iti.jets.service.impls;

import iti.jets.database.entities.Rental;
import iti.jets.database.repos.impls.RentalRepoImpl;
import iti.jets.service.dtos.RentalDto;
import iti.jets.service.interfaces.RentalServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.RentalMapper;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class RentalServicesImpl implements RentalServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    RentalRepoImpl rentalRepo = new RentalRepoImpl(entityManager);
    RentalMapper mapper = RentalMapper.INSTANCE;

    @Override
    public List<RentalDto> getAll() {
        List<Rental> listOfRental = rentalRepo.getAll();
        List<RentalDto> listOfRentalDto = new ArrayList<>();
        for (int i = 0; i < listOfRental.size() && i < 50; i++) {
            listOfRentalDto.add(mapper.toDto(listOfRental.get(i)));
        }
        return listOfRentalDto;
    }

    @Override
    public RentalDto getById(Integer id) {
        return mapper.toDto(rentalRepo.getById(id));
    }

    @Override
    public void insert(RentalDto rentalDto) {
        rentalDto.setLastUpdate(Instant.now());
        rentalDto.setRentalDate(Instant.now());
        rentalDto.setReturnDate(Instant.now());
        rentalRepo.insert(mapper.toEntity(rentalDto));
    }

    @Override
    public void update(RentalDto rentalDto) {
        rentalDto.setLastUpdate(Instant.now());
        rentalDto.setRentalDate(Instant.now());
        rentalDto.setReturnDate(Instant.now());
        rentalRepo.update(mapper.toEntity(rentalDto));
    }

    @Override
    public void delete(RentalDto rentalDto) {

        rentalRepo.delete(rentalRepo.getById(rentalDto.getId()));
    }
}
