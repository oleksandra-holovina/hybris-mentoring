package com.epam.training.facades.converters;

import com.epam.training.data.OrganizationData;
import com.epam.training.model.OrganizationModel;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrganizationConverter implements Converter<OrganizationModel, OrganizationData> {

    @Override
    public OrganizationData convert(OrganizationModel organizationModel) {
        OrganizationData organizationData = new OrganizationData();

        organizationData.setCode(organizationModel.getCode());
        organizationData.setName(organizationModel.getName());
        organizationData.setFaculty(organizationModel.getFaculty());
        organizationData.setGraduation(organizationModel.getGraduation());

        return organizationData;
    }

    public List<OrganizationData> convertAll(Collection<OrganizationModel> organizationModels){
        List<OrganizationData> organizationData = new ArrayList<>();

        for(OrganizationModel organizationModel: organizationModels){
            OrganizationData organization = new OrganizationData();

            organization.setCode(organizationModel.getCode());
            organization.setName(organizationModel.getName());
            organization.setFaculty(organizationModel.getFaculty());
            organization.setGraduation(organizationModel.getGraduation());

            organizationData.add(organization);
        }
        return organizationData;
    }
}