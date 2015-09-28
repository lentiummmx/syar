/**
 * @since 05/09/2014
 */
package mx.com.vepormas.syar.web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.vepormas.syar.web.entities.MedicalUnit;
import mx.com.vepormas.syar.web.entities.Person;

import java.util.Date;
import java.util.List;

/**
 * @author Jose Daniel Morales Rios
 *
 */
@Repository
@Transactional
public interface PersonRepository extends CrudRepository<Person, Long>,PersonRepositoryCustom{
    public List<Person> findByUpdatedAtGreaterThan(Date date);
    public List<Person> findByMedicalUnitAndUpdatedAtGreaterThan(MedicalUnit mu,Date date);
    public List<Person> findByIdIn(List<Long> ids);
}
 