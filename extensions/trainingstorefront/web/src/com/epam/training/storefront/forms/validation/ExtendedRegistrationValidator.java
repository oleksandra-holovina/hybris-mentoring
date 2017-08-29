package com.epam.training.storefront.forms.validation;

import com.epam.training.storefront.forms.RegisterFormWithOrganization;
import de.hybris.platform.acceleratorstorefrontcommons.forms.validation.RegistrationValidator;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;

public class ExtendedRegistrationValidator extends RegistrationValidator {
    @Override
    public void validate(Object form, Errors errors) {
        final RegisterFormWithOrganization registerForm = (RegisterFormWithOrganization) form;
        final String titleCode = registerForm.getTitleCode();
        final String firstName = registerForm.getFirstName();
        final String lastName = registerForm.getLastName();
        final String organization = registerForm.getOrganizationCode();
        final String email = registerForm.getEmail();
        final String pwd = registerForm.getPwd();
        final String checkPwd = registerForm.getCheckPwd();

        if (StringUtils.isEmpty(titleCode))
        {
            errors.rejectValue("titleCode", "register.title.invalid");
        }
        else if (StringUtils.length(titleCode) > 255)
        {
            errors.rejectValue("titleCode", "register.title.invalid");
        }

        if (StringUtils.isBlank(firstName))
        {
            errors.rejectValue("firstName", "register.firstName.invalid");
        }
        else if (StringUtils.length(firstName) > 255)
        {
            errors.rejectValue("firstName", "register.firstName.invalid");
        }

        if (StringUtils.isBlank(lastName))
        {
            errors.rejectValue("lastName", "register.lastName.invalid");
        }
        else if (StringUtils.length(lastName) > 255)
        {
            errors.rejectValue("lastName", "register.lastName.invalid");
        }

        if (StringUtils.length(firstName) + StringUtils.length(lastName) > 255)
        {
            errors.rejectValue("lastName", "register.name.invalid");
            errors.rejectValue("firstName", "register.name.invalid");
        }

        if (StringUtils.isEmpty(email))
        {
            errors.rejectValue("email", "register.email.invalid");
        }
        else if (StringUtils.length(email) > 255 || !validateEmailAddress(email))
        {
            errors.rejectValue("email", "register.email.invalid");
        }
        else if (StringUtils.isEmpty(organization)){
            errors.rejectValue("organization", "register.organization.invalid");
        }
        else if (StringUtils.isEmpty(pwd))
        {
            errors.rejectValue("pwd", "register.pwd.invalid");
        }
        else if (StringUtils.length(pwd) < 6 || StringUtils.length(pwd) > 255)
        {
            errors.rejectValue("pwd", "register.pwd.invalid");
        }

        if (StringUtils.isNotEmpty(pwd) && StringUtils.isNotEmpty(checkPwd) && !StringUtils.equals(pwd, checkPwd))
        {
            errors.rejectValue("checkPwd", "validation.checkPwd.equals");
        }
        else
        {
            if (StringUtils.isEmpty(checkPwd))
            {
                errors.rejectValue("checkPwd", "register.checkPwd.invalid");
            }
        }
    }
}