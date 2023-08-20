package com.wellsfargo.training.loanEzz.model;

public class InputLoan {
	private Long employeeId;
	private String itemCategory;
	private String itemMake;
	private String itemDescription;
	private int itemValue;
	public InputLoan(Long employeeId, String itemCategory, String itemMake, String itemDescription, int itemValue) {
		this.employeeId = employeeId;
		this.itemCategory = itemCategory;
		this.itemMake = itemMake;
		this.itemDescription = itemDescription;
		this.itemValue = itemValue;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public String getItemMake() {
		return itemMake;
	}
	public void setItemMake(String itemMake) {
		this.itemMake = itemMake;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public int getItemValue() {
		return itemValue;
	}
	public void setItemValue(int itemValue) {
		this.itemValue = itemValue;
	}
	
	
}
