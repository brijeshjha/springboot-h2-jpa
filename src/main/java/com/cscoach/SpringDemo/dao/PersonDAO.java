package com.cscoach.SpringDemo.dao;

import com.cscoach.SpringDemo.dto.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class PersonDAO {

    @PersistenceContext
    EntityManager em;

    public Person findById(int id){
        return em.find(Person.class,id);
    }

    public Person insertData(Person p){
        return em.merge(p);
    }

    public Person updateData(Person p){
        return em.merge(p);
    }

    public void insertOrUpdateDataUSingPersistOrMerge(Person p){
        if(p.getId()==0){
            em.persist(p);
        }
        else{
            em.merge(p);
        }
    }

    public void deleteData(int id){
        Person p = findById(id);
        em.remove(p);
    }

    public List<Person> findAllPersons(){
        TypedQuery<Person> tq = em.createNamedQuery("find_all_persons",Person.class);
        return tq.getResultList();
    }

    public void entityManagerWorking(){
        Person p = new Person("john cena","boston",new Date());
        em.persist(p);
        em.flush();
        p.setLocation("delhi");
    }

    public List<Person> nativeQueryForSelect(int id){
        Query q = em.createNativeQuery("select * from persons where id = :id",Person.class);
        q.setParameter("id",id);
        return q.getResultList();
    }

    public int nativeQueryForUpdate(){
     return em.createNativeQuery("update persons set name='ram' where id = 1").executeUpdate();
    }

}
