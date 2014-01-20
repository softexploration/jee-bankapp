package com.softexploration.lab.bankapp.webapp.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softexploration.lab.bankapp.ext.cmn.service.api.local.ListServiceLocal;
import com.softexploration.lab.bankapp.ext.domain.account.AccountData;
import com.softexploration.lab.bankapp.ext.domain.address.AddressData;
import com.softexploration.lab.bankapp.ext.domain.user.UserDataProfile;

public class UserListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6013875377128404136L;

	@EJB
	private ListServiceLocal listService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.getWriter().println("<h1>AllUsers</h1>");

		List<UserDataProfile> users = listService.getAllUsers();
		response.getWriter().println("<table border=1>");
		response.getWriter().println("<tr><td>Base data</td><td>Address1</td><td>Address2</td><td></td></tr>");
		response.getWriter()
				.println(
						"<tr><td>Name1</td><td>Name2</td><td>id</td><td>Status</td><td>Id</td><td>City</td><td>Country</td><td>Region</td><td>Street</td><td>Zip</td><td>Id</td><td>City</td><td>Country</td><td>Region</td><td>Street</td><td>Zip</td><td>Number</td><td>Name1</td><td>AccountStatus</td><td>AccountType</td></tr>");

		for (UserDataProfile user : users) {
			response.getWriter().println("<tr>");
			response.getWriter().println("<td>" + user.getName1() + "</td>");
			response.getWriter().println("<td>" + user.getName2() + "</td>");
			response.getWriter().println("<td>" + user.getId().getId() + "</td>");
			response.getWriter().println("<td>" + user.getStatus() + "</td>");

			if (user.getAddress1() != null) {
				write(user.getAddress1(), response.getWriter());
			}
			if (user.getAddress2() != null) {
				write(user.getAddress2(), response.getWriter());
			}

			List<AccountData> accounts = user.getAccounts();
			for (AccountData accountData : accounts) {
				write(accountData, response.getWriter());
			}
			response.getWriter().println("</tr>");
		}
		response.getWriter().println("</table>");
		response.getWriter().println("<hr/>");
		response.getWriter().flush();
	}

	private void write(AddressData user, PrintWriter pr) {
		pr.println("<td>" + user.getId().getId() + "</td>");
		pr.println("<td>" + user.getCity() + "</td>");
		pr.println("<td>" + user.getCountry() + "</td>");
		pr.println("<td>" + user.getRegion() + "</td>");
		pr.println("<td>" + user.getStreet() + "</td>");
		pr.println("<td>" + user.getZip() + "</td>");
	}

	private void write(AccountData account, PrintWriter pr) {
		pr.println("<td>" + account.getId().getNumber() + "</td>");
		pr.println("<td>" + account.getName1() + "</td>");
		pr.println("<td>" + account.getAccountStatus() + "</td>");
		pr.println("<td>" + account.getAccountType() + "</td>");
	}

}
