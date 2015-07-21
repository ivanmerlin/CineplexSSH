package com.cineplex.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao {
	/** * Autowired 自动装配 相当于get() set() */
	@Autowired
	protected SessionFactory sessionFactory;

	/** * gerCurrentSession 会自动关闭session，使用的是当前的session事务 * * @return */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/** * openSession 需要手动关闭session 意思是打开一个新的session * * @return */
	public Session getNewSession() {
		return sessionFactory.openSession();
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	/** * 根据 id 查询信息 * * @param id * @return */
	@SuppressWarnings("rawtypes")
	public Object load(Class c, String id) {
		Session session = getSession();
		return session.get(c, id);
	}

	/** * 获取所有信息 * * @param c * * @return */

	public List getAllList(Class c) {
		String hql = "from " + c.getName();
		Session session = getSession();
		return session.createQuery(hql).list();

	}

	public boolean ifContain(Class c, String column, String value) {

		String hql = "from " + c.getName() + " where " + column + "='" + value
				+ "' ";
		Session session = getSession();
		List list = session.createQuery(hql).list();
		if (!list.isEmpty()) {
			System.out.println("no empty");
			return true;
		}

		return false;
	}

	public List find(Class c, String column, String value) {

		String hql = "from " + c.getName() + " where " + column + "='" + value
				+ "' ";
		Session session = getSession();
		List list = session.createQuery(hql).list();
		
		return list;
	}

	/** * 获取总数量 * * @param c * @return */

	public Long getTotalCount(Class c) {
		Session session = getNewSession();
		String hql = "select count(*) from " + c.getName();
		Long count = (Long) session.createQuery(hql).uniqueResult();
		session.close();
		return count != null ? count.longValue() : 0;
	}

	/** * 保存 * * @param bean * */
	public void save(Object bean) {
		try {
			Session session = getNewSession();
			session.save(bean);
			session.flush();
			session.clear();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** * 更新 * * @param bean * */
	public void update(Object bean) {
		Session session = getNewSession();
		session.update(bean);
		session.flush();
		session.clear();
		session.close();
	}

	/** * 删除 * * @param bean * */
	public void delete(Object bean) {

		Session session = getNewSession();
		session.delete(bean);
		session.flush();
		session.clear();
		session.close();
	}

	/** * 根据ID删除 * * @param c 类 * * @param id ID * */
	@SuppressWarnings({ "rawtypes" })
	public void delete(Class c, String id) {
		Session session = getNewSession();
		Object obj = session.get(c, id);
		session.delete(obj);
		flush();
		clear();
	}

	/** * 批量删除 * * @param c 类 * * @param ids ID 集合 * */
	@SuppressWarnings({ "rawtypes" })
	public void delete(Class c, String[] ids) {
		for (String id : ids) {
			Object obj = getSession().get(c, id);
			if (obj != null) {
				getSession().delete(obj);
			}
		}
	}

	public List executeQuery(String hql) {
		System.out.println("到baseDaoImpl这了！");
		Session session = getSession();
		System.out.println("getsession了！！");
		List list = session.createQuery(hql).list();

		return list;

	}

	
	public List doInHibernate(String hql,Class c) {
		return getSession().createQuery(hql).setResultTransformer(new AliasToBeanResultTransformer(c)).list();
	}
	public List dosqlInHibernate(String hql,Class c) {
		return getSession().createSQLQuery(hql).setResultTransformer(new AliasToBeanResultTransformer(c)).list();
	}
	public List dosqlInHibernate2(String hql) {
		return getSession().createSQLQuery(hql).list();
	}

}
