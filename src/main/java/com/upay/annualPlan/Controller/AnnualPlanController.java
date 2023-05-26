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
import com.upay.annualPlan.Repository.AnnualPlanRepository;
import com.upay.annualPlan.Service.BudgetPlanService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/annualplan")
public class AnnualPlanController {
	@Autowired
	private AnnualPlanRepository annualPlanRepo;
	@Autowired
	private BudgetPlanService budgetPlanService;
	
	@GetMapping
	public List<AnnualPlan> getallplans() {
		return annualPlanRepo.findAll();
	}

	@GetMapping("/{id}")
	public Optional<AnnualPlan> getplan(@PathVariable long id) {
		return annualPlanRepo.findById(id);
	}
	
	@GetMapping("/type/{type}")
	public List<AnnualPlan> getallplansoftype(@PathVariable String type) {
		return annualPlanRepo.findByType(type);
	}
	
	@GetMapping("/bhead/{budgethead}")
	public List<AnnualPlan> getallplansofbudgethead(@PathVariable String budgethead){
		return annualPlanRepo.findByBudgetHead(budgethead);
	}
	
	@GetMapping("/sbhead/{subbudgethead}")
	public List<AnnualPlan> getallplansofsubbudgethead(@PathVariable String subbudgethead){
		return annualPlanRepo.findBySubBudgetHead(subbudgethead);
	}
	
	@PostMapping
	public void saveplan(@RequestBody AnnualPlan plan) {
		annualPlanRepo.save(plan);
		budgetPlanService.save(plan);
	}
	
	@PutMapping("/{id}")
	public void updateplan(@PathVariable long id,@RequestBody AnnualPlan plan) {
		Optional<AnnualPlan> existingPlan = annualPlanRepo.findById(id);
		if(existingPlan != null)
		{
			existingPlan.get().setBudgetHead(plan.getBudgetHead());
			existingPlan.get().setDate(plan.getDate());
			existingPlan.get().setSubBudgetHead(plan.getSubBudgetHead());
			existingPlan.get().setMonth(plan.getMonth());
			existingPlan.get().setFund(plan.getFund());
			existingPlan.get().setProjectedImpact(plan.getProjectedImpact());
			existingPlan.get().setType(plan.getType());
			annualPlanRepo.save(existingPlan.get());
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteplan(@PathVariable long id) {
		annualPlanRepo.deleteById(id);
	}
}
