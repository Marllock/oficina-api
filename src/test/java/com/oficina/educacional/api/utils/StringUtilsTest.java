package com.oficina.educacional.api.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
class StringUtilsTest {

    private StringUtils stringUtils;
    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    public void shouldNormalizeString() {

        String messageToNormalize = "Ação de Graças";
        String result = stringUtils.normalizeString(messageToNormalize);

        assertEquals(result, "acao_de_gracas");
    }

}