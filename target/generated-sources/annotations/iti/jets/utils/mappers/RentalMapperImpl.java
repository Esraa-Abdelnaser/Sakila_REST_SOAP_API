package iti.jets.utils.mappers;

import iti.jets.database.entities.Address;
import iti.jets.database.entities.City;
import iti.jets.database.entities.Customer;
import iti.jets.database.entities.Film;
import iti.jets.database.entities.Inventory;
import iti.jets.database.entities.Language;
import iti.jets.database.entities.Rental;
import iti.jets.database.entities.Staff;
import iti.jets.database.entities.Store;
import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.CustomerDto;
import iti.jets.service.dtos.FilmDto;
import iti.jets.service.dtos.InventoryDto;
import iti.jets.service.dtos.RentalDto;
import java.math.BigDecimal;
import java.time.Instant;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-15T23:16:51+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@ApplicationScoped
public class RentalMapperImpl implements RentalMapper {

    @Override
    public Rental toEntity(RentalDto rentalDto) {
        if ( rentalDto == null ) {
            return null;
        }

        Rental rental = new Rental();

        rental.setId( rentalDto.getId() );
        rental.setRentalDate( rentalDto.getRentalDate() );
        rental.setInventory( inventoryDtoToInventory( rentalDto.getInventory() ) );
        rental.setCustomer( customerDtoToCustomer( rentalDto.getCustomer() ) );
        rental.setReturnDate( rentalDto.getReturnDate() );
        rental.setStaff( rentalDto.getStaff() );
        rental.setLastUpdate( rentalDto.getLastUpdate() );

        return rental;
    }

    @Override
    public RentalDto toDto(Rental rental) {
        if ( rental == null ) {
            return null;
        }

        Integer id = null;
        Instant rentalDate = null;
        InventoryDto inventory = null;
        CustomerDto customer = null;
        Instant returnDate = null;
        Staff staff = null;
        Instant lastUpdate = null;

        id = rental.getId();
        rentalDate = rental.getRentalDate();
        inventory = inventoryToInventoryDto( rental.getInventory() );
        customer = customerToCustomerDto( rental.getCustomer() );
        returnDate = rental.getReturnDate();
        staff = rental.getStaff();
        lastUpdate = rental.getLastUpdate();

        RentalDto rentalDto = new RentalDto( id, rentalDate, inventory, customer, returnDate, staff, lastUpdate );

        return rentalDto;
    }

    @Override
    public Rental partialUpdate(RentalDto rentalDto, Rental rental) {
        if ( rentalDto == null ) {
            return null;
        }

        if ( rentalDto.getId() != null ) {
            rental.setId( rentalDto.getId() );
        }
        if ( rentalDto.getRentalDate() != null ) {
            rental.setRentalDate( rentalDto.getRentalDate() );
        }
        if ( rentalDto.getInventory() != null ) {
            if ( rental.getInventory() == null ) {
                rental.setInventory( new Inventory() );
            }
            inventoryDtoToInventory1( rentalDto.getInventory(), rental.getInventory() );
        }
        if ( rentalDto.getCustomer() != null ) {
            if ( rental.getCustomer() == null ) {
                rental.setCustomer( new Customer() );
            }
            customerDtoToCustomer1( rentalDto.getCustomer(), rental.getCustomer() );
        }
        if ( rentalDto.getReturnDate() != null ) {
            rental.setReturnDate( rentalDto.getReturnDate() );
        }
        if ( rentalDto.getStaff() != null ) {
            rental.setStaff( rentalDto.getStaff() );
        }
        if ( rentalDto.getLastUpdate() != null ) {
            rental.setLastUpdate( rentalDto.getLastUpdate() );
        }

        return rental;
    }

    protected Film filmDtoToFilm(FilmDto filmDto) {
        if ( filmDto == null ) {
            return null;
        }

        Film film = new Film();

        film.setId( filmDto.getId() );
        film.setTitle( filmDto.getTitle() );
        film.setDescription( filmDto.getDescription() );
        film.setReleaseYear( filmDto.getReleaseYear() );
        film.setLanguage( filmDto.getLanguage() );
        film.setOriginalLanguage( filmDto.getOriginalLanguage() );
        film.setRentalDuration( filmDto.getRentalDuration() );
        film.setRentalRate( filmDto.getRentalRate() );
        film.setLength( filmDto.getLength() );
        film.setReplacementCost( filmDto.getReplacementCost() );
        film.setRating( filmDto.getRating() );
        film.setSpecialFeatures( filmDto.getSpecialFeatures() );
        film.setLastUpdate( filmDto.getLastUpdate() );

        return film;
    }

