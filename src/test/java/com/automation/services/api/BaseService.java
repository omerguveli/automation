package com.automation.services.api;

import com.automation.utilities.api.ApiUtils;

public abstract class BaseService {
    
    public BaseService(String baseURI) {
        ApiUtils.setBaseURI(baseURI);
    }
}
