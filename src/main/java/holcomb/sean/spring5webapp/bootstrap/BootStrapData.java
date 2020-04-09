package holcomb.sean.spring5webapp.bootstrap;

import holcomb.sean.spring5webapp.domain.Author;
import holcomb.sean.spring5webapp.domain.Book;
import holcomb.sean.spring5webapp.domain.Publisher;
import holcomb.sean.spring5webapp.repositories.AuthorRepository;
import holcomb.sean.spring5webapp.repositories.BookRepository;
import holcomb.sean.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.awt.*;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Developement without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher publisher = new Publisher();
        publisher.setName("Penguin");
        publisher.setAddress1("1234 Antarctica St");
        publisher.setCity("Iceville");
        publisher.setState("Washington");
        publisher.setZipcode("12345");

        publisherRepository.save(publisher);

        System.out.println("Started in Boootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
    }
}
