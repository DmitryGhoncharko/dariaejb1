package by.webproj.carshowroom.repository;

import by.webproj.carshowroom.entity.Person;
import by.webproj.carshowroom.exception.RepositoryException;
import by.webproj.carshowroom.repository.sessionfactory.HibernateSessionFactoryUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Singleton
public class SimplePersonRepository implements PersonRepository {
    @EJB
    private final HibernateSessionFactoryUtil hibernateSessionFactoryUtil;

    @Override
    public Optional<Person> getById(int id) throws RepositoryException {
        try (Session session = hibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return Optional.of(session.get(Person.class, id));
        } catch (HibernateException e) {
            log.error("Cannot get by id person", e);
            throw new RepositoryException("Cannot get by id person", e);
        }
    }

    @Override
    public boolean add(Person person) throws RepositoryException {
        try (Session session = hibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.save(person);
            return true;
        } catch (HibernateException e) {
            log.error("Cannot save person", e);
            throw new RepositoryException("Cannot save person", e);
        }
    }

    @Override
    public void update(Person person) throws RepositoryException {
        try (Session session = hibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            session.update(person);

        } catch (HibernateException e) {
            log.error("Cannot update person", e);
            throw new RepositoryException("Cannot update person", e);
        }
    }

    @Override
    public List<Person> getAll() throws RepositoryException {
        try (Session session = hibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return (List<Person>) session.createQuery("from Person ").list();

        } catch (HibernateException e) {
            log.error("Cannot get all persons", e);
            throw new RepositoryException("Cannot get all persons", e);
        }
    }

    @Override
    public Optional<Person> getByLogin(String login) throws RepositoryException {
        try (Session session = hibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("select id, name , yearOfBirth, login, password from Person  where login = ?");
            query.setParameter(0, login);
            List<Person> people = (List<Person>) query.list();
            if (people.size() > 0) {
                return Optional.of(people.get(0));
            }
            return Optional.empty();
        } catch (HibernateException e) {
            log.error("Cannot get all persons", e);
            throw new RepositoryException("Cannot get all persons", e);
        }
    }
}
