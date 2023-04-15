package iti.jets.utils.mappers;

import iti.jets.database.entities.Address;
import iti.jets.database.entities.City;
import iti.jets.database.entities.Customer;
import iti.jets.database.entities.Store;
import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.CustomerDto;
import java.time.Instant;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-15T23:16:50+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@ApplicationScoped
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toEntity(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDto.getId() );
        customer.setStore( customerDto.getStore() );
        customer.setFirstName( customerDto.getFirstName() );
        customer.setLastName( customerDto.getLastName() );
        customer.setEmail( customerDto.getEmail() );
        customer.setAddress( addressDtoToAddress( customerDto.getAddress() ) );
        customer.setActive( customerDto.getActive() );
        customer.setCreateDate( customerDto.getCreateDate() );
        customer.setLastUpdate( customerDto.getLastUpdate() );

        return customer;
    }

    @Override
    public CustomerDto toDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        Integer id = null;
        Store store = null;
        String firstName = null;
        String lastName = null;
        String email = null;
        AddressDto address = null;
        Boolean active = null;
        Instant createDate = null;
        Instant lastUpdate = null;

        id = customer.getId();
        store = customer.getStore();
        firstName = customer.getFirstName();
        lastName = customer.getLastName();
        email = customer.getEmail();
        address = addressToAddressDto( customer.getAddress() );
        active = customer.getActive();
        createDate = customer.getCreateDate();
        lastUpdate = customer.getLastUpdate();

        CustomerDto customerDto = new CustomerDto( id, store, firstName, lastName, email, address, active, createDate, lastUpdate );

        return customerDto;
    }

    @Override
    public Customer partialUpdate(CustomerDto customerDto, Customer customer) {
        if ( customerDto == null ) {
            return null;
        }

        if ( customerDto.getId() != null ) {
            customer.setId( customerDto.getId() );
        }
        if ( customerDto.getStore() != null ) {
            customer.setStore( customerDto.getStore() );
        }
        if ( customerDto.getFirstName() != null ) {
            customer.setFirstName( customerDto.getFirstName() );
        }
        if ( customerDto.getLastName() != null ) {
            customer.setLastName( customerDto.getLastName() );
        }
        if ( customerDto.getEmail() != null ) {
            customer.setEmail( customerDto.getEmail() );
        }
        if ( customerDto.getAddress() != null ) {
            if ( customer.getAddress() == null ) {
                customer.setAddress( new Address() );
            }
            addressDtoToAddress1( customerDto.getAddress(), customer.getAddress() );
        }
        if ( customerDto.getActive() != null ) {
            customer.setActive( customerDto.getActive() );
        }
        if ( customerDto.getCreateDate() != null ) {
            customer.setCreateDate( customerDto.getCreateDate() );
        }
        if ( customerDto.getLastUpdate() != null ) {
            customer.setLastUpdate( customerDto.getLastUpdate() );
        }

        return customer;
    }

    protected Address addressDtoToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDto.getId() );
        address.setAddress( addressDto.getAddress() );
        address.setAddress2( addressDto.getAddress2() );
        address.setDistrict( addressDto.getDistrict() );
        address.setCity( addressDto.getCity() );
        address.setPostalCode( addressDto.getPostalCode() );
        address.setPhone( addressDto.getPhone() );
        address.setLastUpdate( addressDto.getLastUpdate() );

        return address;
    }

    protected AddressDto addressToAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        Integer id = null;
        String address1 = null;
        String address2 = null;
        String district = null;
        City city = null;
        String postalCode = null;
        String phone = null;
        Instant lastUpdate = null;

        id = address.getId();
        address1 = address.getAddress();
        address2 = address.getAddress2();
        district = address.getDistrict();
        city = address.getCity();
        postalCode = address.getPostalCode();
        phone = address.getPhone();
        lastUpdate = address.getLastUpdate();

        AddressDto addressDto = new AddressDto( id, address1, address2, district, city, postalCode, phone, lastUpdate );

        return addressDto;
    }

    protected void addressDtoToAddress1(AddressDto addressDto, Address mappingTarget) {
        if ( addressDto == null ) {
            return;
        }

        if ( addressDto.getId() != null ) {
            mappingTarget.setId( addressDto.getId() );
        }
        if ( addressDto.getAddress() != null ) {
            mappingTarget.setAddress( addressDto.getAddress() );
        }
        if ( addressDto.getAddress2() != null ) {
            mappingTarget.setAddress2( addressDto.getAddress2() );
        }
        if ( addressDto.getDistrict() != null ) {
            mappingTarget.setDistrict( addressDto.getDistrict() );
        }
        if ( addressDto.getCity() != null ) {
            mappingTarget.setCity( addressDto.getCity() );
        }
        if ( addressDto.getPostalCode() != null ) {
            mappingTarget.setPostalCode( addressDto.getPostalCode() );
        }
        if ( addressDto.getPhone() != null ) {
            mappingTarget.setPhone( addressDto.getPhone() );
        }
        if ( addressDto.getLastUpdate() != null ) {
            mappingTarget.setLastUpdate( addressDto.getLastUpdate() );
        }
    }
}
