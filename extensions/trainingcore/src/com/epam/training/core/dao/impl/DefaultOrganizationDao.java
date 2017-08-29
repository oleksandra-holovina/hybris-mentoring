package com.epam.training.core.dao.impl;

import com.epam.training.core.dao.OrganizationDao;
import com.epam.training.model.OrganizationModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultOrganizationDao implements OrganizationDao{
    private FlexibleSearchService flexibleSearchService;

    @Override
    public List<OrganizationModel> getOrganizations() {
        final String queryString = "SELECT {p:"+OrganizationModel.PK+"} FROM {"+OrganizationModel._TYPECODE+
                " AS p}";

        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        return flexibleSearchService.<OrganizationModel>search(query).getResult();
    }

    @Required
    public void setFlexibleSearchService(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }
}