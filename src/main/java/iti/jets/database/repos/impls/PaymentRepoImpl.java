package iti.jets.database.repos.impls;

import iti.jets.database.entities.Payment;
import jakarta.persistence.EntityManager;

public class PaymentRepoImpl extends GenericRepo<Integer, Payment> {

    public PaymentRepoImpl(EntityManager entityManager) {
        super(entityManager, Payment.class);
    }

}
