package com.nikolas.webservicenikolas.security.provider;

import org.springframework.stereotype.Component;

@Component
public class SystemApiKeyProvider implements ApiKeyProvider {
    @Override
    public String getApiKey() {
        return "123";
    }
}
