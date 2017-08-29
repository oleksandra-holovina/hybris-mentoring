package com.epam.training.facades;

import com.epam.training.core.services.OrganizationService;
import com.epam.training.data.OrganizationData;
import com.epam.training.facades.converters.OrganizationConverter;
import com.epam.training.model.OrganizationModel;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;


public class DefaultUserRegisterFacade implements UserRegisterFacade {
    private OrganizationService organizationService;
    private OrganizationConverter organizationConverter;

    @Override
    public List<OrganizationData> getOrganizations() {
        List<OrganizationModel> organizationModels = organizationService.getOrganizations();
        return organizationConverter.convertAll(organizationModels);
    }

    @Required
    public void setOrganizationService(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @Required
    public void setOrganizationConverter(OrganizationConverter organizationConverter) {
        this.organizationConverter = organizationConverter;
    }
}