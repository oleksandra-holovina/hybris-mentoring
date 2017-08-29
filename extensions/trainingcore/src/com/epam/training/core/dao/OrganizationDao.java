package com.epam.training.core.dao;

import com.epam.training.model.OrganizationModel;

import java.util.List;

public interface OrganizationDao {
    List<OrganizationModel> getOrganizations();
}