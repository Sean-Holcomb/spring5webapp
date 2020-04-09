package holcomb.sean.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import holcomb.sean.spring5webapp.domain.Book;


public interface BookRepository extends CrudRepository<Book, Long> {
}
