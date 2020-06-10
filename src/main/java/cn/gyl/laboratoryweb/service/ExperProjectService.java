package cn.gyl.laboratoryweb.service;

import java.util.List;

import cn.gyl.laboratoryweb.model.ExperimentalProject;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
public interface ExperProjectService extends BaseService<ExperimentalProject> {

	/**
	 * @Decription
	 */
	Pager<ExperimentalProject> getPagerExperimentalProjects(String experimentalProjectName);

	/**
	 * @Decription
	 */
	List<ExperimentalProject> getAllExperimentalProjects();

	/**
	 * @return 
	 * @Decription
	 */
	ExperimentalProject getOneByAccount(long Account);

	/**
	 * @Decription
	 */
	List<ExperimentalProject> getExperProjectByLabId(int labId);

}
