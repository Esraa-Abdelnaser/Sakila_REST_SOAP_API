package iti.jets.service.dtos;

import iti.jets.database.entities.Customer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * A DTO for the {@link Customer} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto implements Serializable {

    private Integer id;
//    @NotNull
//    private StoreDto store;
    @Size(max = 45)
    @NotNull
    private String firstName;
    @Size(max = 45)
    @NotNull
    private String lastName;
    @Size(max = 50)
    private String email;
//    @NotNull
//    private AddressDto address;
////    @NotNull
////    private StoreDto store;
////    @NotNull
////    private AddressDto address;
////    private List<RentalDto> rentalList;
////    private List<PaymentDto> paymentList;
    @NotNull
    private Boolean active = false;
    @NotNull
    private Instant createDate;
    private List<RentalDto> rentalList;
    private List<PaymentDto> paymentList;
    private Instant lastUpdate;

}