package org.acme;

public interface Auditable {
    Audit getAudit();

    void setAudit(Audit audit);
}
