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
    date = "2023-04-17T01:37:56+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@ApplicationScoped
public class StaffMapperImpl implements StaffMapper {

    @Override
    public Staff toEntity(StaffDto staffDto) {
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

    @Override
    public StaffDto toDto(Staff staff) {
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

    @Override
    public Staff partialUpdate(StaffDto staffDto, Staff staff) {
        if ( staffDto == null ) {
            return staff;
        }

        if ( staffDto.getId() != null ) {
            staff.setId( staffDto.getId() );
        }
        if ( staffDto.getFirstName() != null ) {
            staff.setFirstName( staffDto.getFirstName() );
        }
        if ( staffDto.getLastName() != null ) {
            staff.setLastName( staffDto.getLastName() );
        }
        if ( staffDto.getAddress() != null ) {
            if ( staff.getAddress() == null ) {
                staff.setAddress( new Address() );
            }
            addressDtoToAddress1( staffDto.getAddress(), staff.getAddress() );
        }
        byte[] picture = staffDto.getPicture();
        if ( picture != null ) {
            staff.setPicture( Arrays.copyOf( picture, picture.length ) );
        }
        if ( staffDto.getEmail() != null ) {
            staff.setEmail( staffDto.getEmail() );
        }
        if ( staffDto.getStore() != null ) {
            if ( staff.getStore() == null ) {
                staff.setStore( new Store() );
            }
            storeDtoToStore1( staffDto.getStore(), staff.getStore() );
        }
        if ( staffDto.getActive() != null ) {
            staff.setActive( staffDto.getActive() );
        }
        if ( staffDto.getUsername() != null ) {
            staff.setUsername( staffDto.getUsername() );
        }
        if ( staffDto.getPassword() != null ) {
            staff.setPassword( staffDto.getPassword() );
        }
        if ( staffDto.getLastUpdate() != null ) {
            staff.setLastUpdate( staffDto.getLastUpdate() );
        }
        if ( staff.getRentalList() != null ) {
            List<Rental> list = rentalDtoListToRentalList( staffDto.getRentalList() );
            if ( list != null ) {
                staff.getRentalList().clear();
                staff.getRentalList().addAll( list );
            }
        }
        else {
            List<Rental> list = rentalDtoListToRentalList( staffDto.getRentalList() );
            if ( list != null ) {
                staff.setRentalList( list );
            }
        }
        if ( staff.getPaymentList() != null ) {
            List<Payment> list1 = paymentDtoListToPaymentList( staffDto.getPaymentList() );
            if ( list1 != null ) {
                staff.getPaymentList().clear();
                staff.getPaymentList().addAll( list1 );
            }
        }
        else {
            List<Payment> list1 = paymentDtoListToPaymentList( staffDto.getPaymentList() );
            if ( list1 != null ) {
                staff.setPaymentList( list1 );
            }
        }

        return staff;
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
            list1.add( toEntity( staffDto ) );
        }

        return list1;
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

    protected List<Rental> rentalDtoListToRentalList(List<RentalDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Rental> list1 = new ArrayList<Rental>( list.size() );
        for ( RentalDto rentalDto : list ) {
            list1.add( rentalDtoToRental( rentalDto ) );
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
        payment.setStaff( toEntity( paymentDto.getStaff() ) );
        payment.setRental( rentalDtoToRental( paymentDto.getRental() ) );
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

    protected Rental rentalDtoToRental(RentalDto rentalDto) {
        if ( rentalDto == null ) {
            return null;
        }

        Rental rental = new Rental();

        rental.setId( rentalDto.getId() );
        rental.setRentalDate( rentalDto.getRentalDate() );
        rental.setInventory( inventoryDtoToInventory( rentalDto.getInventory() ) );
        rental.setCustomer( customerDtoToCustomer( rentalDto.getCustomer() ) );
        rental.setReturnDate( rentalDto.getReturnDate() );
        rental.setStaff( toEntity( rentalDto.getStaff() ) );
        rental.setLastUpdate( rentalDto.getLastUpdate() );
        rental.setPaymentList( paymentDtoListToPaymentList( rentalDto.getPaymentList() ) );

        return rental;
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

    protected Store storeDtoToStore(StoreDto storeDto) {
        if ( storeDto == null ) {
            return null;
        }

        Store store = new Store();

        store.setId( storeDto.getId() );
        store.setManagerStaff( toEntity( storeDto.getManagerStaff() ) );
        store.setAddress( addressDtoToAddress( storeDto.getAddress() ) );
        store.setLastUpdate( storeDto.getLastUpdate() );
        store.setStaffList( staffDtoListToStaffList( storeDto.getStaffList() ) );
        store.setInventoryList( inventoryDtoListToInventoryList( storeDto.getInventoryList() ) );
        store.setCustomerList( customerDtoListToCustomerList( storeDto.getCustomerList() ) );

        return store;
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
            list1.add( toDto( staff ) );
        }

        return list1;
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

    protected List<RentalDto> rentalListToRentalDtoList(List<Rental> list) {
        if ( list == null ) {
            return null;
        }

        List<RentalDto> list1 = new ArrayList<RentalDto>( list.size() );
        for ( Rental rental : list ) {
            list1.add( rentalToRentalDto( rental ) );
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
        paymentDto.setStaff( toDto( payment.getStaff() ) );
        paymentDto.setRental( rentalToRentalDto( payment.getRental() ) );
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

    protected RentalDto rentalToRentalDto(Rental rental) {
        if ( rental == null ) {
            return null;
        }

        RentalDto rentalDto = new RentalDto();

        rentalDto.setId( rental.getId() );
        rentalDto.setRentalDate( rental.getRentalDate() );
        rentalDto.setInventory( inventoryToInventoryDto( rental.getInventory() ) );
        rentalDto.setCustomer( customerToCustomerDto( rental.getCustomer() ) );
        rentalDto.setReturnDate( rental.getReturnDate() );
        rentalDto.setStaff( toDto( rental.getStaff() ) );
        rentalDto.setLastUpdate( rental.getLastUpdate() );
        rentalDto.setPaymentList( paymentListToPaymentDtoList( rental.getPaymentList() ) );

        return rentalDto;
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

    protected StoreDto storeToStoreDto(Store store) {
        if ( store == null ) {
            return null;
        }

        StoreDto storeDto = new StoreDto();

        storeDto.setId( store.getId() );
        storeDto.setManagerStaff( toDto( store.getManagerStaff() ) );
        storeDto.setAddress( addressToAddressDto( store.getAddress() ) );
        storeDto.setLastUpdate( store.getLastUpdate() );
        storeDto.setStaffList( staffListToStaffDtoList( store.getStaffList() ) );
        storeDto.setInventoryList( inventoryListToInventoryDtoList( store.getInventoryList() ) );
        storeDto.setCustomerList( customerListToCustomerDtoList( store.getCustomerList() ) );

        return storeDto;
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

    protected void storeDtoToStore1(StoreDto storeDto, Store mappingTarget) {
        if ( storeDto == null ) {
            return;
        }

        mappingTarget.setId( storeDto.getId() );
        if ( storeDto.getManagerStaff() != null ) {
            if ( mappingTarget.getManagerStaff() == null ) {
                mappingTarget.setManagerStaff( new Staff() );
            }
            partialUpdate( storeDto.getManagerStaff(), mappingTarget.getManagerStaff() );
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
}
