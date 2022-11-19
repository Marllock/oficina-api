package com.oficina.educacional.domain.model.enums;

import java.util.Objects;

public enum ProfileTypeEnum {

    STUDENT(1), PROFESSOR(2);

private final long id;
    ProfileTypeEnum(long value) {
        id = value;
    }

    public long getProfileTypeIdEnum() {
        return id;
    }

    public static ProfileTypeEnum valueOf(long valor) {
        for(ProfileTypeEnum values : ProfileTypeEnum.values()) {
            if(Objects.equals(valor, values.getProfileTypeIdEnum())) {
                return values;
            }
        }
        throw new IllegalArgumentException("Invalid id");
    }
}
