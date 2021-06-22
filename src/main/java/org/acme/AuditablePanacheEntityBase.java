package org.acme;

import javax.persistence.Embedded;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@MappedSuperclass
@EntityListeners(AuditListener.class)
public class AuditablePanacheEntityBase extends PanacheEntityBase implements Auditable {

    @Embedded
    public Audit audit;

    @Override
    public Audit getAudit() {
        return audit;
    }

    @Override
    public void setAudit(Audit audit) {
        this.audit = audit;
    }

}