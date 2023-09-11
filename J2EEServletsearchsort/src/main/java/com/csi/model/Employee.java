package com.csi.model;

import java.util.Date;

public class Employee {

	private int empId;
	private String empName;
	private String empAddress;
	private String empState;
	private double empSalary;
	private long empContactNumber;
	private String empGender;
	private String empDept;
	private Date empDob;
	private long empUID;
	private String empPanCard;
	private String empEmailId;
	private String empPassword;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String empName, String empAddress, String empState, double empSalary,
			long empContactNumber, String empGender, String empDept, Date empDob, long empUID, String empPanCard,
			String empEmailId, String empPassword) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
		this.empState = empState;
		this.empSalary = empSalary;
		this.empContactNumber = empContactNumber;
		this.empGender = empGender;
		this.empDept = empDept;
		this.empDob = empDob;
		this.empUID = empUID;
		this.empPanCard = empPanCard;
		this.empEmailId = empEmailId;
		this.empPassword = empPassword;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpState() {
		return empState;
	}

	public void setEmpState(String empState) {
		this.empState = empState;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public long getEmpContactNumber() {
		return empContactNumber;
	}

	public void setEmpContactNumber(long empContactNumber) {
		this.empContactNumber = empContactNumber;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public String getEmpDept() {
		return empDept;
	}

	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}

	public Date getEmpDob() {
		return empDob;
	}

	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}

	public long getEmpUID() {
		return empUID;
	}

	public void setEmpUID(long empUID) {
		this.empUID = empUID;
	}

	public String getEmpPanCard() {
		return empPanCard;
	}

	public void setEmpPanCard(String empPanCard) {
		this.empPanCard = empPanCard;
	}

	public String getEmpEmailId() {
		return empEmailId;
	}

	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", empState="
				+ empState + ", empSalary=" + empSalary + ", empContactNumber=" + empContactNumber + ", empGender="
				+ empGender + ", empDept=" + empDept + ", empDob=" + empDob + ", empUID=" + empUID + ", empPanCard="
				+ empPanCard + ", empEmailId=" + empEmailId + ", empPassword=" + empPassword + "]";
	}

}
