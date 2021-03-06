package ua.kpi.schedule.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.*;

public class GenericDAO <T>{

    protected SessionFactory eManager;
    protected Class<T> type;

    public GenericDAO(Class<T> type) {
        this.type = type;
    }

    private Class<T> getInterfaceClass() {
        return type;
    }

    @Transactional
    public void save (T entity){
        eManager.getCurrentSession().saveOrUpdate(entity);
//        eManager.getCurrentSession().flush();
    }
    @Transactional
    public void delete (T entity){
        eManager.getCurrentSession().delete(eManager.getCurrentSession().merge(entity));
    }
    @Transactional
    public T update (T entity){
        return (T) eManager.getCurrentSession().merge(entity);
    }
    @Transactional
    public T find (int entityId){
        return (T) eManager.getCurrentSession().get(getInterfaceClass(), entityId);
    }
    @Transactional
    public List<T> getAll (){
        final Session session = eManager.getCurrentSession();
        final Criteria crit = session.createCriteria(type);
        return crit.list();
    }

    public SessionFactory geteManager() {
        return eManager;
    }

    public void seteManager(SessionFactory eManager) {
        this.eManager = eManager;
    }
}