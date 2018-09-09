package maneger.ServiceInteerface;

import baseService.baseUCService;

import java.util.List;

import Entity.Experiment;

public interface ExperimentUCService extends baseUCService<Experiment>
{
	public List<Experiment> exp_status();
	public void Exp_Confirm(Experiment exp);
	
	
}
