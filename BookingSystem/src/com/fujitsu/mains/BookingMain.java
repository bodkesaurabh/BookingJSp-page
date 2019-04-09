package com.fujitsu.mains;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fujitsu.bean.Booking;
import com.fujitsu.beans.hotel.Hotel;
import com.fujitsu.dao.BookingDao;

public class BookingMain {
	
	public static void main(String[] args) {
		
		
		Configuration cfg=new Configuration();

		//read hibernate properties from hibernate.cfg.xml and store in sessionfactory
		Configuration c=cfg.configure();
		
		//obtain sessionFactory to configuration
		SessionFactory factory=c.buildSessionFactory();
		
		//get session from session package
		//represents db connection
		Session session=factory.openSession();
		
		//get transaction to session
		Transaction tx=session.beginTransaction();
		
		
		Hotel hotel=new Hotel();
		//hotel.setHotelId(1001);
		
		hotel.setHotelName("Hotel Vivanta");
		hotel.setWebsite("www.tajhotels.com/");
		hotel.setRating(4);
		hotel.setReview("Vivanta is a place that spoils you completely");
		hotel.setPhoneNo(1-800-111-825l);
		hotel.setEmailId("reservations@tajhotels.com");
		hotel.setAddress("Vivanta, Off, Dayanand Bandodkar Marg, Santa Inez, Panaji, Goa 403001");
		hotel.setCountrycode(+91);
		hotel.setCity("Goa");
		hotel.setState("Maharashtra");
		hotel.setCountry("India");
		hotel.setZip(403001);
		session.save(hotel);
		
		Booking bk=new Booking();
		bk.setNoOfAdults(2);
		bk.setNoOfChildren(1);
		bk.setNumberOfRooms(1);
		bk.setBookingdate(LocalDate.of(1997, 04, 28));
		bk.setCheckInDate(LocalDate.of(1997, 04, 28));
		bk.setCheckOutDate(LocalDate.of(1997, 04, 28));
		bk.setCustomerId(1001);
		bk.setCheckInTime(LocalTime.of(01, 10));
		bk.setCheckOutTime(LocalTime.of(15, 15));
		session.save(bk);
			
		bk.setHotel(hotel);
		//commit transaction
		tx.commit();
		
		//close session - db connection closed
		session.close();


	}

		
		
	}
	
	

