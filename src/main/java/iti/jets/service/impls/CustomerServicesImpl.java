package iti.jets.service.impls;

import iti.jets.database.entities.Actor;
import iti.jets.database.entities.Customer;
import iti.jets.database.repos.impls.ActorRepoImpl;
import iti.jets.database.repos.impls.CustomerRepoImpl;
import iti.jets.service.dtos.ActorDto;
import iti.jets.service.dtos.CustomerDto;
import iti.jets.service.interfaces.CustomerServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.ActorMapper;
import iti.jets.utils.mappers.CustomerMapper;
import jakarta.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

public class CustomerServicesImpl implements CustomerServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    CustomerRepoImpl actorRepoImpl = new CustomerRepoImpl(entityManager);
    CustomerMapper mapper = CustomerMapper.INSTANCE;

    @Override
    public List<CustomerDto> getAll() {
        List<Customer> listOfCustomers = actorRepoImpl.getAll();
        List<CustomerDto> listOfCustomerDto = new ArrayList<>();
        for (Customer customer : listOfCustomers) {
            listOfCustomerDto.add(mapper.toDto(customer));
        }
        return listOfCustomerDto;
    }

    @Override
    public CustomerDto getById(Integer id) {
        return mapper.toDto(actorRepoImpl.getById(id));
    }

    @Override
    public void insert(CustomerDto customerDto) {
        actorRepoImpl.insert(mapper.toEntity(customerDto));
    }

    @Override
    public void update(CustomerDto customerDto) {
        actorRepoImpl.update(mapper.toEntity(customerDto));
    }

    @Override
    public void delete(CustomerDto customerDto) {
        actorRepoImpl.delete(mapper.toEntity(customerDto));
    }
}
