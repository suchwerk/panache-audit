package org.acme;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;

@Embeddable
public class Audit {

    public LocalDateTime updatedAt;
    public String updateUser;

    public LocalDateTime createdAt;
    public String createUser;

    @Override
    public String toString() {
        return "{" + " updatedAt='" + updatedAt + "'" + ", updateUser='" + updateUser + "'" + ", createdAt='"
                + createdAt + "'" + ", createUser='" + createUser + "'" + "}";
    }

}
