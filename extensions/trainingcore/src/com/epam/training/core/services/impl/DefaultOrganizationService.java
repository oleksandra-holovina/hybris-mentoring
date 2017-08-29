package com.epam.training.core.services.impl;

import com.epam.training.core.dao.OrganizationDao;
import com.epam.training.core.services.OrganizationService;
import com.epam.training.model.OrganizationModel;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultOrganizationService implements OrganizationService{
    private OrganizationDao organizationDao;

    @Override
    public List<OrganizationModel> getOrganizations() {
        return organizationDao.getOrganizations();
    }

    @Required
    public void setOrganizationDao(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }
}