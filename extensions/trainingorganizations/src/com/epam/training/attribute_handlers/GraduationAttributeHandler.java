package com.epam.training.attribute_handlers;


import com.epam.training.constants.GeneratedTrainingorganizationsConstants;
import com.epam.training.enums.Graduation;
import com.epam.training.model.OrganizationModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;

import java.util.Comparator;

/**
 * Created by Oleksandra_Holovina on 6/22/2017.
 */
public class GraduationAttributeHandler implements DynamicAttributeHandler<Graduation, CustomerModel> {

    private OrganizationModel chooseHigherGraduation(OrganizationModel curOrganization, OrganizationModel suitableOrganization) {
        return curOrganization.getGraduation().ordinal() > suitableOrganization.getGraduation().ordinal() ?
                curOrganization :
                suitableOrganization;
    }

    protected Graduation findSuitableGraduation(CustomerModel customerModel) {
        final Comparator<OrganizationModel> comparator = Comparator.comparingInt(o -> o.getGraduation().ordinal());
        return customerModel.getOrganizations().stream().max(comparator).get().getGraduation();
    }


    @Override
    public Graduation get(CustomerModel customerModel) {
        if (customerModel == null) {
            throw new IllegalArgumentException("Customer model is null");
        }
        return findSuitableGraduation(customerModel);
    }

    @Override
    public void set(CustomerModel customerModel, Graduation graduation) {
    }
}
