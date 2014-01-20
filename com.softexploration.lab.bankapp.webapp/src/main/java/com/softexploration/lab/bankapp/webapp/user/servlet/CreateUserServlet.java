package com.softexploration.lab.bankapp.webapp.user.servlet;

import java.io.IOException;
import java.util.Random;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softexploration.lab.bankapp.ext.domain.address.AddressData;
import com.softexploration.lab.bankapp.ext.domain.impl.address.factory.AddressExtDomainObjectFactory;
import com.softexploration.lab.bankapp.ext.domain.impl.cmn.factory.CmnDomainObjectFactory;
import com.softexploration.lab.bankapp.ext.domain.impl.user.factory.UserExtDomainObjectFactory;
import com.softexploration.lab.bankapp.ext.domain.user.UserData;
import com.softexploration.lab.bankapp.ext.domain.user.UserStatus;
import com.softexploration.lab.bankapp.ext.domain.user.request.CreateUserDataRequest;
import com.softexploration.lab.bankapp.ext.domain.user.response.CreateUserDataAcceptedRequestResponse;
import com.softexploration.lab.bankapp.ext.users.api.UserService;

public class CreateUserServlet extends HttpServlet {

	private static final long serialVersionUID = -6235434713450090995L;

	@EJB
	private UserService userService;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// externalRequestId
		Long externalRequestId = new Random().nextLong();

		// userData
		UserData userData = null;
		try {
			userData = prepareUserData(request);
			validate(userData);
		} catch (Exception ex) {
			response.getWriter().println(ex.getMessage());
			return;
		}

		// createUserDataRequest
		CreateUserDataRequest createUserDataRequest = UserExtDomainObjectFactory.getInstance()
				.createCreateUserDataRequest(
						CmnDomainObjectFactory.getInstance()
								.createAsyncRequestId(externalRequestId), userData);

		CreateUserDataAcceptedRequestResponse createUser = userService
				.createUser(createUserDataRequest);

		response.getWriter().println(
				"request sent [" + createUser.getAsyncResponseId().getExternalRequestId()
						+ "] jobId [" + createUser.getAsyncResponseId().getInternalRequestId()
						+ "]");
	}

	private UserData prepareUserData(HttpServletRequest request) {
		String name1 = request.getParameter("name1");
		String name2 = request.getParameter("name2");
		String userStatus = request.getParameter("userStatus");
		String address1Region = request.getParameter("address1Region");
		String address1Country = request.getParameter("address1Country");
		String address1City = request.getParameter("address1City");
		String address1Zip = request.getParameter("address1Zip");
		String address1Street = request.getParameter("address1Street");
		String address2Region = request.getParameter("address2Region");
		String address2Country = request.getParameter("address2Country");
		String address2City = request.getParameter("address2City");
		String address2Zip = request.getParameter("address2Zip");
		String address2Street = request.getParameter("address2Street");

		AddressData addressData1 = AddressExtDomainObjectFactory.getInstance().createAddressData(
				null, address1Region, address1Country, address1City, address1Zip, address1Street);

		AddressData addressData2 = AddressExtDomainObjectFactory.getInstance().createAddressData(
				null, address2Region, address2Country, address2City, address2Zip, address2Street);

		UserData userData = UserExtDomainObjectFactory.getInstance().createUserData(null, name1,
				name2, addressData1, addressData2,
				provideDefault(convertUserStatus(userStatus), UserStatus.A));

		return userData;
	}

	private void validate(UserData data) {
		if (data.getName1() == null) {
			throw new IllegalArgumentException("name1 is not set");
		}
	}

	private UserStatus convertUserStatus(String value) {
		if (value != null) {
			return UserStatus.valueOf(value);
		} else {
			return null;
		}
	}

	private <T> T provideDefault(T value, T defaultValue) {
		return value != null ? value : defaultValue;
	}

}
