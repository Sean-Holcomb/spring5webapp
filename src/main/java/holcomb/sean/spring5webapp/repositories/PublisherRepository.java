package holcomb.sean.spring5webapp.repositories;


import holcomb.sean.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
