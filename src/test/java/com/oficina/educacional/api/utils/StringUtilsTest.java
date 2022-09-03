package com.oficina.educacional.api.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import com.oficina.educacional.api.utils.StringUtils;

import static org.assertj.core.api.Assertions.*;
class StringUtilsTest {


    @Test
    public void shouldNormalizeString() {
        StringUtils stringUtils = new StringUtils();
        String messageToNormalize = "Ação de Graças";
        String result = stringUtils.normalizeString(messageToNormalize);

        assertEquals(result, "acao_de_gracas");
    }

}