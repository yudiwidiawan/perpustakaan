package parkee.test.perpustakaan.audit;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;

import static jakarta.persistence.TemporalType.TIMESTAMP;

import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<T> {
    
    @CreatedBy
    @Schema(hidden = true)
    protected T createdBy;
    
    @CreatedDate
    @Temporal(TIMESTAMP)
    @Schema(hidden = true)
    protected Date createdDate;
    
    @LastModifiedBy
    @Schema(hidden = true)
    protected T lastModifiedBy;
    
    @LastModifiedDate
    @Temporal(TIMESTAMP)
    @Schema(hidden = true)
    protected Date lastModifiedDate;

    public T getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(T createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public T getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(T lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }
}
