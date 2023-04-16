package iti.jets.utils.mappers;

import iti.jets.database.entities.Actor;
import iti.jets.database.entities.Address;
import iti.jets.database.entities.Category;
import iti.jets.database.entities.City;
import iti.jets.database.entities.Country;
import iti.jets.database.entities.Customer;
import iti.jets.database.entities.Film;
import iti.jets.database.entities.FilmActor;
import iti.jets.database.entities.FilmCategory;
import iti.jets.database.entities.Inventory;
import iti.jets.database.entities.Language;
import iti.jets.database.entities.Payment;
import iti.jets.database.entities.Rental;
import iti.jets.database.entities.Staff;
import iti.jets.database.entities.Store;
import iti.jets.service.dtos.ActorDto;
import iti.jets.service.dtos.AddressDto;
import iti.jets.service.dtos.CategoryDto;
import iti.jets.service.dtos.CityDto;
import iti.jets.service.dtos.CountryDto;
import iti.jets.service.dtos.CustomerDto;
import iti.jets.service.dtos.FilmActorDto;
import iti.jets.service.dtos.FilmCategoryDto;
import iti.jets.service.dtos.FilmDto;
import iti.jets.service.dtos.InventoryDto;
import iti.jets.service.dtos.LanguageDto;
import iti.jets.service.dtos.PaymentDto;
import iti.jets.service.dtos.RentalDto;
import iti.jets.service.dtos.StaffDto;
import iti.jets.service.dtos.StoreDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-17T01:38:03+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
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
        rental.setStaff( staffDtoToStaff( rentalDto.getStaff() ) );
        rental.setLastUpdate( rentalDto.getLastUpdate() );
        rental.setPaymentList( paymentDtoListToPaymentList( rentalDto.getPaymentList() ) );

        return rental;
    }

    @Override
    public RentalDto toDto(Rental rental) {
        if ( rental == null ) {
            return null;
        }

        RentalDto rentalDto = new RentalDto();

        rentalDto.setId( rental.getId() );
        rentalDto.setRentalDate( rental.getRentalDate() );
        rentalDto.setInventory( inventoryToInventoryDto( rental.getInventory() ) );
        rentalDto.setCustomer( customerToCustomerDto( rental.getCustomer() ) );
        rentalDto.setReturnDate( rental.getReturnDate() );
        rentalDto.setStaff( staffToStaffDto( rental.getStaff() ) );
        rentalDto.setLastUpdate( rental.getLastUpdate() );
        rentalDto.setPaymentList( paymentListToPaymentDtoList( rental.getPaymentList() ) );

        return rentalDto;
    }

    @Override
    public Rental partialUpdate(RentalDto rentalDto, Rental rental) {
        if ( rentalDto == null ) {
            return rental;
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
            if ( rental.getStaff() == null ) {
                rental.setStaff( new Staff() );
            }
            staffDtoToStaff1( rentalDto.getStaff(), rental.getStaff() );
        }
        if ( rentalDto.getLastUpdate() != null ) {
            rental.setLastUpdate( rentalDto.getLastUpdate() );
        }
        if ( rental.getPaymentList() != null ) {
            List<Payment> list = paymentDtoListToPaymentList( rentalDto.getPaymentList() );
            if ( list != null ) {
                rental.getPaymentList().clear();
                rental.getPaymentList().addAll( list );
            }
        }
        else {
            List<Payment> list = paymentDtoListToPaymentList( rentalDto.getPaymentList() );
            if ( list != null ) {
                rental.setPaymentList( list );
            }
        }

        return rental;
    }

    protected List<Film> filmDtoListToFilmList(List<FilmDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Film> list1 = new ArrayList<Film>( list.size() );
        for ( FilmDto filmDto : list ) {
            list1.add( filmDtoToFilm( filmDto ) );
        }

        return list1;
    }

    protected Language languageDtoToLanguage(LanguageDto languageDto) {
        if ( languageDto == null ) {
            return null;
        }

        Language language = new Language();

        language.setId( languageDto.getId() );
        language.setName( languageDto.getName() );
        language.setLastUpdate( languageDto.getLastUpdate() );
        language.setFilmList( filmDtoListToFilmList( languageDto.getFilmList() ) );

        return language;
    }

    protected List<FilmCategory> filmCategoryDtoListToFilmCategoryList(List<FilmCategoryDto> list) {
        if ( list == null ) {
            return null;
        }

        List<FilmCategory> list1 = new ArrayList<FilmCategory>( list.size() );
        for ( FilmCategoryDto filmCategoryDto : list ) {
            list1.add( filmCategoryDtoToFilmCategory( filmCategoryDto ) );
        }

        return list1;
    }

    protected Category categoryDtoToCategory(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDto.getId() );
        category.setName( categoryDto.getName() );
        category.setLastUpdate( categoryDto.getLastUpdate() );
        category.setFilmCategoryList( filmCategoryDtoListToFilmCategoryList( categoryDto.getFilmCategoryList() ) );

        return category;
    }

    protected FilmCategory filmCategoryDtoToFilmCategory(FilmCategoryDto filmCategoryDto) {
        if ( filmCategoryDto == null ) {
            return null;
        }

        FilmCategory filmCategory = new FilmCategory();

        filmCategory.setId( filmCategoryDto.getId() );
        filmCategory.setFilm( filmDtoToFilm( filmCategoryDto.getFilm() ) );
        filmCategory.setCategory( categoryDtoToCategory( filmCategoryDto.getCategory() ) );
        filmCategory.setLastUpdate( filmCategoryDto.getLastUpdate() );

        return filmCategory;
    }

    protected List<FilmActor> filmActorDtoListToFilmActorList(List<FilmActorDto> list) {
        if ( list == null ) {
            return null;
        }

        List<FilmActor> list1 = new ArrayList<FilmActor>( list.size() );
        for ( FilmActorDto filmActorDto : list ) {
            list1.add( filmActorDtoToFilmActor( filmActorDto ) );
        }

        return list1;
    }

    protected Actor actorDtoToActor(ActorDto actorDto) {
        if ( actorDto == null ) {
            return null;
        }

        Actor actor = new Actor();

        actor.setId( actorDto.getId() );
        actor.setFirstName( actorDto.getFirstName() );
        actor.setLastName( actorDto.getLastName() );
        actor.setLastUpdate( actorDto.getLastUpdate() );
        actor.setFilmActorList( filmActorDtoListToFilmActorList( actorDto.getFilmActorList() ) );

        return actor;
    }

    protected FilmActor filmActorDtoToFilmActor(FilmActorDto filmActorDto) {
        if ( filmActorDto == null ) {
            return null;
        }

        FilmActor filmActor = new FilmActor();

        filmActor.setId( filmActorDto.getId() );
        filmActor.setActor( actorDtoToActor( filmActorDto.getActor() ) );
        filmActor.setFilm( filmDtoToFilm( filmActorDto.getFilm() ) );
        filmActor.setLastUpdate( filmActorDto.getLastUpdate() );

        return filmActor;
    }

    protected List<Inventory> inventoryDtoListToInventoryList(List<InventoryDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Inventory> list1 = new ArrayList<Inventory>( list.size() );
        for ( InventoryDto inventoryDto : list ) {
            list1.add( inventoryDtoToInventory( inventoryDto ) );
        }

        return list1;
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
        film.setLanguage( languageDtoToLanguage( filmDto.getLanguage() ) );
        film.setOriginalLanguage( languageDtoToLanguage( filmDto.getOriginalLanguage() ) );
        film.setRentalDuration( filmDto.getRentalDuration() );
        film.setRentalRate( filmDto.getRentalRate() );
        film.setLength( filmDto.getLength() );
        film.setReplacementCost( filmDto.getReplacementCost() );
        film.setRating( filmDto.getRating() );
        film.setSpecialFeatures( filmDto.getSpecialFeatures() );
        film.setLastUpdate( filmDto.getLastUpdate() );
        film.setFilmCategoryList( filmCategoryDtoListToFilmCategoryList( filmDto.getFilmCategoryList() ) );
        film.setFilmActorList( filmActorDtoListToFilmActorList( filmDto.getFilmActorList() ) );
        film.setInventoryList( inventoryDtoListToInventoryList( filmDto.getInventoryList() ) );

        return film;
    }

    protected List<City> cityDtoListToCityList(List<CityDto> list) {
        if ( list == null ) {
            return null;
        }

        List<City> list1 = new ArrayList<City>( list.size() );
        for ( CityDto cityDto : list ) {
            list1.add( cityDtoToCity( cityDto ) );
        }

        return list1;
    }

    protected Country countryDtoToCountry(CountryDto countryDto) {
        if ( countryDto == null ) {
            return null;
        }

        Country country = new Country();

        country.setId( countryDto.getId() );
        country.setCountry( countryDto.getCountry() );
        country.setLastUpdate( countryDto.getLastUpdate() );
        country.setCityList( cityDtoListToCityList( countryDto.getCityList() ) );

        return country;
    }

    protected List<Address> addressDtoListToAddressList(List<AddressDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Address> list1 = new ArrayList<Address>( list.size() );
        for ( AddressDto addressDto : list ) {
            list1.add( addressDtoToAddress( addressDto ) );
        }

        return list1;
    }

    protected City cityDtoToCity(CityDto cityDto) {
        if ( cityDto == null ) {
            return null;
        }

        City city = new City();

        city.setId( cityDto.getId() );
        city.setCity( cityDto.getCity() );
        city.setCountry( countryDtoToCountry( cityDto.getCountry() ) );
        city.setLastUpdate( cityDto.getLastUpdate() );
        city.setAddressList( addressDtoListToAddressList( cityDto.getAddressList() ) );

        return city;
    }

    protected List<Staff> staffDtoListToStaffList(List<StaffDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Staff> list1 = new ArrayList<Staff>( list.size() );
        for ( StaffDto staffDto : list ) {
            list1.add( staffDtoToStaff( staffDto ) );
        }

        return list1;
    }

    protected List<Store> storeDtoListToStoreList(List<StoreDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Store> list1 = new ArrayList<Store>( list.size() );
        for ( StoreDto storeDto : list ) {
            list1.add( storeDtoToStore( storeDto ) );
        }

        return list1;
    }

    protected List<Rental> rentalDtoListToRentalList(List<RentalDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Rental> list1 = new ArrayList<Rental>( list.size() );
        for ( RentalDto rentalDto : list ) {
            list1.add( toEntity( rentalDto ) );
        }

        return list1;
    }

    protected Payment paymentDtoToPayment(PaymentDto paymentDto) {
        if ( paymentDto == null ) {
            return null;
        }

        Payment payment = new Payment();

        payment.setId( paymentDto.getId() );
        payment.setCustomer( customerDtoToCustomer( paymentDto.getCustomer() ) );
        payment.setStaff( staffDtoToStaff( paymentDto.getStaff() ) );
        payment.setRental( toEntity( paymentDto.getRental() ) );
        payment.setAmount( paymentDto.getAmount() );
        payment.setPaymentDate( paymentDto.getPaymentDate() );
        payment.setLastUpdate( paymentDto.getLastUpdate() );

        return payment;
    }

    protected List<Payment> paymentDtoListToPaymentList(List<PaymentDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Payment> list1 = new ArrayList<Payment>( list.size() );
        for ( PaymentDto paymentDto : list ) {
            list1.add( paymentDtoToPayment( paymentDto ) );
        }

        return list1;
    }

    protected Customer customerDtoToCustomer(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDto.getId() );
        customer.setStore( storeDtoToStore( customerDto.getStore() ) );
        customer.setFirstName( customerDto.getFirstName() );
        customer.setLastName( customerDto.getLastName() );
        customer.setEmail( customerDto.getEmail() );
        customer.setAddress( addressDtoToAddress( customerDto.getAddress() ) );
        customer.setActive( customerDto.getActive() );
        customer.setCreateDate( customerDto.getCreateDate() );
        customer.setRentalList( rentalDtoListToRentalList( customerDto.getRentalList() ) );
        customer.setPaymentList( paymentDtoListToPaymentList( customerDto.getPaymentList() ) );
        customer.setLastUpdate( customerDto.getLastUpdate() );

        return customer;
    }

    protected List<Customer> customerDtoListToCustomerList(List<CustomerDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Customer> list1 = new ArrayList<Customer>( list.size() );
        for ( CustomerDto customerDto : list ) {
            list1.add( customerDtoToCustomer( customerDto ) );
        }

        return list1;
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
        address.setPostalCode( addressDto.getPostalCode() );
        address.setPhone( addressDto.getPhone() );
        address.setLastUpdate( addressDto.getLastUpdate() );
        byte[] location = addressDto.getLocation();
        if ( location != null ) {
            address.setLocation( Arrays.copyOf( location, location.length ) );
        }
        address.setCity( cityDtoToCity( addressDto.getCity() ) );
        address.setStaffList( staffDtoListToStaffList( addressDto.getStaffList() ) );
        address.setStoreList( storeDtoListToStoreList( addressDto.getStoreList() ) );
        address.setCustomerList( customerDtoListToCustomerList( addressDto.getCustomerList() ) );

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
        staff.setStore( storeDtoToStore( staffDto.getStore() ) );
        staff.setActive( staffDto.getActive() );
        staff.setUsername( staffDto.getUsername() );
        staff.setPassword( staffDto.getPassword() );
        staff.setLastUpdate( staffDto.getLastUpdate() );
        staff.setRentalList( rentalDtoListToRentalList( staffDto.getRentalList() ) );
        staff.setPaymentList( paymentDtoListToPaymentList( staffDto.getPaymentList() ) );

        return staff;
    }

    protected Store storeDtoToStore(StoreDto storeDto) {
        if ( storeDto == null ) {
            return null;
        }

        Store store = new Store();

        store.setId( storeDto.getId() );
        store.setManagerStaff( staffDtoToStaff( storeDto.getManagerStaff() ) );
        store.setAddress( addressDtoToAddress( storeDto.getAddress() ) );
        store.setLastUpdate( storeDto.getLastUpdate() );
        store.setStaffList( staffDtoListToStaffList( storeDto.getStaffList() ) );
        store.setInventoryList( inventoryDtoListToInventoryList( storeDto.getInventoryList() ) );
        store.setCustomerList( customerDtoListToCustomerList( storeDto.getCustomerList() ) );

        return store;
    }

    protected Inventory inventoryDtoToInventory(InventoryDto inventoryDto) {
        if ( inventoryDto == null ) {
            return null;
        }

        Inventory inventory = new Inventory();

        inventory.setId( inventoryDto.getId() );
        inventory.setFilm( filmDtoToFilm( inventoryDto.getFilm() ) );
        inventory.setStore( storeDtoToStore( inventoryDto.getStore() ) );
        inventory.setLastUpdate( inventoryDto.getLastUpdate() );
        inventory.setRentalList( rentalDtoListToRentalList( inventoryDto.getRentalList() ) );

        return inventory;
    }

    protected List<FilmDto> filmListToFilmDtoList(List<Film> list) {
        if ( list == null ) {
            return null;
        }

        List<FilmDto> list1 = new ArrayList<FilmDto>( list.size() );
        for ( Film film : list ) {
            list1.add( filmToFilmDto( film ) );
        }

        return list1;
    }

    protected LanguageDto languageToLanguageDto(Language language) {
        if ( language == null ) {
            return null;
        }

        LanguageDto languageDto = new LanguageDto();

        languageDto.setId( language.getId() );
        languageDto.setName( language.getName() );
        languageDto.setLastUpdate( language.getLastUpdate() );
        languageDto.setFilmList( filmListToFilmDtoList( language.getFilmList() ) );

        return languageDto;
    }

    protected List<FilmCategoryDto> filmCategoryListToFilmCategoryDtoList(List<FilmCategory> list) {
        if ( list == null ) {
            return null;
        }

        List<FilmCategoryDto> list1 = new ArrayList<FilmCategoryDto>( list.size() );
        for ( FilmCategory filmCategory : list ) {
            list1.add( filmCategoryToFilmCategoryDto( filmCategory ) );
        }

        return list1;
    }

    protected CategoryDto categoryToCategoryDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( category.getId() );
        categoryDto.setName( category.getName() );
        categoryDto.setLastUpdate( category.getLastUpdate() );
        categoryDto.setFilmCategoryList( filmCategoryListToFilmCategoryDtoList( category.getFilmCategoryList() ) );

        return categoryDto;
    }

    protected FilmCategoryDto filmCategoryToFilmCategoryDto(FilmCategory filmCategory) {
        if ( filmCategory == null ) {
            return null;
        }

        FilmCategoryDto filmCategoryDto = new FilmCategoryDto();

        filmCategoryDto.setId( filmCategory.getId() );
        filmCategoryDto.setFilm( filmToFilmDto( filmCategory.getFilm() ) );
        filmCategoryDto.setCategory( categoryToCategoryDto( filmCategory.getCategory() ) );
        filmCategoryDto.setLastUpdate( filmCategory.getLastUpdate() );

        return filmCategoryDto;
    }

    protected List<FilmActorDto> filmActorListToFilmActorDtoList(List<FilmActor> list) {
        if ( list == null ) {
            return null;
        }

        List<FilmActorDto> list1 = new ArrayList<FilmActorDto>( list.size() );
        for ( FilmActor filmActor : list ) {
            list1.add( filmActorToFilmActorDto( filmActor ) );
        }

        return list1;
    }

    protected ActorDto actorToActorDto(Actor actor) {
        if ( actor == null ) {
            return null;
        }

        ActorDto actorDto = new ActorDto();

        actorDto.setId( actor.getId() );
        actorDto.setFirstName( actor.getFirstName() );
        actorDto.setLastName( actor.getLastName() );
        actorDto.setLastUpdate( actor.getLastUpdate() );
        actorDto.setFilmActorList( filmActorListToFilmActorDtoList( actor.getFilmActorList() ) );

        return actorDto;
    }

    protected FilmActorDto filmActorToFilmActorDto(FilmActor filmActor) {
        if ( filmActor == null ) {
            return null;
        }

        FilmActorDto filmActorDto = new FilmActorDto();

        filmActorDto.setId( filmActor.getId() );
        filmActorDto.setActor( actorToActorDto( filmActor.getActor() ) );
        filmActorDto.setFilm( filmToFilmDto( filmActor.getFilm() ) );
        filmActorDto.setLastUpdate( filmActor.getLastUpdate() );

        return filmActorDto;
    }

    protected List<InventoryDto> inventoryListToInventoryDtoList(List<Inventory> list) {
        if ( list == null ) {
            return null;
        }

        List<InventoryDto> list1 = new ArrayList<InventoryDto>( list.size() );
        for ( Inventory inventory : list ) {
            list1.add( inventoryToInventoryDto( inventory ) );
        }

        return list1;
    }

    protected FilmDto filmToFilmDto(Film film) {
        if ( film == null ) {
            return null;
        }

        FilmDto filmDto = new FilmDto();

        filmDto.setId( film.getId() );
        filmDto.setTitle( film.getTitle() );
        filmDto.setDescription( film.getDescription() );
        filmDto.setReleaseYear( film.getReleaseYear() );
        filmDto.setLanguage( languageToLanguageDto( film.getLanguage() ) );
        filmDto.setOriginalLanguage( languageToLanguageDto( film.getOriginalLanguage() ) );
        filmDto.setRentalDuration( film.getRentalDuration() );
        filmDto.setRentalRate( film.getRentalRate() );
        filmDto.setLength( film.getLength() );
        filmDto.setReplacementCost( film.getReplacementCost() );
        filmDto.setRating( film.getRating() );
        filmDto.setSpecialFeatures( film.getSpecialFeatures() );
        filmDto.setLastUpdate( film.getLastUpdate() );
        filmDto.setFilmCategoryList( filmCategoryListToFilmCategoryDtoList( film.getFilmCategoryList() ) );
        filmDto.setFilmActorList( filmActorListToFilmActorDtoList( film.getFilmActorList() ) );
        filmDto.setInventoryList( inventoryListToInventoryDtoList( film.getInventoryList() ) );

        return filmDto;
    }

    protected List<CityDto> cityListToCityDtoList(List<City> list) {
        if ( list == null ) {
            return null;
        }

        List<CityDto> list1 = new ArrayList<CityDto>( list.size() );
        for ( City city : list ) {
            list1.add( cityToCityDto( city ) );
        }

        return list1;
    }

    protected CountryDto countryToCountryDto(Country country) {
        if ( country == null ) {
            return null;
        }

        CountryDto countryDto = new CountryDto();

        countryDto.setId( country.getId() );
        countryDto.setCountry( country.getCountry() );
        countryDto.setLastUpdate( country.getLastUpdate() );
        countryDto.setCityList( cityListToCityDtoList( country.getCityList() ) );

        return countryDto;
    }

    protected List<AddressDto> addressListToAddressDtoList(List<Address> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressDto> list1 = new ArrayList<AddressDto>( list.size() );
        for ( Address address : list ) {
            list1.add( addressToAddressDto( address ) );
        }

        return list1;
    }

    protected CityDto cityToCityDto(City city) {
        if ( city == null ) {
            return null;
        }

        CityDto cityDto = new CityDto();

        cityDto.setId( city.getId() );
        cityDto.setCity( city.getCity() );
        cityDto.setCountry( countryToCountryDto( city.getCountry() ) );
        cityDto.setLastUpdate( city.getLastUpdate() );
        cityDto.setAddressList( addressListToAddressDtoList( city.getAddressList() ) );

        return cityDto;
    }

    protected List<StaffDto> staffListToStaffDtoList(List<Staff> list) {
        if ( list == null ) {
            return null;
        }

        List<StaffDto> list1 = new ArrayList<StaffDto>( list.size() );
        for ( Staff staff : list ) {
            list1.add( staffToStaffDto( staff ) );
        }

        return list1;
    }

    protected List<StoreDto> storeListToStoreDtoList(List<Store> list) {
        if ( list == null ) {
            return null;
        }

        List<StoreDto> list1 = new ArrayList<StoreDto>( list.size() );
        for ( Store store : list ) {
            list1.add( storeToStoreDto( store ) );
        }

        return list1;
    }

    protected List<RentalDto> rentalListToRentalDtoList(List<Rental> list) {
        if ( list == null ) {
            return null;
        }

        List<RentalDto> list1 = new ArrayList<RentalDto>( list.size() );
        for ( Rental rental : list ) {
            list1.add( toDto( rental ) );
        }

        return list1;
    }

    protected PaymentDto paymentToPaymentDto(Payment payment) {
        if ( payment == null ) {
            return null;
        }

        PaymentDto paymentDto = new PaymentDto();

        paymentDto.setId( payment.getId() );
        paymentDto.setCustomer( customerToCustomerDto( payment.getCustomer() ) );
        paymentDto.setStaff( staffToStaffDto( payment.getStaff() ) );
        paymentDto.setRental( toDto( payment.getRental() ) );
        paymentDto.setAmount( payment.getAmount() );
        paymentDto.setPaymentDate( payment.getPaymentDate() );
        paymentDto.setLastUpdate( payment.getLastUpdate() );

        return paymentDto;
    }

    protected List<PaymentDto> paymentListToPaymentDtoList(List<Payment> list) {
        if ( list == null ) {
            return null;
        }

        List<PaymentDto> list1 = new ArrayList<PaymentDto>( list.size() );
        for ( Payment payment : list ) {
            list1.add( paymentToPaymentDto( payment ) );
        }

        return list1;
    }

    protected CustomerDto customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( customer.getId() );
        customerDto.setStore( storeToStoreDto( customer.getStore() ) );
        customerDto.setFirstName( customer.getFirstName() );
        customerDto.setLastName( customer.getLastName() );
        customerDto.setEmail( customer.getEmail() );
        customerDto.setAddress( addressToAddressDto( customer.getAddress() ) );
        customerDto.setActive( customer.getActive() );
        customerDto.setCreateDate( customer.getCreateDate() );
        customerDto.setRentalList( rentalListToRentalDtoList( customer.getRentalList() ) );
        customerDto.setPaymentList( paymentListToPaymentDtoList( customer.getPaymentList() ) );
        customerDto.setLastUpdate( customer.getLastUpdate() );

        return customerDto;
    }

    protected List<CustomerDto> customerListToCustomerDtoList(List<Customer> list) {
        if ( list == null ) {
            return null;
        }

        List<CustomerDto> list1 = new ArrayList<CustomerDto>( list.size() );
        for ( Customer customer : list ) {
            list1.add( customerToCustomerDto( customer ) );
        }

        return list1;
    }

    protected AddressDto addressToAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setId( address.getId() );
        addressDto.setAddress( address.getAddress() );
        addressDto.setAddress2( address.getAddress2() );
        addressDto.setDistrict( address.getDistrict() );
        addressDto.setPostalCode( address.getPostalCode() );
        addressDto.setPhone( address.getPhone() );
        addressDto.setLastUpdate( address.getLastUpdate() );
        byte[] location = address.getLocation();
        if ( location != null ) {
            addressDto.setLocation( Arrays.copyOf( location, location.length ) );
        }
        addressDto.setCity( cityToCityDto( address.getCity() ) );
        addressDto.setStaffList( staffListToStaffDtoList( address.getStaffList() ) );
        addressDto.setStoreList( storeListToStoreDtoList( address.getStoreList() ) );
        addressDto.setCustomerList( customerListToCustomerDtoList( address.getCustomerList() ) );

        return addressDto;
    }

    protected StaffDto staffToStaffDto(Staff staff) {
        if ( staff == null ) {
            return null;
        }

        StaffDto staffDto = new StaffDto();

        staffDto.setId( staff.getId() );
        staffDto.setFirstName( staff.getFirstName() );
        staffDto.setLastName( staff.getLastName() );
        staffDto.setAddress( addressToAddressDto( staff.getAddress() ) );
        byte[] picture = staff.getPicture();
        if ( picture != null ) {
            staffDto.setPicture( Arrays.copyOf( picture, picture.length ) );
        }
        staffDto.setEmail( staff.getEmail() );
        staffDto.setStore( storeToStoreDto( staff.getStore() ) );
        staffDto.setActive( staff.getActive() );
        staffDto.setUsername( staff.getUsername() );
        staffDto.setPassword( staff.getPassword() );
        staffDto.setLastUpdate( staff.getLastUpdate() );
        staffDto.setRentalList( rentalListToRentalDtoList( staff.getRentalList() ) );
        staffDto.setPaymentList( paymentListToPaymentDtoList( staff.getPaymentList() ) );

        return staffDto;
    }

    protected StoreDto storeToStoreDto(Store store) {
        if ( store == null ) {
            return null;
        }

        StoreDto storeDto = new StoreDto();

        storeDto.setId( store.getId() );
        storeDto.setManagerStaff( staffToStaffDto( store.getManagerStaff() ) );
        storeDto.setAddress( addressToAddressDto( store.getAddress() ) );
        storeDto.setLastUpdate( store.getLastUpdate() );
        storeDto.setStaffList( staffListToStaffDtoList( store.getStaffList() ) );
        storeDto.setInventoryList( inventoryListToInventoryDtoList( store.getInventoryList() ) );
        storeDto.setCustomerList( customerListToCustomerDtoList( store.getCustomerList() ) );

        return storeDto;
    }

    protected InventoryDto inventoryToInventoryDto(Inventory inventory) {
        if ( inventory == null ) {
            return null;
        }

        InventoryDto inventoryDto = new InventoryDto();

        inventoryDto.setId( inventory.getId() );
        inventoryDto.setFilm( filmToFilmDto( inventory.getFilm() ) );
        inventoryDto.setStore( storeToStoreDto( inventory.getStore() ) );
        inventoryDto.setLastUpdate( inventory.getLastUpdate() );
        inventoryDto.setRentalList( rentalListToRentalDtoList( inventory.getRentalList() ) );

        return inventoryDto;
    }

    protected void languageDtoToLanguage1(LanguageDto languageDto, Language mappingTarget) {
        if ( languageDto == null ) {
            return;
        }

        mappingTarget.setId( languageDto.getId() );
        mappingTarget.setName( languageDto.getName() );
        mappingTarget.setLastUpdate( languageDto.getLastUpdate() );
        if ( mappingTarget.getFilmList() != null ) {
            List<Film> list = filmDtoListToFilmList( languageDto.getFilmList() );
            if ( list != null ) {
                mappingTarget.getFilmList().clear();
                mappingTarget.getFilmList().addAll( list );
            }
            else {
                mappingTarget.setFilmList( null );
            }
        }
        else {
            List<Film> list = filmDtoListToFilmList( languageDto.getFilmList() );
            if ( list != null ) {
                mappingTarget.setFilmList( list );
            }
        }
    }

    protected void filmDtoToFilm1(FilmDto filmDto, Film mappingTarget) {
        if ( filmDto == null ) {
            return;
        }

        mappingTarget.setId( filmDto.getId() );
        mappingTarget.setTitle( filmDto.getTitle() );
        mappingTarget.setDescription( filmDto.getDescription() );
        mappingTarget.setReleaseYear( filmDto.getReleaseYear() );
        if ( filmDto.getLanguage() != null ) {
            if ( mappingTarget.getLanguage() == null ) {
                mappingTarget.setLanguage( new Language() );
            }
            languageDtoToLanguage1( filmDto.getLanguage(), mappingTarget.getLanguage() );
        }
        else {
            mappingTarget.setLanguage( null );
        }
        if ( filmDto.getOriginalLanguage() != null ) {
            if ( mappingTarget.getOriginalLanguage() == null ) {
                mappingTarget.setOriginalLanguage( new Language() );
            }
            languageDtoToLanguage1( filmDto.getOriginalLanguage(), mappingTarget.getOriginalLanguage() );
        }
        else {
            mappingTarget.setOriginalLanguage( null );
        }
        mappingTarget.setRentalDuration( filmDto.getRentalDuration() );
        mappingTarget.setRentalRate( filmDto.getRentalRate() );
        mappingTarget.setLength( filmDto.getLength() );
        mappingTarget.setReplacementCost( filmDto.getReplacementCost() );
        mappingTarget.setRating( filmDto.getRating() );
        mappingTarget.setSpecialFeatures( filmDto.getSpecialFeatures() );
        mappingTarget.setLastUpdate( filmDto.getLastUpdate() );
        if ( mappingTarget.getFilmCategoryList() != null ) {
            List<FilmCategory> list = filmCategoryDtoListToFilmCategoryList( filmDto.getFilmCategoryList() );
            if ( list != null ) {
                mappingTarget.getFilmCategoryList().clear();
                mappingTarget.getFilmCategoryList().addAll( list );
            }
            else {
                mappingTarget.setFilmCategoryList( null );
            }
        }
        else {
            List<FilmCategory> list = filmCategoryDtoListToFilmCategoryList( filmDto.getFilmCategoryList() );
            if ( list != null ) {
                mappingTarget.setFilmCategoryList( list );
            }
        }
        if ( mappingTarget.getFilmActorList() != null ) {
            List<FilmActor> list1 = filmActorDtoListToFilmActorList( filmDto.getFilmActorList() );
            if ( list1 != null ) {
                mappingTarget.getFilmActorList().clear();
                mappingTarget.getFilmActorList().addAll( list1 );
            }
            else {
                mappingTarget.setFilmActorList( null );
            }
        }
        else {
            List<FilmActor> list1 = filmActorDtoListToFilmActorList( filmDto.getFilmActorList() );
            if ( list1 != null ) {
                mappingTarget.setFilmActorList( list1 );
            }
        }
        if ( mappingTarget.getInventoryList() != null ) {
            List<Inventory> list2 = inventoryDtoListToInventoryList( filmDto.getInventoryList() );
            if ( list2 != null ) {
                mappingTarget.getInventoryList().clear();
                mappingTarget.getInventoryList().addAll( list2 );
            }
            else {
                mappingTarget.setInventoryList( null );
            }
        }
        else {
            List<Inventory> list2 = inventoryDtoListToInventoryList( filmDto.getInventoryList() );
            if ( list2 != null ) {
                mappingTarget.setInventoryList( list2 );
            }
        }
    }

    protected void countryDtoToCountry1(CountryDto countryDto, Country mappingTarget) {
        if ( countryDto == null ) {
            return;
        }

        mappingTarget.setId( countryDto.getId() );
        mappingTarget.setCountry( countryDto.getCountry() );
        mappingTarget.setLastUpdate( countryDto.getLastUpdate() );
        if ( mappingTarget.getCityList() != null ) {
            List<City> list = cityDtoListToCityList( countryDto.getCityList() );
            if ( list != null ) {
                mappingTarget.getCityList().clear();
                mappingTarget.getCityList().addAll( list );
            }
            else {
                mappingTarget.setCityList( null );
            }
        }
        else {
            List<City> list = cityDtoListToCityList( countryDto.getCityList() );
            if ( list != null ) {
                mappingTarget.setCityList( list );
            }
        }
    }

    protected void cityDtoToCity1(CityDto cityDto, City mappingTarget) {
        if ( cityDto == null ) {
            return;
        }

        mappingTarget.setId( cityDto.getId() );
        mappingTarget.setCity( cityDto.getCity() );
        if ( cityDto.getCountry() != null ) {
            if ( mappingTarget.getCountry() == null ) {
                mappingTarget.setCountry( new Country() );
            }
            countryDtoToCountry1( cityDto.getCountry(), mappingTarget.getCountry() );
        }
        else {
            mappingTarget.setCountry( null );
        }
        mappingTarget.setLastUpdate( cityDto.getLastUpdate() );
        if ( mappingTarget.getAddressList() != null ) {
            List<Address> list = addressDtoListToAddressList( cityDto.getAddressList() );
            if ( list != null ) {
                mappingTarget.getAddressList().clear();
                mappingTarget.getAddressList().addAll( list );
            }
            else {
                mappingTarget.setAddressList( null );
            }
        }
        else {
            List<Address> list = addressDtoListToAddressList( cityDto.getAddressList() );
            if ( list != null ) {
                mappingTarget.setAddressList( list );
            }
        }
    }

    protected void addressDtoToAddress1(AddressDto addressDto, Address mappingTarget) {
        if ( addressDto == null ) {
            return;
        }

        mappingTarget.setId( addressDto.getId() );
        mappingTarget.setAddress( addressDto.getAddress() );
        mappingTarget.setAddress2( addressDto.getAddress2() );
        mappingTarget.setDistrict( addressDto.getDistrict() );
        mappingTarget.setPostalCode( addressDto.getPostalCode() );
        mappingTarget.setPhone( addressDto.getPhone() );
        mappingTarget.setLastUpdate( addressDto.getLastUpdate() );
        byte[] location = addressDto.getLocation();
        if ( location != null ) {
            mappingTarget.setLocation( Arrays.copyOf( location, location.length ) );
        }
        else {
            mappingTarget.setLocation( null );
        }
        if ( addressDto.getCity() != null ) {
            if ( mappingTarget.getCity() == null ) {
                mappingTarget.setCity( new City() );
            }
            cityDtoToCity1( addressDto.getCity(), mappingTarget.getCity() );
        }
        else {
            mappingTarget.setCity( null );
        }
        if ( mappingTarget.getStaffList() != null ) {
            List<Staff> list = staffDtoListToStaffList( addressDto.getStaffList() );
            if ( list != null ) {
                mappingTarget.getStaffList().clear();
                mappingTarget.getStaffList().addAll( list );
            }
            else {
                mappingTarget.setStaffList( null );
            }
        }
        else {
            List<Staff> list = staffDtoListToStaffList( addressDto.getStaffList() );
            if ( list != null ) {
                mappingTarget.setStaffList( list );
            }
        }
        if ( mappingTarget.getStoreList() != null ) {
            List<Store> list1 = storeDtoListToStoreList( addressDto.getStoreList() );
            if ( list1 != null ) {
                mappingTarget.getStoreList().clear();
                mappingTarget.getStoreList().addAll( list1 );
            }
            else {
                mappingTarget.setStoreList( null );
            }
        }
        else {
            List<Store> list1 = storeDtoListToStoreList( addressDto.getStoreList() );
            if ( list1 != null ) {
                mappingTarget.setStoreList( list1 );
            }
        }
        if ( mappingTarget.getCustomerList() != null ) {
            List<Customer> list2 = customerDtoListToCustomerList( addressDto.getCustomerList() );
            if ( list2 != null ) {
                mappingTarget.getCustomerList().clear();
                mappingTarget.getCustomerList().addAll( list2 );
            }
            else {
                mappingTarget.setCustomerList( null );
            }
        }
        else {
            List<Customer> list2 = customerDtoListToCustomerList( addressDto.getCustomerList() );
            if ( list2 != null ) {
                mappingTarget.setCustomerList( list2 );
            }
        }
    }

    protected void staffDtoToStaff1(StaffDto staffDto, Staff mappingTarget) {
        if ( staffDto == null ) {
            return;
        }

        mappingTarget.setId( staffDto.getId() );
        mappingTarget.setFirstName( staffDto.getFirstName() );
        mappingTarget.setLastName( staffDto.getLastName() );
        if ( staffDto.getAddress() != null ) {
            if ( mappingTarget.getAddress() == null ) {
                mappingTarget.setAddress( new Address() );
            }
            addressDtoToAddress1( staffDto.getAddress(), mappingTarget.getAddress() );
        }
        else {
            mappingTarget.setAddress( null );
        }
        byte[] picture = staffDto.getPicture();
        if ( picture != null ) {
            mappingTarget.setPicture( Arrays.copyOf( picture, picture.length ) );
        }
        else {
            mappingTarget.setPicture( null );
        }
        mappingTarget.setEmail( staffDto.getEmail() );
        if ( staffDto.getStore() != null ) {
            if ( mappingTarget.getStore() == null ) {
                mappingTarget.setStore( new Store() );
            }
            storeDtoToStore1( staffDto.getStore(), mappingTarget.getStore() );
        }
        else {
            mappingTarget.setStore( null );
        }
        mappingTarget.setActive( staffDto.getActive() );
        mappingTarget.setUsername( staffDto.getUsername() );
        mappingTarget.setPassword( staffDto.getPassword() );
        mappingTarget.setLastUpdate( staffDto.getLastUpdate() );
        if ( mappingTarget.getRentalList() != null ) {
            List<Rental> list = rentalDtoListToRentalList( staffDto.getRentalList() );
            if ( list != null ) {
                mappingTarget.getRentalList().clear();
                mappingTarget.getRentalList().addAll( list );
            }
            else {
                mappingTarget.setRentalList( null );
            }
        }
        else {
            List<Rental> list = rentalDtoListToRentalList( staffDto.getRentalList() );
            if ( list != null ) {
                mappingTarget.setRentalList( list );
            }
        }
        if ( mappingTarget.getPaymentList() != null ) {
            List<Payment> list1 = paymentDtoListToPaymentList( staffDto.getPaymentList() );
            if ( list1 != null ) {
                mappingTarget.getPaymentList().clear();
                mappingTarget.getPaymentList().addAll( list1 );
            }
            else {
                mappingTarget.setPaymentList( null );
            }
        }
        else {
            List<Payment> list1 = paymentDtoListToPaymentList( staffDto.getPaymentList() );
            if ( list1 != null ) {
                mappingTarget.setPaymentList( list1 );
            }
        }
    }

    protected void storeDtoToStore1(StoreDto storeDto, Store mappingTarget) {
        if ( storeDto == null ) {
            return;
        }

        mappingTarget.setId( storeDto.getId() );
        if ( storeDto.getManagerStaff() != null ) {
            if ( mappingTarget.getManagerStaff() == null ) {
                mappingTarget.setManagerStaff( new Staff() );
            }
            staffDtoToStaff1( storeDto.getManagerStaff(), mappingTarget.getManagerStaff() );
        }
        else {
            mappingTarget.setManagerStaff( null );
        }
        if ( storeDto.getAddress() != null ) {
            if ( mappingTarget.getAddress() == null ) {
                mappingTarget.setAddress( new Address() );
            }
            addressDtoToAddress1( storeDto.getAddress(), mappingTarget.getAddress() );
        }
        else {
            mappingTarget.setAddress( null );
        }
        mappingTarget.setLastUpdate( storeDto.getLastUpdate() );
        if ( mappingTarget.getStaffList() != null ) {
            List<Staff> list = staffDtoListToStaffList( storeDto.getStaffList() );
            if ( list != null ) {
                mappingTarget.getStaffList().clear();
                mappingTarget.getStaffList().addAll( list );
            }
            else {
                mappingTarget.setStaffList( null );
            }
        }
        else {
            List<Staff> list = staffDtoListToStaffList( storeDto.getStaffList() );
            if ( list != null ) {
                mappingTarget.setStaffList( list );
            }
        }
        if ( mappingTarget.getInventoryList() != null ) {
            List<Inventory> list1 = inventoryDtoListToInventoryList( storeDto.getInventoryList() );
            if ( list1 != null ) {
                mappingTarget.getInventoryList().clear();
                mappingTarget.getInventoryList().addAll( list1 );
            }
            else {
                mappingTarget.setInventoryList( null );
            }
        }
        else {
            List<Inventory> list1 = inventoryDtoListToInventoryList( storeDto.getInventoryList() );
            if ( list1 != null ) {
                mappingTarget.setInventoryList( list1 );
            }
        }
        if ( mappingTarget.getCustomerList() != null ) {
            List<Customer> list2 = customerDtoListToCustomerList( storeDto.getCustomerList() );
            if ( list2 != null ) {
                mappingTarget.getCustomerList().clear();
                mappingTarget.getCustomerList().addAll( list2 );
            }
            else {
                mappingTarget.setCustomerList( null );
            }
        }
        else {
            List<Customer> list2 = customerDtoListToCustomerList( storeDto.getCustomerList() );
            if ( list2 != null ) {
                mappingTarget.setCustomerList( list2 );
            }
        }
    }

    protected void inventoryDtoToInventory1(InventoryDto inventoryDto, Inventory mappingTarget) {
        if ( inventoryDto == null ) {
            return;
        }

        mappingTarget.setId( inventoryDto.getId() );
        if ( inventoryDto.getFilm() != null ) {
            if ( mappingTarget.getFilm() == null ) {
                mappingTarget.setFilm( new Film() );
            }
            filmDtoToFilm1( inventoryDto.getFilm(), mappingTarget.getFilm() );
        }
        else {
            mappingTarget.setFilm( null );
        }
        if ( inventoryDto.getStore() != null ) {
            if ( mappingTarget.getStore() == null ) {
                mappingTarget.setStore( new Store() );
            }
            storeDtoToStore1( inventoryDto.getStore(), mappingTarget.getStore() );
        }
        else {
            mappingTarget.setStore( null );
        }
        mappingTarget.setLastUpdate( inventoryDto.getLastUpdate() );
        if ( mappingTarget.getRentalList() != null ) {
            List<Rental> list = rentalDtoListToRentalList( inventoryDto.getRentalList() );
            if ( list != null ) {
                mappingTarget.getRentalList().clear();
                mappingTarget.getRentalList().addAll( list );
            }
            else {
                mappingTarget.setRentalList( null );
            }
        }
        else {
            List<Rental> list = rentalDtoListToRentalList( inventoryDto.getRentalList() );
            if ( list != null ) {
                mappingTarget.setRentalList( list );
            }
        }
    }

    protected void customerDtoToCustomer1(CustomerDto customerDto, Customer mappingTarget) {
        if ( customerDto == null ) {
            return;
        }

        mappingTarget.setId( customerDto.getId() );
        if ( customerDto.getStore() != null ) {
            if ( mappingTarget.getStore() == null ) {
                mappingTarget.setStore( new Store() );
            }
            storeDtoToStore1( customerDto.getStore(), mappingTarget.getStore() );
        }
        else {
            mappingTarget.setStore( null );
        }
        mappingTarget.setFirstName( customerDto.getFirstName() );
        mappingTarget.setLastName( customerDto.getLastName() );
        mappingTarget.setEmail( customerDto.getEmail() );
        if ( customerDto.getAddress() != null ) {
            if ( mappingTarget.getAddress() == null ) {
                mappingTarget.setAddress( new Address() );
            }
            addressDtoToAddress1( customerDto.getAddress(), mappingTarget.getAddress() );
        }
        else {
            mappingTarget.setAddress( null );
        }
        mappingTarget.setActive( customerDto.getActive() );
        mappingTarget.setCreateDate( customerDto.getCreateDate() );
        if ( mappingTarget.getRentalList() != null ) {
            List<Rental> list = rentalDtoListToRentalList( customerDto.getRentalList() );
            if ( list != null ) {
                mappingTarget.getRentalList().clear();
                mappingTarget.getRentalList().addAll( list );
            }
            else {
                mappingTarget.setRentalList( null );
            }
        }
        else {
            List<Rental> list = rentalDtoListToRentalList( customerDto.getRentalList() );
            if ( list != null ) {
                mappingTarget.setRentalList( list );
            }
        }
        if ( mappingTarget.getPaymentList() != null ) {
            List<Payment> list1 = paymentDtoListToPaymentList( customerDto.getPaymentList() );
            if ( list1 != null ) {
                mappingTarget.getPaymentList().clear();
                mappingTarget.getPaymentList().addAll( list1 );
            }
            else {
                mappingTarget.setPaymentList( null );
            }
        }
        else {
            List<Payment> list1 = paymentDtoListToPaymentList( customerDto.getPaymentList() );
            if ( list1 != null ) {
                mappingTarget.setPaymentList( list1 );
            }
        }
        mappingTarget.setLastUpdate( customerDto.getLastUpdate() );
    }
}
