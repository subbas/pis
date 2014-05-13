package com.pis.timer;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
 
/*public class RunMyJob extends QuartzJobBean {
	private RunMyTask runMyTask;
 
	public void setRunMeTask(RunMyTask runMyTask) {
		this.runMyTask = runMyTask;
	}
 
	protected void executeInternal(JobExecutionContext context)
		throws JobExecutionException {
 
		runMyTask.zalohujDB();
 
	}
}*/

public class RunMyJob {
	public void sampleMethod() {
		System.out.println("zalohujem..");
	}
}