package com.vishwa;

public class GetPlanFactory {
	
	Plan plan=null;
	public Plan getPlanType(String planType)
	{
		if(planType==null)
		{
			plan=null;
		}
		else if(planType.equalsIgnoreCase("DomesticPlan")){
			plan=new DomesticPlan();
		}
		else if(planType.equalsIgnoreCase("CommercialPlan"))
		{
			plan=new CommercialPlan();
		}
		else if(planType.equalsIgnoreCase("Institutional"))
		{
			plan=new InstitutionalPlan();
		}
		return plan;
	}
}
