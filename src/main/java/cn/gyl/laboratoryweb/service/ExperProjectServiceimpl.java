package cn.gyl.laboratoryweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gyl.laboratoryweb.dao.ExperProjectDao;
import cn.gyl.laboratoryweb.model.ExperimentalProject;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Service("experProjectService")
public class ExperProjectServiceimpl extends BaseServiceimpl<ExperimentalProject> implements ExperProjectService {

	@Autowired
	private ExperProjectDao experProject;

	@Override
	public Pager<ExperimentalProject> getPagerExperimentalProjects(String experimentalProjectName) {
		return experProject.getPagerExperimentalProjects(experimentalProjectName);
	}

	@Override
	public List<ExperimentalProject> getAllExperimentalProjects() {
		return experProject.getAllExperimentalProjects();
	}

	@Override
	public ExperimentalProject getOneByAccount(long Account) {
		return experProject.getOneByAccount(Account);

	}

	@Override
	public List<ExperimentalProject> getExperProjectByLabId(int labId) {
		return experProject.getExperProjectByLabId(labId);
	}

}
