package com.oficina.educacional.api.utils;

import org.springframework.stereotype.Component;

import java.text.Normalizer;

@Component
public class StringUtils {

    public String normalizeString(final String sentenceString) {
        return Normalizer.normalize(sentenceString, Normalizer.Form.NFD).toLowerCase().replaceAll(" ", "_")
                .replaceAll("[\u0300-\u036f]", "");
    }
}
