package com.hotel.reservation.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.reservation.entity.Inquiry;

@Repository
public class InquiryDAOImpl implements InquiryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Long saveInquiry(Inquiry inquiry) {
		Session currentSession = sessionFactory.getCurrentSession();
		if(inquiry.getId() == null) {
			return (Long)currentSession.save(inquiry);
		}
		currentSession.update(inquiry);
		return inquiry.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Inquiry> getAllInquiries() {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = currentSession.getCriteriaBuilder();
        CriteriaQuery <Inquiry> cq = cb.createQuery(Inquiry.class);
        Root <Inquiry> root = cq.from(Inquiry.class);
        cq.select(root);
        Query query = currentSession.createQuery(cq);
        return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Inquiry getInquiryById(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		String hql = " FROM Inquiry I WHERE I.id = :id";
        Query query = currentSession.createQuery(hql);
        query.setParameter("id", id);
        List<Inquiry> results = query.getResultList();
        if (results != null && !results.isEmpty()) {
            return (Inquiry) results.get(0);
        }
        return null;
	}

	@Override
	public void deleteInquiry(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Inquiry inquiry = session.byId(Inquiry.class).load(id);
        session.delete(inquiry);
	}

}
