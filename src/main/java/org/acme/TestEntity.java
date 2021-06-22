package org.acme;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
// @EntityListeners(AuditListener.class)
public class TestEntity extends AuditablePanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String value;

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.id + ": " + this.audit;
    }
}
