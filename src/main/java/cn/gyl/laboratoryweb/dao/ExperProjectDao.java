package cn.gyl.laboratoryweb.dao;

import java.util.List;

import cn.gyl.laboratoryweb.model.ExperimentalProject;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription 项目信息数据库访问类接口
 * @authorEmail 1076030424@qq.com
 */
public interface ExperProjectDao extends BaseDao<ExperimentalProject> {
	
	/**
	 * @Decription 获取分页项目信息数据
	 */
	public Pager<ExperimentalProject> getPagerExperimentalProjects(String experimentalProjectName);

	/**
	 * @Decription 湖区所有项目信息
	 */
	public List<ExperimentalProject> getAllExperimentalProjects();

	/**
	 * @Decription 通过项目编号获取一个实验项目
	 */
	public ExperimentalProject getOneByAccount(long Account);

	/**
	 * @Decription 通过实验室编号获取该实验室所含实验项目列表
	 */
	public List<ExperimentalProject> getExperProjectByLabId(int labId);

}
