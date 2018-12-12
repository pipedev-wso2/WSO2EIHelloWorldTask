package org.wso2.samples.synapse.extension;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.ManagedLifecycle;
import org.apache.synapse.core.SynapseEnvironment;
import org.apache.synapse.task.Task;


public class HelloWorldTask implements Task, ManagedLifecycle {
	private Log log = LogFactory.getLog(HelloWorldTask.class);
	private SynapseEnvironment synapseEnvironment;
	private String myProp = "";
	
	public void execute() {
		log.info("HelloWorldTask");
		 
		if (synapseEnvironment == null) {
			log.error("Synapse Environment not set");
			return;    
		}	
		
		log.info("myProp: " + this.myProp);
	}
		
	public void destroy() {
		log.info("HelloWorldTask:destroy");
	}
	 
	public void init(SynapseEnvironment synapseEnvironment) {
		this.synapseEnvironment = synapseEnvironment;
		log.info("HelloWorldTask:init");
	}
	 
	public SynapseEnvironment getSynapseEnvironment() {
		return synapseEnvironment;
	}
	 
	public void setSynapseEnvironment(SynapseEnvironment synapseEnvironment) {
		this.synapseEnvironment = synapseEnvironment;
	}

	public String getMyPrope() {
		return myProp;
	}
		 
	public void setMyProp(String myProp) {
		this.myProp = myProp;
	}

}
