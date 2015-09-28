/**
 * @since 05/09/2014
 */
package mx.com.vepormas.syar.web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.vepormas.syar.web.entities.ErrorNFC;

/**
 * @author Jose Daniel Morales Rios
 *
 */
@Repository
@Transactional
public interface ErrorNFCRepository extends CrudRepository<ErrorNFC, Long> {

}
