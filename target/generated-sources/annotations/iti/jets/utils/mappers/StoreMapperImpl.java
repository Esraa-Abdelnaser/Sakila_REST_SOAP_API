package iti.jets.utils.mappers;

import iti.jets.database.entities.Address;
import iti.jets.database.entities.City;
import iti.jets.database.entities.Staff;
import iti.jets.database.entities.Store;
import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.StaffDto;
import iti.jets.service.dtos.StoreDto;
import java.time.Instant;
import java.util.Arrays;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-15T23:16:51+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@ApplicationScoped
public class StoreMapperImpl implements StoreMapper {

    @Override
    public Store toEntity(StoreDto storeDto) {
        if ( storeDto == null ) {
            return null;
        }

        Store store = new Store();

        store.setId( storeDto.getId() );
        store.setManagerStaff( staffDtoToStaff( storeDto.getManagerStaff() ) );
        store.setAddress( addressDtoToAddress( storeDto.getAddress() ) );
        store.setLastUpdate( storeDto.getLastUpdate() );

        return store;
    }

    @Override
    public StoreDto toDto(Store store) {
        if ( store == null ) {
            return null;
        }

        Short id = null;
        StaffDto managerStaff = null;
        AddressDto address = null;
        Instant lastUpdate = null;

        id = store.getId();
        managerStaff = staffToStaffDto( store.getManagerStaff() );
        address = addressToAddressDto( store.getAddress() );
        lastUpdate = store.getLastUpdate();

        StoreDto storeDto = new StoreDto( id, managerStaff, address, lastUpdate );

        return storeDto;
    }

    @Override
    public Store partialUpdate(StoreDto storeDto, Store store) {
        if ( storeDto == null ) {
            return null;
        }

        if ( storeDto.getId() != null ) {
            store.setId( storeDto.getId() );
        }
        if ( storeDto.getManagerStaff() != null ) {
            if ( store.getManagerStaff() == null ) {
                store.setManagerStaff( new Staff() );
            }
            staffDtoToStaff1( storeDto.getManagerStaff(), store.getManagerStaff() );
        }
        if ( storeDto.getAddress() != null ) {
            if ( store.getAddress() == null ) {
                store.setAddress( new Address() );
            }
            addressDtoToAddress1( storeDto.getAddress(), store.getAddress() );
        }
        if ( storeDto.getLastUpdate() != null ) {
            store.setLastUpdate( storeDto.getLastUpdate() );
        }

        return store;
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

    protected Staff staffDtoToStaff(StaffDto staffDto) {
        if ( staffDto == null ) {
            return null;
        }

        Staff staff = new Staff();

        staff.setId( staffDto.getId() );
        staff.setFirstName( staffDto.getFirstName() );
        staff.setLastName( staffDto.getLastName() );
        staff.setAddress( addressDtoToAddress( staffDto.getAddress() ) );
        byte[] picture = staffDto.getPicture();
        if ( picture != null ) {
            staff.setPicture( Arrays.copyOf( picture, picture.length ) );
        }
        staff.setEmail( staffDto.getEmail() );
        staff.setStore( staffDto.getStore() );
        staff.setActive( staffDto.getActive() );
        staff.setUsername( staffDto.getUsername() );
        staff.setPassword( staffDto.getPassword() );
        staff.setLastUpdate( staffDto.getLastUpdate() );

        return staff;
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

    protected StaffDto staffToStaffDto(Staff staff) {
        if ( staff == null ) {
            return null;
        }

        Short id = null;
        String firstName = null;
        String lastName = null;
        AddressDto address = null;
        byte[] picture = null;
        String email = null;
        Store store = null;
        Boolean active = null;
        String username = null;
        String password = null;
        Instant lastUpdate = null;

        id = staff.getId();
        firstName = staff.getFirstName();
        lastName = staff.getLastName();
        address = addressToAddressDto( staff.getAddress() );
        byte[] picture1 = staff.getPicture();
        if ( picture1 != null ) {
            picture = Arrays.copyOf( picture1, picture1.length );
        }
        email = staff.getEmail();
        store = staff.getStore();
        active = staff.getActive();
        username = staff.getUsername();
        password = staff.getPassword();
        lastUpdate = staff.getLastUpdate();

        StaffDto staffDto = new StaffDto( id, firstName, lastName, address, picture, email, store, active, username, password, lastUpdate );

        return staffDto;
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

    protected void staffDtoToStaff1(StaffDto staffDto, Staff mappingTarget) {
        if ( staffDto == null ) {
            return;
        }

        if ( staffDto.getId() != null ) {
            mappingTarget.setId( staffDto.getId() );
        }
        if ( staffDto.getFirstName() != null ) {
            mappingTarget.setFirstName( staffDto.getFirstName() );
        }
        if ( staffDto.getLastName() != null ) {
            mappingTarget.setLastName( staffDto.getLastName() );
        }
        if ( staffDto.getAddress() != null ) {
            if ( mappingTarget.getAddress() == null ) {
                mappingTarget.setAddress( new Address() );
            }
            addressDtoToAddress1( staffDto.getAddress(), mappingTarget.getAddress() );
        }
        byte[] picture = staffDto.getPicture();
        if ( picture != null ) {
            mappingTarget.setPicture( Arrays.copyOf( picture, picture.length ) );
        }
        if ( staffDto.getEmail() != null ) {
            mappingTarget.setEmail( staffDto.getEmail() );
        }
        if ( staffDto.getStore() != null ) {
            mappingTarget.setStore( staffDto.getStore() );
        }
        if ( staffDto.getActive() != null ) {
            mappingTarget.setActive( staffDto.getActive() );
        }
        if ( staffDto.getUsername() != null ) {
            mappingTarget.setUsername( staffDto.getUsername() );
        }
        if ( staffDto.getPassword() != null ) {
            mappingTarget.setPassword( staffDto.getPassword() );
        }
        if ( staffDto.getLastUpdate() != null ) {
            mappingTarget.setLastUpdate( staffDto.getLastUpdate() );
        }
    }
}
