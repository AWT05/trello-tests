package org.fundacionjala.core.api;

import io.restassured.response.Response;
import org.fundacionjala.core.Environment;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class Mapper {

    private static final String STORED_VALUE_PATTERN = "\\{[0-9a-zA-Z._\\-\\[\\]]+}";
    private static final String EMPTY_KEY = "empty";
    private static final String EMPTY_STRING = "";
    private static final String CAP_REGEX = "[{}]";
    private static final String DOT_REGEX = "\\.";
    private static final int SPLIT_LIMIT = 2;

    /**
     * Private constructor for Mapper utility class.
     */
    private Mapper() {

    }

    /**
     * Replaces data according to pattern.
     *
     * @param content   original content.
     * @param responses response objects stored.
     * @return string mapped.
     */
    public static String replaceData(final String content, final Map<String, Response> responses) {
        Pattern pattern = Pattern.compile(STORED_VALUE_PATTERN);
        Matcher matcher = pattern.matcher(content);
        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            String value = replaceValue(matcher.group().replaceAll(CAP_REGEX, EMPTY_STRING), responses);
            if (value == null) {
                continue;
            }
            matcher.appendReplacement(result, value);
        }
        matcher.appendTail(result);
        return result.toString();
    }

    /**
     * Replaces data in map according to pattern.
     *
     * @param content   original content.
     * @param responses response objects stored.
     * @return mapped data.
     */
    public static Map<String, String> replaceData(final Map<String, String> content,
                                                  final Map<String, Response> responses) {
        return content.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> replaceData(e.getValue(), responses)));
    }

    /**
     * Replaces values from response or account information.
     *
     * @param value     original value.
     * @param responses response objects stored.
     * @return value replaced.
     */
    private static String replaceValue(final String value, final Map<String, Response> responses) {
        if (value.equals(EMPTY_KEY)) {
            return EMPTY_STRING;
        }
        String[] values = value.split(DOT_REGEX, SPLIT_LIMIT);
        Map<String, String> account = Environment.getInstance().getAccount(values[0]);
        if (account.isEmpty()) {
            Response response = responses.get(values[0]);
            String jsonPath = values[1];
            return response.jsonPath().getString(jsonPath);
        }
        return account.get(values[1]);
    }
}
