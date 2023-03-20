package by.webproj.carshowroom.repository;

import by.webproj.carshowroom.entity.Book;
import by.webproj.carshowroom.entity.Person;
import by.webproj.carshowroom.exception.RepositoryException;
import by.webproj.carshowroom.repository.sessionfactory.HibernateSessionFactoryUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class SimpleBookRepository implements BookRepository{

    private final HibernateSessionFactoryUtil hibernateSessionFactoryUtil;

    @Override
    public boolean add(Book book) throws RepositoryException {
        try(Session session = hibernateSessionFactoryUtil.getSessionFactory().openSession()){
            session.save(book);
            return true;
        }catch (HibernateException e){
            log.error("Cannot add book",e);
            throw new RepositoryException("Cannot add book",e);
        }
    }

    @Override
    public Optional<Book> getById(int id) throws RepositoryException {
        try(Session session = hibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return Optional.of(hibernateSessionFactoryUtil.getSessionFactory().openSession().get(Book.class,id));
        }catch (HibernateException e){
            log.error("Cannot get book by id",e);
            throw new RepositoryException("Cannot get book by id",e);
        }
    }

    @Override
    public List<Book> getAll() throws RepositoryException {
        try(Session session = hibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return (List<Book>) session.createQuery("from Book").list();
        }catch (HibernateException e){
            log.error("Cannot get all books",e);
            throw new RepositoryException("Cannot get all books",e);
        }
    }

    @Override
    public void update(Book book) throws RepositoryException {
        try(Session session = hibernateSessionFactoryUtil.getSessionFactory().openSession()){
             session.update(book);
        }catch (HibernateException e){
            log.error("Cannot update book",e);
            throw new RepositoryException("Cannot update book",e);
        }
    }

    @Override
    public void deleteById(int id) throws RepositoryException {
        try(Session session = hibernateSessionFactoryUtil.getSessionFactory().openSession()){
           session.delete(id);
        }catch (HibernateException e){
            log.error("Cannot delete book by id",e);
            throw new RepositoryException("Cannot delete book by id",e);
        }
    }

    @Override
    public boolean release(int id) throws RepositoryException {
        try(Session session = hibernateSessionFactoryUtil.getSessionFactory().openSession()){
           return session.createQuery("update Book set person.id = null where person.id = ?").executeUpdate()>0;
        }catch (HibernateException e){
            log.error("Cannot release book",e);
            throw new RepositoryException("Cannot release book",e);
        }
    }

    @Override
    public boolean assign(int bookId, Person person) throws RepositoryException {
        try(Session session = hibernateSessionFactoryUtil.getSessionFactory().openSession()){
            return session.createQuery("update Book set person.id = ? where id = ?").executeUpdate()>0;
        }catch (HibernateException e){
            log.error("Cannot assing book",e);
            throw new RepositoryException("Cannot assing book",e);
        }
    }
}
