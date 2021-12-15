package br.com.andersonsilva.user_crud.repository;

import br.com.andersonsilva.user_crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

public List<User> findByIdGreaterThan(Long id);
public List<User> findByNameIgnoreCase(String name);
@Transactional
@Modifying
@Query("update User u set u.name= ?1, u.username=?2 where u.id=?3")
void  updateUser(@Param("name") String name,@Param("username")  String username,@Param("id")  Long id);
}
