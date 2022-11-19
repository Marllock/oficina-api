package com.oficina.educacional.domain.model.enums;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ProfileTypeEnumTest {

    @Test
    void shouldGetProfileTypeIdEnum() {
        assertThat(ProfileTypeEnum.STUDENT.getProfileTypeIdEnum()).isEqualTo(1);
    }

    @Test
    void ShouldReturnValueOfProfileTypeEnum() {
        assertThat(ProfileTypeEnum.valueOf(1)).isEqualTo(ProfileTypeEnum.STUDENT);

    }

    @Test
    void shouldThrowIllegalArgumentException() {
        assertThatThrownBy(() -> ProfileTypeEnum.valueOf(46732)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid id");
    }
}