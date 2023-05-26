package com.upay.annualPlan.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upay.annualPlan.Entity.AnnualPlan;

public interface AnnualPlanRepository extends JpaRepository<AnnualPlan, Long> {

	List<AnnualPlan> findByType(String type);

	List<AnnualPlan> findByBudgetHead(String budgethead);

	List<AnnualPlan> findBySubBudgetHead(String subbudgethead);

}
