package com.capgemini.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.bankapp.exception.BankAccountIdNotFoundException;
import com.capgemini.bankapp.exception.LowBalanceException;
import com.capgemini.bankapp.model.BankAccount;
import com.capgemini.bankapp.service.BankAccountService;
import com.capgemini.bankapp.service.impl.BankAccountServiceImpl;

@WebServlet(urlPatterns = { "*.do" }, loadOnStartup = 1)
public class BankAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BankAccountService bankService;

	public BankAccountController() {
		bankService = new BankAccountServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String path = request.getServletPath();
		if (path.equals("/Account.do")) {
			List<BankAccount> bankAccounts = bankService.findAllBankAccount();
			RequestDispatcher dispatcher = request.getRequestDispatcher("Account.jsp");
			request.setAttribute("accounts", bankAccounts);
			dispatcher.forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String path = request.getServletPath();
		System.out.println(path);

		if (path.equals("/addNewBankAccount.do")) {
			String accountHolderName = request.getParameter("accountHolderName");
			String accountType = request.getParameter("accountType");
			double accountBalance = Double.parseDouble(request.getParameter("accountBalance"));

			BankAccount account = new BankAccount(accountHolderName, accountType, accountBalance);

			if (bankService.addNewBankAccount(account)) {
				out.println("<h2>Bank Account is Created Succesfully....!");
				out.println("<h3><a href=Index.html>Home</a>");
				out.close();
			}

		}
		if (path.equals("/withdrawAccount.do")) {
			long accountId = Long.parseLong(request.getParameter("accountId"));
			double amount = Double.parseDouble(request.getParameter("amount"));

			try {
				double balance = bankService.withdraw(accountId, amount);
				out.println("<h2>Amount is withdrawn Succesfully....!");
				out.println("<h3>Your balnce is");
				out.println(balance);
				out.println("<h3><a href=Index.html>Home</a>");
				out.close();

			} catch (LowBalanceException e) {
				out.println("<h2>You dont have sufficient balance....!");
				out.println("<h3><a href=Index.html>Home</a>");
				out.close();

			} catch (BankAccountIdNotFoundException e) {
				out.println("<h2>Account Id not found....!");
				out.println("<h3><a href=Index.html>Home</a>");
				out.close();
			}
		}
		if (path.equals("/depositAccount.do")) {
			long accountId = Long.parseLong(request.getParameter("accountId"));
			double amount = Double.parseDouble(request.getParameter("amount"));

			try {
				double balance = bankService.deposit(accountId, amount);
				out.println("<h2>Amount is deposited Succesfully....!");
				out.println("<h3>Your balnce is");
				out.println(balance);
				out.println("<h3><a href=Index.html>Home</a>");
				out.close();

			} catch (BankAccountIdNotFoundException e) {
				out.println("<h2>Account Id not found....!");
				out.println("<h3><a href=Index.html>Home</a>");
				out.close();
			}
		}
		if (path.equals("/accountFundTransfer.do")) {
			long fromAccountId = Long.parseLong(request.getParameter("fromAccount"));
			long toAccountId = Long.parseLong(request.getParameter("toAccount"));
			double amount = Double.parseDouble(request.getParameter("amount"));

			try {
				bankService.fundTransfer(fromAccountId, toAccountId, amount);
				out.println("<h2>Amount is transfered Succesfully....!");
				out.println("<h3>Your balance is");
				out.println(bankService.checkBalance(fromAccountId));
				out.println("<h3><a href=Index.html>Home</a>");
				out.close();

			} catch (LowBalanceException e) {
				out.println("<h2>You dont have sufficient balance....!");
				out.println("<h3><a href=Index.html>Home</a>");
				out.close();

			} catch (BankAccountIdNotFoundException e) {
				out.println("<h2>Account Id not found....!");
				out.println("<h3><a href=Index.html>Home</a>");
				out.close();
			}
		}
		if (path.equals("/checkBalance.do")) {
			long accountId = Long.parseLong(request.getParameter("accountId"));

			try {
				double balance = bankService.checkBalance(accountId);
				out.println("<h2>Your balance is....!");
				out.println(balance);
				out.println("<h3><a href=Index.html>Home</a>");
				out.close();

			} catch (BankAccountIdNotFoundException e) {
				out.println("<h2>Account Id not found....!");
				out.println("<h3><a href=Index.html>Home</a>");
				out.close();
			}
		}
		if (path.equals("/deleteAccount.do")) {
			long accountId = Long.parseLong(request.getParameter("accountId"));

			try {
				bankService.deleteBankAccount(accountId);
				out.println("<h2>Account is deleted....!");
				out.println("<h3><a href=Index.html>Home</a>");
				out.close();

			} catch (BankAccountIdNotFoundException e) {
				out.println("<h2>Account Id not found....!");
				out.println("<h3><a href=Index.html>Home</a>");
				out.close();
			}
		}
		if (path.equals("/SearchAccount.do")) {
			long accountId = Long.parseLong(request.getParameter("accountId"));

			try {
				BankAccount bankAccount = bankService.searchBankAccount(accountId);
				RequestDispatcher dispatcher = request.getRequestDispatcher("SearchAccount.jsp");
				request.setAttribute("account", bankAccount);
				dispatcher.forward(request, response);
			} catch (BankAccountIdNotFoundException e) {
				out.println("<h2>Account Id not found....!");
				out.println("<h3><a href=Index.html>Home</a>");
				out.close();
			}

		}
		if (path.equals("/fetchDetails.do")) {
			long accountId = Long.parseLong(request.getParameter("accountId"));

			try {
				BankAccount bankAccount = bankService.searchBankAccount(accountId);
				RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateAccount.jsp");
				request.setAttribute("account", bankAccount);
				dispatcher.forward(request, response);

			} catch (BankAccountIdNotFoundException e) {
				out.println("<h2>Account Id not found....!");
				out.println("<h3><a href=Index.html>Home</a>");
				out.close();
			}
		}
		if (path.equals("/updateDetails.do")) {
			String accountHolderName = request.getParameter("accountHolderName");
			String accountType = request.getParameter("accountType");
			long accountId = Long.parseLong(request.getParameter("accountId"));
			try {
				
				boolean result = bankService.updateBankAccountDetails(accountId, accountHolderName, accountType);
				if(result) {
					out.println("<h2>Updated Successfully");
					out.println("<h2> <a href='Index.html'>Home</h2>");
				}
				else
				{
					out.println("<h2>Not Updated");
				}
			} catch (BankAccountIdNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
