/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package com.epam.training.setup;

import static com.epam.training.constants.TraininghmcConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.epam.training.constants.TraininghmcConstants;
import com.epam.training.service.TraininghmcService;


@SystemSetup(extension = TraininghmcConstants.EXTENSIONNAME)
public class TraininghmcSystemSetup
{
	private final TraininghmcService traininghmcService;

	public TraininghmcSystemSetup(final TraininghmcService traininghmcService)
	{
		this.traininghmcService = traininghmcService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		traininghmcService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return TraininghmcSystemSetup.class.getResourceAsStream("/traininghmc/sap-hybris-platform.png");
	}
}
