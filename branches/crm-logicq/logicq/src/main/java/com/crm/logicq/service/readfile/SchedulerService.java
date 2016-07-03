package com.crm.logicq.service.readfile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.logicq.dao.readfile.ReadFile;
import com.crm.logicq.model.user.CardReadDetails;

@Service("ScheduleService")
public class SchedulerService {

	private ReadFile readFile;

	@Autowired
	public void setReadFile(ReadFile readFile) {

		this.readFile = readFile;
	}

	public ReadFile getReadFile() {

		return readFile;
	}

	public void readAccessFileInTime() {

		List<CardReadDetails> inTimeList = readFile.readAccessFileInTime();
	}

	public void readAccessFileOutTime() {

		List<CardReadDetails> outTimeList = readFile.readAccessFileOutTime();
	}

	public void specialJobTime() {

		readFile.specialJob();
	}
}
/**
 * NIHAR 04-Jul-2016 1:37:33 am
 */
