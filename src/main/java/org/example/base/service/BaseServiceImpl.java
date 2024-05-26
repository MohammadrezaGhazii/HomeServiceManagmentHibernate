package org.example.base.service;

import org.example.base.entity.BaseEntity;
import org.example.base.exception.NotFoundExeption;
import org.example.base.repository.BaseRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<T extends BaseEntity<ID>,
        ID extends Serializable,
        R extends BaseRepository<T, ID>>
        implements BaseService<T, ID> {

    protected final R repository;
    private final SessionFactory sessionFactory;

    public BaseServiceImpl(R repository, SessionFactory sessionFactory) {
        this.repository = repository;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public T saveOrUpdate(T entity) {
        Transaction transaction = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            transaction = session.beginTransaction();
            T t = repository.saveOrUpdate(entity);
            transaction.commit();
            session.close();
            return t;
        } catch (Exception e) {
            assert transaction != null;
            transaction.rollback();
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Optional<T> findEntity = repository.findById(id);
            findEntity.orElseThrow(() -> new NotFoundExeption(String.format("Entity with id : %s not found", id)));
            session.getTransaction().commit();
            session.close();
            return findEntity;
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void deleteById(ID id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Optional<T> findEntity = repository.findById(id);
            findEntity.orElseThrow(() -> new NotFoundExeption(String.format("Entity with id : %s not found", id)));
            repository.delete(findEntity.get());
            session.getTransaction().commit();
        } catch (Exception ignored) {
            }
    }

    @Override
    public List<T> findAll() {
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            List<T> listAll = repository.findAll();
            session.getTransaction().commit();
            session.close();
            return listAll;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
