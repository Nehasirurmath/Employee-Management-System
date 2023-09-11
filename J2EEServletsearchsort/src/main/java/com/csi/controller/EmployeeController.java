package com.csi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Employee employee = new Employee();
	EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();

	public static final String SIGNUP_PAGE = "/signup.jsp";
	public static final String SIGNIN_PAGE = "/signin.jsp";
	public static final String SHOWDATA_PAGE = "/show.jsp";
	public static final String UPDATEDATA_PAGE = "/edit.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String redirect = "";
		String empId = request.getParameter("empid");
		String action = request.getParameter("action");

		if (action.equals("signup") && empId != null) {
			int employeeId = Integer.valueOf(empId);
			String empName = request.getParameter("empname");
			String empAddress = request.getParameter("empaddress");
			String empState = request.getParameter("empstate");
			double empSalary = Double.valueOf(request.getParameter("empsalary"));
			long empContactNumber = Integer.valueOf(request.getParameter("empcontactnumber"));
			String empGender = request.getParameter("empgender");
			String empDept = "";
			String dept[] = request.getParameterValues("empdept");
			for (int i = 0; i < dept.length; i++) {
				empDept += dept[i] + "";
			}
			Date empDob = null;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				empDob = simpleDateFormat.parse(request.getParameter("empdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long empUID = Long.valueOf(request.getParameter("empuid"));
			String empPanCard = request.getParameter("emppancard");
			String empEmailId = request.getParameter("empemailid");
			String empPassword = request.getParameter("emppassword");
			Employee employee=new Employee(employeeId, empName, empAddress, empState, empSalary, empContactNumber, empGender, empDept, empDob, empUID, empPanCard, empEmailId, empPassword);
			employeeServiceImpl.signUp(employee);
			redirect = SIGNIN_PAGE;

		} else if (action.equals("signin")) {
			String empEmailId = request.getParameter("empemailid");
			String empPassword = request.getParameter("emppassword");
			if(employeeServiceImpl.signIn(empEmailId, empPassword))
			{
				request.setAttribute("emplist", employeeServiceImpl.findAll());
				redirect = SHOWDATA_PAGE;
			}else {
				request.setAttribute("message", "invalid credentials");
				redirect=SIGNIN_PAGE;
			}
			
			
		} else if (action.equals("edit_form")) {
			redirect=UPDATEDATA_PAGE;

		} else if (action.equals("edit")) {
			int employeeId = Integer.valueOf(request.getParameter("empid"));
			String empName = request.getParameter("empname");
			String empAddress = request.getParameter("empaddress");
			String empState = request.getParameter("empstate");
			double empSalary = Double.valueOf(request.getParameter("empsalary"));
			long empContactNumber = Integer.valueOf(request.getParameter("empcontactnumber"));
			String empGender = request.getParameter("empgender");
			String empDept = "";
			String dept[] = request.getParameterValues("empdept");
			for (int i = 0; i < dept.length; i++) {
				empDept += dept[i] + " ";
			}
			Date empDob = null;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				empDob = simpleDateFormat.parse(request.getParameter("empdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			long empUID = Long.valueOf(request.getParameter("empuid"));
			String empPanCard = request.getParameter("emppancard");
			String empEmailId = request.getParameter("empemailid");
			String empPassword = request.getParameter("emppassword");
			Employee employee=new Employee(employeeId, empName, empAddress, empState, empSalary, empContactNumber, empGender, empDept, empDob, empUID, empPanCard, empEmailId, empPassword);
			employeeServiceImpl.updateData(employeeId, employee);
			request.setAttribute("emplist", employeeServiceImpl.findAll());
			redirect=SHOWDATA_PAGE;
			

		} else if (action.equals("deletebyid")) {
			
			int employeeId = Integer.valueOf(request.getParameter("empid"));
			employeeServiceImpl.deleteById(employeeId);
			request.setAttribute("emplist",employeeServiceImpl.findAll());
			redirect=SHOWDATA_PAGE;

		} else if (action.equals("deletealldata")) {
			employeeServiceImpl.deleteAll();
			request.setAttribute("emplist",employeeServiceImpl.findAll());
			redirect=SHOWDATA_PAGE;

		} else if (action.equals("sortbyid")) {
			request.setAttribute("emplist",employeeServiceImpl.findAll().stream().sorted(Comparator.comparingInt(Employee::getEmpId)).collect(Collectors.toList()));
			redirect=SHOWDATA_PAGE;

		} else if (action.equals("sortbyname")) {
			request.setAttribute("emplist",employeeServiceImpl.findAll().stream().sorted(Comparator.comparing(Employee::getEmpName)).collect(Collectors.toList()));
			redirect=SHOWDATA_PAGE;

		} else if (action.equals("sortbysalary")) {
			request.setAttribute("emplist",employeeServiceImpl.findAll().stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary)).collect(Collectors.toList()));
			redirect=SHOWDATA_PAGE;
			

		} else if (action.equals("sortbydob")) {
			request.setAttribute("emplist",employeeServiceImpl.findAll().stream().sorted(Comparator.comparing(Employee::getEmpDob)).collect(Collectors.toList()));
			redirect=SHOWDATA_PAGE;

		} else if (action.equals("sortbygender")) {
			request.setAttribute("emplist",employeeServiceImpl.findAll().stream().sorted(Comparator.comparing(Employee::getEmpGender)).collect(Collectors.toList()));
			redirect=SHOWDATA_PAGE;

		} else if (action.equals("searchbyid")) {
			int employeeId = Integer.valueOf(request.getParameter("empid"));
			request.setAttribute("emplist",employeeServiceImpl.findAll().stream().filter(emp->emp.getEmpId()==employeeId).collect(Collectors.toList()));
			redirect=SHOWDATA_PAGE;

		} else if (action.equals("searchbyname")) {
			String empName = request.getParameter("empname");
			request.setAttribute("emplist",employeeServiceImpl.findAll().stream().filter(emp->emp.getEmpName().equals(empName)).collect(Collectors.toList()));
			redirect=SHOWDATA_PAGE;

		} else if (action.equals("searchbyemail")) {
			String empEmailId = request.getParameter("empemailid");
			request.setAttribute("emplist",employeeServiceImpl.findAll().stream().filter(emp->emp.getEmpEmailId().equals(empEmailId)).collect(Collectors.toList()));
			redirect=SHOWDATA_PAGE;

		} else if (action.equals("searchbycontactnumber")) {
			long empContactNumber = Integer.valueOf(request.getParameter("empcontactnumber"));

			request.setAttribute("emplist",employeeServiceImpl.findAll().stream().filter(emp->emp.getEmpContactNumber()==empContactNumber).collect(Collectors.toList()));
			redirect=SHOWDATA_PAGE;

		} else if (action.equals("searchbyuid")) {
			long empUID = Long.valueOf(request.getParameter("empuid"));
			request.setAttribute("emplist",employeeServiceImpl.findAll().stream().filter(emp->emp.getEmpUID()==empUID).collect(Collectors.toList()));
			redirect=SHOWDATA_PAGE;

		} else if (action.equals("searchbypancard")) {
			String empPanCard = request.getParameter("emppancard");
			request.setAttribute("emplist",employeeServiceImpl.findAll().stream().filter(emp->emp.getEmpPanCard().equals(empPanCard)).collect(Collectors.toList()));
			redirect=SHOWDATA_PAGE;

		} else if (action.equals("filterbysalary")) {
			double empSalary = Double.valueOf(request.getParameter("empsalary"));
			request.setAttribute("emplist",employeeServiceImpl.findAll().stream().filter(emp->emp.getEmpSalary()==empSalary).collect(Collectors.toList()));
			redirect=SHOWDATA_PAGE;

		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(redirect);
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		

	}

}