    protected Inventory inventoryDtoToInventory(InventoryDto inventoryDto) {
        if ( inventoryDto == null ) {
            return null;
        }

        Inventory inventory = new Inventory();

        inventory.setId( inventoryDto.getId() );
        inventory.setFilm( filmDtoToFilm( inventoryDto.getFilm() ) );
        inventory.setStore( inventoryDto.getStore() );
        inventory.setLastUpdate( inventoryDto.getLastUpdate() );

        return inventory;
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

    protected Customer customerDtoToCustomer(CustomerDto customerDto) {
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

    protected FilmDto filmToFilmDto(Film film) {
        if ( film == null ) {
            return null;
        }

        Integer id = null;
        String title = null;
        String description = null;
        Integer releaseYear = null;
        Language language = null;
        Language originalLanguage = null;
        Short rentalDuration = null;
        BigDecimal rentalRate = null;
        Integer length = null;
        BigDecimal replacementCost = null;
        String rating = null;
        String specialFeatures = null;
        Instant lastUpdate = null;

        id = film.getId();
        title = film.getTitle();
        description = film.getDescription();
        releaseYear = film.getReleaseYear();
        language = film.getLanguage();
        originalLanguage = film.getOriginalLanguage();
        rentalDuration = film.getRentalDuration();
        rentalRate = film.getRentalRate();
        length = film.getLength();
        replacementCost = film.getReplacementCost();
        rating = film.getRating();
        specialFeatures = film.getSpecialFeatures();
        lastUpdate = film.getLastUpdate();

        FilmDto filmDto = new FilmDto( id, title, description, releaseYear, language, originalLanguage, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures, lastUpdate );

        return filmDto;
    }

    protected InventoryDto inventoryToInventoryDto(Inventory inventory) {
        if ( inventory == null ) {
            return null;
        }

        Integer id = null;
        FilmDto film = null;
        Store store = null;
        Instant lastUpdate = null;

        id = inventory.getId();
        film = filmToFilmDto( inventory.getFilm() );
        store = inventory.getStore();
        lastUpdate = inventory.getLastUpdate();

        InventoryDto inventoryDto = new InventoryDto( id, film, store, lastUpdate );

        return inventoryDto;
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

    protected CustomerDto customerToCustomerDto(Customer customer) {
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

    protected void filmDtoToFilm1(FilmDto filmDto, Film mappingTarget) {
        if ( filmDto == null ) {
            return;
        }

        if ( filmDto.getId() != null ) {
            mappingTarget.setId( filmDto.getId() );
        }
        if ( filmDto.getTitle() != null ) {
            mappingTarget.setTitle( filmDto.getTitle() );
        }
        if ( filmDto.getDescription() != null ) {
            mappingTarget.setDescription( filmDto.getDescription() );
        }
        if ( filmDto.getReleaseYear() != null ) {
            mappingTarget.setReleaseYear( filmDto.getReleaseYear() );
        }
        if ( filmDto.getLanguage() != null ) {
            mappingTarget.setLanguage( filmDto.getLanguage() );
        }
        if ( filmDto.getOriginalLanguage() != null ) {
            mappingTarget.setOriginalLanguage( filmDto.getOriginalLanguage() );
        }
        if ( filmDto.getRentalDuration() != null ) {
            mappingTarget.setRentalDuration( filmDto.getRentalDuration() );
        }
        if ( filmDto.getRentalRate() != null ) {
            mappingTarget.setRentalRate( filmDto.getRentalRate() );
        }
        if ( filmDto.getLength() != null ) {
            mappingTarget.setLength( filmDto.getLength() );
        }
        if ( filmDto.getReplacementCost() != null ) {
            mappingTarget.setReplacementCost( filmDto.getReplacementCost() );
        }
        if ( filmDto.getRating() != null ) {
            mappingTarget.setRating( filmDto.getRating() );
        }
        if ( filmDto.getSpecialFeatures() != null ) {
            mappingTarget.setSpecialFeatures( filmDto.getSpecialFeatures() );
        }
        if ( filmDto.getLastUpdate() != null ) {
            mappingTarget.setLastUpdate( filmDto.getLastUpdate() );
        }
    }

    protected void inventoryDtoToInventory1(InventoryDto inventoryDto, Inventory mappingTarget) {
        if ( inventoryDto == null ) {
            return;
        }

        if ( inventoryDto.getId() != null ) {
            mappingTarget.setId( inventoryDto.getId() );
        }
        if ( inventoryDto.getFilm() != null ) {
            if ( mappingTarget.getFilm() == null ) {
                mappingTarget.setFilm( new Film() );
            }
            filmDtoToFilm1( inventoryDto.getFilm(), mappingTarget.getFilm() );
        }
        if ( inventoryDto.getStore() != null ) {
            mappingTarget.setStore( inventoryDto.getStore() );
        }
        if ( inventoryDto.getLastUpdate() != null ) {
            mappingTarget.setLastUpdate( inventoryDto.getLastUpdate() );
        }
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

    protected void customerDtoToCustomer1(CustomerDto customerDto, Customer mappingTarget) {
        if ( customerDto == null ) {
            return;
        }

        if ( customerDto.getId() != null ) {
            mappingTarget.setId( customerDto.getId() );
        }
        if ( customerDto.getStore() != null ) {
            mappingTarget.setStore( customerDto.getStore() );
        }
        if ( customerDto.getFirstName() != null ) {
            mappingTarget.setFirstName( customerDto.getFirstName() );
        }
        if ( customerDto.getLastName() != null ) {
            mappingTarget.setLastName( customerDto.getLastName() );
        }
        if ( customerDto.getEmail() != null ) {
            mappingTarget.setEmail( customerDto.getEmail() );
        }
        if ( customerDto.getAddress() != null ) {
            if ( mappingTarget.getAddress() == null ) {
                mappingTarget.setAddress( new Address() );
            }
            addressDtoToAddress1( customerDto.getAddress(), mappingTarget.getAddress() );
        }
        if ( customerDto.getActive() != null ) {
            mappingTarget.setActive( customerDto.getActive() );
        }
        if ( customerDto.getCreateDate() != null ) {
            mappingTarget.setCreateDate( customerDto.getCreateDate() );
        }
        if ( customerDto.getLastUpdate() != null ) {
            mappingTarget.setLastUpdate( customerDto.getLastUpdate() );
        }
    }
}
