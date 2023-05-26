package com.upay.annualPlan.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "budgetplan")
public class BudgetPlan {
	private long quarter1;
	private long quarter2;
	private long quarter3;
	private long quarter4;
	@Id
	private String subBudgetHead;
	public BudgetPlan() {
		super();
	}
	public BudgetPlan(long quarter1, long quarter2, long quarter3, long quarter4, String subBudgetHead) {
		super();
		this.quarter1 = quarter1;
		this.quarter2 = quarter2;
		this.quarter3 = quarter3;
		this.quarter4 = quarter4;
		this.subBudgetHead = subBudgetHead;
	}
	public long getQuarter1() {
		return quarter1;
	}
	public void setQuarter1(long quarter1) {
		this.quarter1 = quarter1;
	}
	public long getQuarter2() {
		return quarter2;
	}
	public void setQuarter2(long quarter2) {
		this.quarter2 = quarter2;
	}
	public long getQuarter3() {
		return quarter3;
	}
	public void setQuarter3(long quarter3) {
		this.quarter3 = quarter3;
	}
	public long getQuarter4() {
		return quarter4;
	}
	public void setQuarter4(long quarter4) {
		this.quarter4 = quarter4;
	}
	public String getSubBudgetHead() {
		return subBudgetHead;
	}
	public void setSubBudgetHead(String subBudgetHead) {
		this.subBudgetHead = subBudgetHead;
	}
	
}
