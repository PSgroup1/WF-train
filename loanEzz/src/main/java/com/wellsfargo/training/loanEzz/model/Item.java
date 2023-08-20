package com.wellsfargo.training.loanEzz.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Item {
    


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long pid;
    
    private String ItemDescription;
    private char ItemStatus;
    private int ItemValue;
    private String ItemMake;
    private String ItemCategory;
    
//    @OneToMany(cascade=CascadeType.ALL)
//	private List<EmployeeIssueDetails> employeeIssueDetails;
    
    public Item() {
        // TODO Auto-generated constructor stub
    }
    
    
    public Item(Long pid, int ItemValue, String ItemDescription,String ItemMake, String ItemCategory, char ItemStatus) {
    
        this.pid = pid;
        this.ItemStatus = ItemStatus;
        this.ItemDescription = ItemDescription;
        this.ItemValue = ItemValue;
        this.ItemMake= ItemMake;
        this.ItemCategory=ItemCategory;
        
    }

  

    public Long getPid() {
        return pid;
    }
    public void setPid(Long pid) {
        this.pid = pid;
    }
    public String getItemDescription() {
        return ItemDescription;
    }
    public void setItemDescription(String ItemDescription) {
        this.ItemDescription = ItemDescription;
    }
    public int getItemValue() {
        return ItemValue;
    }
    public void setItemValue(int ItemValue) {
        this.ItemValue = ItemValue;
    }


	public char getItemStatus() {
		return ItemStatus;
	}


	public void setItemStatus(char ItemStatus) {
		this.ItemStatus = ItemStatus;
	}


	public String getItemMake() {
		return ItemMake;
	}


	public void setItemMake(String itemMake) {
		ItemMake = itemMake;
	}


	public String getItemCategory() {
		return ItemCategory;
	}


	public void setItemCategory(String itemCategory) {
		ItemCategory = itemCategory;
	}
    
    
    
    
    
}
