package com.upay.annualPlan.Entity;

import java.util.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "annualplan")
public class AnnualPlan {

	@Id
	@GeneratedValue
	private long id;
	@Nonnull
	@Column(nullable = false)
	private String type;
	@Nonnull
	@Column(nullable = false)
	private String budgetHead;
	private String subBudgetHead;
	@Nonnull
	@Column(nullable = false)
	private int month;
	private Date date;
	private String projectedImpact;
	private int fund;
	@Nonnull
	@Column(nullable = false)
	private String Description;
	public AnnualPlan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnnualPlan(long id, String type, String budgetHead, String subBudgetHead, int month, Date date,
			String projectedImpact, int fund, String description) {
		super();
		this.id = id;
		this.type = type;
		this.budgetHead = budgetHead;
		this.subBudgetHead = subBudgetHead;
		this.month = month;
		this.date = date;
		this.projectedImpact = projectedImpact;
		this.fund = fund;
		Description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBudgetHead() {
		return budgetHead;
	}
	public void setBudgetHead(String budgetHead) {
		this.budgetHead = budgetHead;
	}
	public String getSubBudgetHead() {
		return subBudgetHead;
	}
	public void setSubBudgetHead(String subBudgetHead) {
		this.subBudgetHead = subBudgetHead;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getProjectedImpact() {
		return projectedImpact;
	}
	public void setProjectedImpact(String projectedImpact) {
		this.projectedImpact = projectedImpact;
	}
	public int getFund() {
		return fund;
	}
	public void setFund(int fund) {
		this.fund = fund;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
}
