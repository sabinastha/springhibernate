package com.springmvclearn.web.dao;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



@Component("offersDao")
public class OffersDAO {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	public OffersDAO() {
		System.out.println("Successfully configured OffersDAO");
	}
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public List<Offer> getOffers() {

		return jdbc.query("select * from offer", new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();

			offer.setId(rs.getInt("id"));
		offer.setUsername(rs.getString("username"));
			offer.setFullname(rs.getString("fullname"));
			offer.setPassword(rs.getString("password"));

			return offer;
		}
	});
	}
	
			public List<Offer> getAllOffers() {
			return session().createQuery("from Offer").list();
		}
	
	
	public boolean update(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

		return jdbc.update("update offer set  fullname=:fullname,username=:username, password=:password where id=:id", params) == 1;
	}
	
	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		
		return jdbc.update("delete from offer where id=:id", params) == 1;
	}

	public boolean create(Offer offer) {

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

		return jdbc.update("insert into offer (username, fullname, password) values (:username, :fullname, :password)", params) == 1;
	}

	
	public void createWithSession(Offer offer) {
	
		session().save(offer);

			}

	@Transactional
	public int[] create(List<Offer> offers) {

		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());

		return jdbc.batchUpdate("insert into offer (id, fullname, username, password) values (:id, :fullname, :username, :password)", params);
	}
	
	
//	public Offer getOffer(int id) {
//		MapSqlParameterSource params = new MapSqlParameterSource();
//		params.addValue("id", id);
//
//		return jdbc.queryForObject("select * from offer where id=:id", params, new RowMapper<Offer>() {
//
//			public Offer mapRow(ResultSet rs, int RowNum) throws SQLException {
//				Offer offer = new Offer();
//
//				offer.setId(rs.getInt("id"));
//				offer.setUsername(rs.getString("username"));
//				offer.setFullname(rs.getString("fullname"));
//				offer.setPassword(rs.getString("password"));
//				return offer;
//			}
//		});
//
//	}
//	
	
}