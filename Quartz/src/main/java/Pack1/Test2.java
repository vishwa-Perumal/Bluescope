package Pack1;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Test2 {

	public static void main(String[] args) throws SchedulerException {
		  System.out.println("Scheduler Starting...");

	        // 1️⃣ Create Job
	        JobDetail job = JobBuilder.newJob(QuartzRun.class)
	                .withIdentity("MyJob", "Group1")
	                .build();

	        // 2️⃣ Create Trigger (runs every 2 seconds forever)
	        Trigger trigger = TriggerBuilder.newTrigger()
	                .withIdentity("SimpleTrigger", "Group1")
	                .withSchedule(
	                        SimpleScheduleBuilder.simpleSchedule()
	                                .withIntervalInSeconds(2)
	                                .repeatForever()
	                )
	                .startNow()
	                .build();

	        // 3️⃣ Create Scheduler
	        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

	        // 4️⃣ Schedule Job
	        scheduler.scheduleJob(job, trigger);

	        // 5️⃣ Start Scheduler
	        scheduler.start();

	        System.out.println("Scheduler Started...");

	}

}
