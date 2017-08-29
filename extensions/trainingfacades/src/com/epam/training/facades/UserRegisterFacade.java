package com.epam.training.facades;

import com.epam.training.data.OrganizationData;
import com.epam.training.model.OrganizationModel;

import java.util.Collection;
import java.util.List;

public interface UserRegisterFacade {
    Collection<OrganizationData> getOrganizations();
}