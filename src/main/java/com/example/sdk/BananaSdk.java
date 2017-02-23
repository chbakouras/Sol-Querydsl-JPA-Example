package com.example.sdk;

import com.example.dto.system.BananaDto;
import org.intellift.sol.sdk.client.AbstractCrudApiAsyncClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.AsyncRestTemplate;

/**
 * @author Achilleas Naoumidis
 */
@Component
public class BananaSdk extends AbstractCrudApiAsyncClient<BananaDto, String> {

    public BananaSdk() {
        super(new AsyncRestTemplate());
    }

    @Override
    protected Class<BananaDto> getDtoClass() {
        return BananaDto.class;
    }

    @Override
    protected String getEndpoint() {
        return "http://localhost:8080/bananas";
    }
}
