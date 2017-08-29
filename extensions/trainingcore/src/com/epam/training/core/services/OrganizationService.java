package com.epam.training.core.services;

import com.epam.training.model.OrganizationModel;

import java.util.List;

public interface OrganizationService {
    List<OrganizationModel> getOrganizations();
}