package com.darthmaximus.homesearch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.darthmaximus.homesearch.models.AlertsModel;
import com.darthmaximus.homesearch.models.FloorPlan;
import com.darthmaximus.homesearch.services.FloorPlanService;

@Controller
@RequestMapping("/web")
public class HomeController {
	@Autowired private FloorPlanService floorPlanService;
	
	@RequestMapping(path={"/homes","/homes/"}, method={RequestMethod.GET})
	public String index(Model model) {
		model.addAttribute("floorPlans", floorPlanService.findAll());
		return "homes/index";
	}
	
	@RequestMapping(path={"/homes/{plan}", "/homes/{plan}/"}, method={RequestMethod.GET})
	public String view(@PathVariable(name="plan") String plan, Model model) {
		FloorPlan floorPlan = floorPlanService.findByName(plan);
		if (floorPlan != null) {
			model.addAttribute("floorPlan", floorPlan);
			return "homes/view";
		}
		return "homes/index";
	}

	@RequestMapping(path={"/homes/{plan}","/homes/{plan}/"}, method={RequestMethod.POST}, params="enable")
	public String enable(@PathVariable(name="plan") String plan, Model model, FloorPlan floorPlan, RedirectAttributes redirectAttributes) {
		return toggle(model, plan, true, redirectAttributes);
	}

	@RequestMapping(path={"/homes/{plan}","/homes/{plan}/"}, method={RequestMethod.POST}, params="disable")
	public String disable(@PathVariable(name="plan") String plan, Model model, FloorPlan floorPlan, RedirectAttributes redirectAttributes) {
		return toggle(model, plan, false, redirectAttributes);
	}
	
	private String toggle(Model model, String plan, boolean enabled, RedirectAttributes redirectAttributes) {
		FloorPlan result = floorPlanService.toggle(plan, enabled);
		if (result != null && result.getEnabled().booleanValue() == enabled) {
			redirectAttributes.addFlashAttribute("alerts", new AlertsModel("success", "Successfully updated floor plan " + result.getName() + "!"));
			return "redirect:/web/homes/" + result.getName();
		}
		redirectAttributes.addFlashAttribute("alerts", new AlertsModel("danger", "An error occurred while updating floor plan!"));
		return "redirect:/web/homes";
	}
}
