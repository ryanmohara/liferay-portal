/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.security.sso.cas.internal.verify;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.settings.SettingsFactory;
import com.liferay.portal.kernel.util.PrefsProps;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.security.sso.cas.constants.CASConfigurationKeys;
import com.liferay.portal.security.sso.cas.constants.CASConstants;
import com.liferay.portal.security.sso.cas.constants.LegacyCASPropsKeys;
import com.liferay.portal.verify.BaseCompanySettingsVerifyProcess;
import com.liferay.portal.verify.VerifyProcess;

import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Greenwald
 */
@Component(
	immediate = true,
	property = {"verify.process.name=com.liferay.portal.security.sso.cas"},
	service = VerifyProcess.class
)
public class CASCompanySettingsVerifyProcess
	extends BaseCompanySettingsVerifyProcess {

	@Override
	protected CompanyLocalService getCompanyLocalService() {
		return _companyLocalService;
	}

	@Override
	protected Set<String> getLegacyPropertyKeys() {
		return SetUtil.fromArray(LegacyCASPropsKeys.CAS_KEYS);
	}

	@Override
	protected String[][] getRenamePropertyKeysArray() {
		return new String[][] {
			new String[] {
				LegacyCASPropsKeys.CAS_AUTH_ENABLED,
				CASConfigurationKeys.AUTH_ENABLED
			},
			new String[] {
				LegacyCASPropsKeys.CAS_IMPORT_FROM_LDAP,
				CASConfigurationKeys.IMPORT_FROM_LDAP
			},
			new String[] {
				LegacyCASPropsKeys.CAS_LOGIN_URL, CASConfigurationKeys.LOGIN_URL
			},
			new String[] {
				LegacyCASPropsKeys.CAS_LOGOUT_ON_SESSION_EXPIRATION,
				CASConfigurationKeys.LOGOUT_ON_SESSION_EXPIRATION
			},
			new String[] {
				LegacyCASPropsKeys.CAS_LOGOUT_URL,
				CASConfigurationKeys.LOGOUT_URL
			},
			new String[] {
				LegacyCASPropsKeys.CAS_NO_SUCH_USER_REDIRECT_URL,
				CASConfigurationKeys.NO_SUCH_USER_REDIRECT_URL
			},
			new String[] {
				LegacyCASPropsKeys.CAS_SERVER_NAME,
				CASConfigurationKeys.SERVER_NAME
			},
			new String[] {
				LegacyCASPropsKeys.CAS_SERVER_URL,
				CASConfigurationKeys.SERVER_URL
			},
			new String[] {
				LegacyCASPropsKeys.CAS_SERVICE_URL,
				CASConfigurationKeys.SERVICE_URL
			}};
	}

	@Override
	protected SettingsFactory getSettingsFactory() {
		return _settingsFactory;
	}

	@Override
	protected String getSettingsId() {
		return CASConstants.SERVICE_NAME;
	}

	@Reference(unbind = "-")
	protected void setCompanyLocalService(
		CompanyLocalService companyLocalService) {

		_companyLocalService = companyLocalService;
	}

	/**
	 * @deprecated As of 3.0.0, with no direct replacement
	 */
	@Deprecated
	@Reference(unbind = "-")
	protected void setPrefsProps(PrefsProps prefsProps) {
		_prefsProps = prefsProps;
	}

	@Reference(unbind = "-")
	protected void setSettingsFactory(SettingsFactory settingsFactory) {
		_settingsFactory = settingsFactory;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		CASCompanySettingsVerifyProcess.class);

	private CompanyLocalService _companyLocalService;
	private PrefsProps _prefsProps;
	private SettingsFactory _settingsFactory;

}