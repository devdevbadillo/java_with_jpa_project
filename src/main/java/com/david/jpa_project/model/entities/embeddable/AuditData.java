package com.david.jpa_project.model.entities.embeddable;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class AuditData implements Serializable {
    @Basic(optional = false)
    @Column(updatable = false)
    private Timestamp createdAt;

    @Basic(optional = false)
    private Timestamp updatedAt;
}
