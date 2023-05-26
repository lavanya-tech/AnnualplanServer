package com.upay.annualPlan.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upay.annualPlan.Entity.AnnualPlan;
import com.upay.annualPlan.Entity.BudgetPlan;
import com.upay.annualPlan.Repository.AnnualPlanRepository;
import com.upay.annualPlan.Service.BudgetPlanService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/budgetplan")
public class BudgetPlanController {
	@Autowired
	private BudgetPlanService budgetPlanService;
	
	@GetMapping
	public List<BudgetPlan> getallplans() {
		return budgetPlanService.getAll();
	}

	@PostMapping
	public void saveplan(@RequestBody AnnualPlan plan) {
		budgetPlanService.save(plan);
	}
}
