package iti.jets.service.dtos;

import iti.jets.database.entities.Payment;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/**
 * A DTO for the {@link Payment} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto implements Serializable {

    private Integer id;

    //help
//    @NotNull
//    private CustomerDto customer;
//    @NotNull
//    private StaffDto staff;
//    private RentalDto rental;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private Instant paymentDate;

    private Instant lastUpdate;

    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    private List<Link> links;
}