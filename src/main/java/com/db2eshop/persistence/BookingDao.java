package com.db2eshop.persistence;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db2eshop.model.Booking;
import com.db2eshop.persistence.support.AbstractDao;

@Repository
/**
 * <p>BookingDao class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class BookingDao extends AbstractDao<Booking>{

	/**
	 * <p>Constructor for BookingDao.</p>
	 *
	 * @param sessionFactory a {@link org.hibernate.SessionFactory} object.
	 */
	@Autowired
	public BookingDao(SessionFactory sessionFactory) {
		super(sessionFactory, Booking.class);
	}
}
