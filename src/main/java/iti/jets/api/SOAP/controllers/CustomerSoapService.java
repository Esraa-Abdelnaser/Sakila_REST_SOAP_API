package iti.jets.api.SOAP.controllers;

import iti.jets.service.dtos.CustomerDto;
import iti.jets.service.impls.CustomerServicesImpl;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@WebService
public class CustomerSoapService {

    private CustomerServicesImpl customerServices = new CustomerServicesImpl();
    
    public Response getAll() {
        List<CustomerDto> listOfCustomerDto = customerServices.getAll();
        return Response.ok(listOfCustomerDto).build();
    }
    
    public Response getById(@WebParam(name="id") Integer id) {
        Optional<CustomerDto> optionalCustomer = Optional.ofNullable(customerServices.getById(id));

        if (optionalCustomer.isPresent()) {
            CustomerDto customerDto = optionalCustomer.get();
            return Response.ok(customerDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response insert(CustomerDto customerDto) {

        try {
            customerServices.insert(customerDto);
            return Response.ok("success").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }
    
    public Response update(CustomerDto customerDto) {
        Optional<CustomerDto> optionalCustomer = Optional.ofNullable(customerServices.getById(customerDto.getId()));

        if (optionalCustomer.isPresent()) {
            customerServices.update(customerDto);
            return Response.ok(customerDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    public Response delete(@WebParam(name="id") Integer id) {
        Optional<CustomerDto> optionalCustomer = Optional.ofNullable(customerServices.getById(id));
        if (optionalCustomer.isPresent()) {
            CustomerDto customerDto = customerServices.getById(id);
            customerServices.delete(customerDto);
        }
        return Response.noContent().build();
    }
}
