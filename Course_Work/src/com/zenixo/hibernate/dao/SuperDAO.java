package com.zenixo.hibernate.dao;

import com.zenixo.hibernate.entity.Course;
import com.zenixo.hibernate.entity.SuperEntity;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * @author Gathsara Umesh on 2/10/2021
 * @project Hibernate-Course-Work
 */
public interface SuperDAO <Entity extends SuperEntity,ID extends Serializable>{
    public boolean add (Entity entity) throws  Exception;
    public  boolean delete (Entity entity)throws  Exception;
    public  boolean update (Entity entity)throws  Exception;
    public Entity find (ID id) throws  Exception;
    public List<Entity> findAll () throws  Exception;
    public void setSession(Session session) throws Exception;
}
