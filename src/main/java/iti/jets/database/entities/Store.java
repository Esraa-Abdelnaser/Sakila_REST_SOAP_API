package iti.jets.database.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Entity
@Table(name = "store")
public class Store {
    @Id
    @Column(name = "store_id", columnDefinition = "TINYINT UNSIGNED not null")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_staff_id", nullable = false)
    private Staff managerStaff;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store", fetch = FetchType.LAZY)
    private List<Staff> staffList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store", fetch = FetchType.LAZY)
    private List<Inventory> inventoryList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store", fetch = FetchType.LAZY)
    private List<Customer> customerList;

}