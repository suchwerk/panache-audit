package org.acme;

import java.time.LocalDateTime;

import javax.enterprise.inject.spi.CDI;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.eclipse.microprofile.jwt.JsonWebToken;

public class AuditListener {

    @PrePersist
    public void setCreatedOn(Auditable auditable) {
        Audit audit = auditable.getAudit();

        if (audit == null) {
            audit = new Audit();
            audit.createdAt = LocalDateTime.now();
            audit.updatedAt = LocalDateTime.now();
            var user = getCurrentUser();
            audit.createUser = user;
            audit.updateUser = user;
            auditable.setAudit(audit);
        }
    }

    @PreUpdate
    public void setUpdatedOn(Auditable auditable) {
        Audit audit = auditable.getAudit();
        audit.updatedAt = LocalDateTime.now();
        audit.updateUser = getCurrentUser();
    }

    private String getCurrentUser() {
        JsonWebToken jwt = CDI.current().select(JsonWebToken.class).get();
        if (jwt != null && jwt.getName() != null) {
            return jwt.getName();
        }
        return "internal";

    }
}
