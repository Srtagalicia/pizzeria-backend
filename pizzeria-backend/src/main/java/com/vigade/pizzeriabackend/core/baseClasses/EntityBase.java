package com.vigade.pizzeriabackend.core.baseClasses;

import java.util.Set;
import java.util.UUID;
import org.springframework.data.domain.Persistable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.validation.annotation.Validated;
import lombok.Getter;
import lombok.Setter;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import javax.validation.ConstraintViolation;
import com.vigade.pizzeriabackend.core.exceptions.BadRequestException;

@Validated
public @Getter @Setter abstract class EntityBase implements Persistable<UUID> {
    
    @Id
    protected UUID id;

    @Transient
    protected boolean isThisNew = false;

    public void validate() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator= factory.getValidator();
        Set<ConstraintViolation<EntityBase>> violations = validator.validate(this);
        if(!violations.isEmpty()) {
            BadRequestException badRequestException = new BadRequestException();
            for(ConstraintViolation<EntityBase> violation : violations) {
                badRequestException.addException(violation.getPropertyPath().toString(), violation.getMessage());
            }
            throw badRequestException;
        }
    }

    @Override
    public boolean isNew() {
        return this.isThisNew;
    }

    @Override
    public boolean equals (Object obj) {
        if (!(obj instanceof EntityBase)) {
            return false;
        }
        EntityBase tmpEntity = (EntityBase) obj;
        return this.id.equals(tmpEntity.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}