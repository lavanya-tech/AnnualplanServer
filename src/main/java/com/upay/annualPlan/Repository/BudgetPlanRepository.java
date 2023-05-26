package com.upay.annualPlan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upay.annualPlan.Entity.BudgetPlan;

public interface BudgetPlanRepository extends JpaRepository<BudgetPlan, Long> {

	BudgetPlan findBySubBudgetHead(String sbh);
}
