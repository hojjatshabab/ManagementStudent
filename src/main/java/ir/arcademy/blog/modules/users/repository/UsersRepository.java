package ir.arcademy.blog.modules.users.repository;

import ir.arcademy.blog.modules.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

    // select * from users where email="..."

    @Query("select u from Users u where u.email=:email")
    Users findByQuery(@Param("email") String email);

    Users findByEmail(String email);

   // Optional<Users> findByUsername(String username);
}
