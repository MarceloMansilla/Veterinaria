package ar.com.veterinaria.app.entities.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {

	public T findById(int id);

	public void remove(int id);

	public T add(T t);

	public T update(int id, T t);

	public List<Map<String, Object>> findAll();

	boolean exist(T t);

}