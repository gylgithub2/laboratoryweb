package cn.gyl.laboratoryweb.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.gyl.laboratoryweb.model.ExperimentalProject;
import cn.gyl.laboratoryweb.model.Pager;

/**
 * @Decription
 * @authorEmail 1076030424@qq.com
 */
@Repository("experProjectDao")
public class ExperProjectDaoimpl extends BaseDaoimpl<ExperimentalProject> implements ExperProjectDao {

	@Override
	public Pager<ExperimentalProject> getPagerExperimentalProjects(String experimentalProjectName) {
		String hql = "from ExperimentalProject e where 1=1 ";
		if (experimentalProjectName != null && !"".equals(experimentalProjectName))
			hql += "AND e.experimentalProjectName like '%" + experimentalProjectName + "%'";
		return super.getPageList(hql, null, null);
	}

	@Override
	public List<ExperimentalProject> getAllExperimentalProjects() {
		String hql="from ExperimentalProject";
		return super.getList(hql, null, null);
	}

	@Override
	public ExperimentalProject getOneByAccount(long Account) {
		String hql="from ExperimentalProject where experimentalProjectId = ?0";
		return super.queryByHql(hql, new Object[]{Account}, null);
	}
	@Override
	public List<ExperimentalProject> getExperProjectByLabId(int labId) {
		String hql="select e from ExperimentalProject e left join e.laboratory as l where l.laboratoryPKID = ?0";
		return super.getList(hql, new Object[]{labId}, null);
	}
}
