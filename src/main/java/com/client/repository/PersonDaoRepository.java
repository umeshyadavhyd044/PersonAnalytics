package com.client.repository;

import com.client.model.Person;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PersonDaoRepository implements PersonDaoRepositoryI {
    private EntityManager em;

    public PersonDaoRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Person> findPersonByTypeAndValue(String type, String value) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> personRoot = cq.from(Person.class);
//        Predicate columnTypePredicate = cb.equal(personRoot.get(type), type);
        Predicate valuePredicate = null;
        if("age".equals(type))
            valuePredicate = cb.greaterThanOrEqualTo(personRoot.get(type),  value );
        else if("gender".equals(type))
            valuePredicate = cb.equal(personRoot.get(type),value );
        else if("location".equals(type))
            valuePredicate = cb.equal(personRoot.get(type),value );
        else if("state".equals(type))
            valuePredicate = cb.equal(personRoot.get(type),value );
        else if("income".equals(type))
            valuePredicate = cb.equal(personRoot.get(type),value );
        else if ("maritalStatus".equals(type))
            valuePredicate = cb.equal(personRoot.get(type),value );
        cq.where(valuePredicate);
        TypedQuery<Person> query = em.createQuery(cq);
        System.out.println("qyery"+query);
        return query.getResultList();
    }
}
