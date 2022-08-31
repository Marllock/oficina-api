package com.oficina.educacional.api.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StringUtilsTest {

    @Mock
    private StringUtils stringUtils;

    @Test
    public void shouldNormalizeString() {
        String messageToNormalize = "Ação de Graças";
        String result = stringUtils.normalizeString(messageToNormalize);

        assertEquals(result, "acao_de_gracas");
    }

}