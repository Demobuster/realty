package com.petukhov.estate.dao;

import java.util.List;
import java.util.UUID;

import com.petukhov.estate.config.CacheConfig;
import com.petukhov.estate.domain.Prop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class PropertyDAOImpl implements PropertyDAO {

	@Autowired
	private SessionFactory mySessionFactory;

	@Override
	@CacheEvict(value = CacheConfig.CACHED_PROPERTY, allEntries = true)
	public void addProperty(String address, String description, String fee) {
		Session session = mySessionFactory.getCurrentSession();

		Prop prop = new Prop();

		UUID x = UUID.randomUUID();

		prop.setId(x.toString());
		prop.setAddress(address);
		prop.setDescription(description);
		prop.setFee(fee);

		session.saveOrUpdate(prop);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Cacheable(CacheConfig.CACHED_PROPERTY)
	public List<Prop> listProperty() {
		return mySessionFactory.getCurrentSession().createQuery("from Prop").list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Prop> listPropertyForAdmin() {
		return mySessionFactory.getCurrentSession().createQuery("from Prop").list();
	}

	@Override
	public Prop getProperty(String id) {
		return (Prop) mySessionFactory.getCurrentSession().get(Prop.class, id);
	}
	
	@Override
	public void removeProperty(String id) {
		Prop prop = (Prop) mySessionFactory.getCurrentSession().get(Prop.class, id);
    	
        if (null != prop) {
            mySessionFactory.getCurrentSession().delete(prop);
        }	
	}

	@Override
	public void indexProperty() throws Exception {
		try {
			Session session = mySessionFactory.getCurrentSession();

			FullTextSession fullTextSession = Search
					.getFullTextSession(session);
			fullTextSession.createIndexer().startAndWait();
		} catch (Exception e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prop> searchForProperty(String searchText) throws Exception {
		try {
			Session session = mySessionFactory.getCurrentSession();

			FullTextSession fullTextSession = Search
					.getFullTextSession(session);

			QueryBuilder qb = fullTextSession.getSearchFactory()
					.buildQueryBuilder().forEntity(Prop.class).get();
			org.apache.lucene.search.Query query = qb.keyword()
					.onFields("description", "address")
					.ignoreAnalyzer()
					.matching(searchText.toLowerCase())
					.createQuery();

			org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(
					query, Prop.class);

			List<Prop> results = hibQuery.list();
			return results;
		} catch (Exception e) {
			throw e;
		}
	}
	
}