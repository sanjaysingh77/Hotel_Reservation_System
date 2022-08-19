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

import com.hotel.reservation.entity.BookRoom;

@Repository
public class BookRoomDAOImpl implements BookRoomDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Long saveBookRoom(BookRoom bookRoom) {
		Session currentSession = sessionFactory.getCurrentSession();
		if(bookRoom.getBookingId() == null) {
			return (Long)currentSession.save(bookRoom);
		}
		currentSession.update(bookRoom);
		return bookRoom.getBookingId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookRoom> getAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = currentSession.getCriteriaBuilder();
        CriteriaQuery <BookRoom> cq = cb.createQuery(BookRoom.class);
        Root <BookRoom> root = cq.from(BookRoom.class);
        cq.select(root);
        Query query = currentSession.createQuery(cq);
        return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public BookRoom getBookRoomById(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		String hql = " FROM BookRoom br WHERE br.bookingId = :bookingId";
        Query query = currentSession.createQuery(hql);
        query.setParameter("bookingId", id);
        List<BookRoom> results = query.getResultList();
        if (results != null && !results.isEmpty()) {
            return (BookRoom) results.get(0);
        }
        return null;
	}

	@Override
	public void deleteBookRoom(Long id) {
		Session session = sessionFactory.getCurrentSession();
		BookRoom bookRoom = session.byId(BookRoom.class).load(id);
        session.delete(bookRoom);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<BookRoom> getAllByEmail(String email) {
		Session currentSession = sessionFactory.getCurrentSession();
		String hql = " FROM BookRoom br WHERE br.email = :email";
        Query query = currentSession.createQuery(hql);
        query.setParameter("email", email);
        return query.getResultList();
	}

}
