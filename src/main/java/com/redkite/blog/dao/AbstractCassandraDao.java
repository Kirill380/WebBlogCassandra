package com.redkite.blog.dao;


import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.mapping.Mapper;
import com.redkite.blog.CassandraClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractCassandraDao<T, K> {

  private static final Logger LOG = LoggerFactory.getLogger(AbstractCassandraDao.class);

  @Autowired
  protected CassandraClient cassandraClient;

  private Session session;


  protected Session getSession() {
    if (session == null) {
      session = cassandraClient.getSession();
    }
    return session;
  }

  private Mapper<T> getMapper() {
    return cassandraClient.getMapper(getColumnFamilyClass());
  }

  private ConsistencyLevel getConsistencyLevel() {
    return ConsistencyLevel.ONE;
  }

  public T save(T entity) {
    LOG.debug("Save entity " + entity);
    Statement saveStatement = getMapper().saveQuery(entity);
    saveStatement.setConsistencyLevel(getConsistencyLevel()); //TODO hardcoded
    getSession().execute(saveStatement);
    return entity;
  }


  public T find(K key) {
    return getMapper().get(key);
  }


  public List<T> findAll() {
    return getMapper().map(
        getSession().execute(
            QueryBuilder.select()
                .all()
                .from(getColumnFamilyName())
                .setConsistencyLevel(getConsistencyLevel())
        )
    ).all();
  }


  public void remove(K key) {
    getMapper().delete(key);
  }

  protected abstract Class<T> getColumnFamilyClass();

  protected abstract String getColumnFamilyName();


}
