package by.webproj.carshowroom.repository;

import by.webproj.carshowroom.entity.Book;
import by.webproj.carshowroom.entity.Person;
import by.webproj.carshowroom.exception.RepositoryException;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    boolean add(Book book) throws RepositoryException;
    Optional<Book> getById(int id) throws RepositoryException;

    List<Book> getAll() throws RepositoryException;

    void update(Book book) throws RepositoryException;

    void deleteById(int id) throws RepositoryException;

    boolean release(int id) throws RepositoryException;

    boolean assign(int bookId, Person person) throws RepositoryException;

}
