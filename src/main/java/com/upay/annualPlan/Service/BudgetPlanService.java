package com.upay.annualPlan.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upay.annualPlan.Entity.AnnualPlan;
import com.upay.annualPlan.Entity.BudgetPlan;
import com.upay.annualPlan.Repository.BudgetPlanRepository;

@Service
public class BudgetPlanService {
	@Autowired
	private BudgetPlanRepository budgetPlanRepo;
	public List<BudgetPlan> getAll() {
		return budgetPlanRepo.findAll();
	}
	
	public BudgetPlan getBudgetofSBH(String sbh) {
		return budgetPlanRepo.findBySubBudgetHead(sbh);
	}
	
	public int findQuarter(int month) {
		if(month < 3)
			return 4;
		if(month < 6)
			return 1;
		if(month < 9)
			return 2;
		else
			return 3;
	}
	
	public void save(AnnualPlan plan) {
		String sbh = plan.getSubBudgetHead();
		BudgetPlan budgetPlan = getBudgetofSBH(sbh);
		int quarter = findQuarter(plan.getMonth());
		int fund = plan.getFund();
		if(budgetPlan == null)
		{
			budgetPlan = new BudgetPlan(0,0,0,0,plan.getSubBudgetHead());
			if(quarter == 1)
				budgetPlan.setQuarter1(fund);
			else if(quarter == 2)
				budgetPlan.setQuarter2(fund);
			else if(quarter == 3)
				budgetPlan.setQuarter3(fund);
			else
				budgetPlan.setQuarter4(fund);
		}
		else
		{
			if(quarter == 1)
			{
				fund += budgetPlan.getQuarter1();
				budgetPlan.setQuarter1(fund);
			}
			else if(quarter == 2)
			{
				fund += budgetPlan.getQuarter2();
				budgetPlan.setQuarter2(fund);
			}
			else if(quarter == 3)
			{
				fund += budgetPlan.getQuarter3();
				budgetPlan.setQuarter3(fund);
			}
			else
			{
				fund += budgetPlan.getQuarter3();
				budgetPlan.setQuarter4(fund);
			}
		}
		budgetPlanRepo.save(budgetPlan);
	}
	
}
