package com.crm.logicq.service.readfile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
@PropertySource("classpath:scheduler.properties")
public class QuartzConfiguration {

	@Value("${scheduler.intime}")
	private String inTime;
	@Value("${scheduler.outtime}")
	private String outTime;
	@Value("${scheduler.specialmsgtime}")
	private String specialmsgTime;
	int startTimeHr;
	int startTimeMin;

	@Bean
	public MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBeanInTime() {

		MethodInvokingJobDetailFactoryBean obj = new MethodInvokingJobDetailFactoryBean();
		obj.setTargetBeanName("ScheduleService");
		obj.setTargetMethod("readAccessFile");
		return obj;
	}

	@Bean
	public MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBeanOutTime() {
		MethodInvokingJobDetailFactoryBean obj = new MethodInvokingJobDetailFactoryBean();
		obj.setTargetBeanName("ScheduleService");
		obj.setTargetMethod("readAccessFile");
		return obj;
	}

	@Bean
	public MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactorySpecial() {
		MethodInvokingJobDetailFactoryBean obj = new MethodInvokingJobDetailFactoryBean();
		obj.setTargetBeanName("ScheduleService");
		obj.setTargetMethod("performTask");
		return obj;
		
	}

	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBeanInTime() {

		System.out.println("in Time is " + inTime);
		int jobStartTime = Integer.valueOf(inTime);
		startTimeHr = jobStartTime / 100;
		startTimeMin = jobStartTime % 100;
		CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
		stFactory.setJobDetail(methodInvokingJobDetailFactoryBeanInTime().getObject());
		stFactory.setStartDelay(3000);
		stFactory.setName("mytriggerInTime");
		stFactory.setGroup("mygroupInTime");
		stFactory.setCronExpression("0 " + startTimeMin + " " + startTimeHr + " ? * MON-SUN *");
		return stFactory;
	}

	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBeanOutTime() {

		System.out.println("outTime is " + outTime);
		int jobStartTime = Integer.valueOf(outTime);
		startTimeHr = jobStartTime / 100;
		startTimeMin = jobStartTime % 100;
		CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
		stFactory.setJobDetail(methodInvokingJobDetailFactoryBeanOutTime().getObject());
		stFactory.setStartDelay(3000);
		stFactory.setName("mytriggerOutTime");
		stFactory.setGroup("mygroupOutTime");
		//stFactory.setCronExpression("0 13 12 ? * MON-SUN *");
		stFactory.setCronExpression("0 " + startTimeMin + " " + startTimeHr + " ? * MON-SUN *");
		return stFactory;
	}

	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBeanSpecial() {

		System.out.println("SpecialTime is " + specialmsgTime);
		int specialJobTime = Integer.valueOf(specialmsgTime);
		startTimeHr = specialJobTime / 100;
		startTimeMin = specialJobTime % 100;
		CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
		stFactory.setJobDetail(methodInvokingJobDetailFactorySpecial().getObject());
		stFactory.setStartDelay(3000);
		stFactory.setName("mytriggerSpecialTime");
		stFactory.setGroup("mygroupSpecialTime");
		//stFactory.setCronExpression("0 33 22 ? * MON-SUN *");
		stFactory.setCronExpression("0 0/3 * * * ?");
		//stFactory.setCronExpression("0 " + startTimeMin + " " + startTimeHr + " ? * MON-SUN *");
		return stFactory;
	}

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {

		SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
		scheduler.setTriggers(cronTriggerFactoryBeanInTime().getObject(),
		                      cronTriggerFactoryBeanOutTime().getObject(),
		                      cronTriggerFactoryBeanSpecial().getObject());
		return scheduler;
	}
}
