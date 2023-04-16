package iti.jets.database.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @Column(name = "staff_id", columnDefinition = "TINYINT UNSIGNED not null")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 45)
    @NotNull
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Size(max = 45)
    @NotNull
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @Column(name = "picture")
    private byte[] picture;

    @Size(max = 50)
    @Column(name = "email", length = 50)
    private String email;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @NotNull
    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @Size(max = 16)
    @NotNull
    @Column(name = "username", nullable = false, length = 16)
    private String username;

    @Size(max = 40)
    @Column(name = "password", length = 40)
    private String password;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staff", fetch = FetchType.LAZY)
    private List<Rental> rentalList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staff", fetch = FetchType.LAZY)
    private List<Payment> paymentList;

}