package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.CustomerDto;
import iti.jets.service.impls.CustomerServicesImpl;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.List;
import java.util.Optional;

@WebService
public class CustomerSoapService {

    private CustomerServicesImpl customerServices = new CustomerServicesImpl();

    @WebMethod
    public List<CustomerDto> getAllCustomers() {
        List<CustomerDto> listOfCustomerDto = customerServices.getAll();
        return listOfCustomerDto;
    }

    @WebMethod
    public CustomerDto getCustomerById(@WebParam(name = "id") Integer id) {
        Optional<CustomerDto> optionalCustomer = Optional.ofNullable(customerServices.getById(id));

        if (optionalCustomer.isPresent()) {
            CustomerDto customerDto = optionalCustomer.get();
            return customerDto;
        } else {
            return null;
        }
    }

    @WebMethod
    public String insertCustomer(CustomerDto customerDto) {

        try {
            customerServices.insert(customerDto);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @WebMethod
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        Optional<CustomerDto> optionalCustomer = Optional.ofNullable(customerServices.getById(customerDto.getId()));

        if (optionalCustomer.isPresent()) {
            customerServices.update(customerDto);
            return customerDto;
        } else {
            return null;
        }
    }

    @WebMethod
    public String deleteCustomer(@WebParam(name = "id") Integer id) {
        Optional<CustomerDto> optionalCustomer = Optional.ofNullable(customerServices.getById(id));
        try {
            if (optionalCustomer.isPresent()) {
                CustomerDto customerDto = customerServices.getById(id);
                customerServices.delete(customerDto);
                return "success";
            }
            return "failed";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
