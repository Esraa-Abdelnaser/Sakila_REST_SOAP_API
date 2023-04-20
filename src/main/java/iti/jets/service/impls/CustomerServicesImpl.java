package iti.jets.service.impls;

import iti.jets.database.entities.Customer;
import iti.jets.database.repos.impls.CustomerRepoImpl;
import iti.jets.service.dtos.CustomerDto;
import iti.jets.service.interfaces.CustomerServices;
import iti.jets.utils.SingletonEntityManager;
import iti.jets.utils.mappers.CustomerMapper;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class CustomerServicesImpl implements CustomerServices {

    EntityManager entityManager = SingletonEntityManager.getInstance().getEntityManager();
    CustomerRepoImpl customerRepo = new CustomerRepoImpl(entityManager);
    CustomerMapper mapper = CustomerMapper.INSTANCE;

    @Override
    public List<CustomerDto> getAll() {
        List<Customer> listOfCustomers = customerRepo.getAll();
        List<CustomerDto> listOfCustomerDto = new ArrayList<>();
        for (Customer customer : listOfCustomers) {
            listOfCustomerDto.add(mapper.toDto(customer));
        }
        return listOfCustomerDto;
    }

    @Override
    public CustomerDto getById(Integer id) {
        return mapper.toDto(customerRepo.getById(id));
    }

    @Override
    public void insert(CustomerDto customerDto) {
        customerDto.setLastUpdate(Instant.now());
        customerDto.setCreateDate(Instant.now());
        customerRepo.insert(mapper.toEntity(customerDto));
    }

    @Override
    public void update(CustomerDto customerDto) {
        customerDto.setLastUpdate(Instant.now());
        customerDto.setCreateDate(Instant.now());
        customerRepo.update(mapper.toEntity(customerDto));
    }

    @Override
    public void delete(CustomerDto customerDto) {

        customerRepo.delete(customerRepo.getById(customerDto.getId()));
    }
}
