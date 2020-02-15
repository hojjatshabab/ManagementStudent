package ir.arcademy.blog.modules.course.entity;

import ir.arcademy.blog.modules.posts.model.Posts;
import ir.arcademy.blog.modules.users.model.Users;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "terms")
public class Term {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title", length = 45)
    private String title;

  //  @OneToMany(mappedBy = "term")
 //   private List<Course> course;
//    @OneToMany
//    @JoinColumn(name = "termId")
//    private List<Course> courses;

//    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
//    // @JoinColumn(name = "userId")
//    @JoinTable(
//            name = "users_terms",
//            joinColumns = @JoinColumn(name = "userId"),
//            inverseJoinColumns = @JoinColumn(name = "termId")
//    )
//    private List<Users> user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public List<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(List<Course> courses) {
//        this.courses = courses;
//    }

//    public List<Users> getUser() {
//        return user;
//    }
//
//    public void setUser(List<Users> user) {
//        this.user = user;
//    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", title='" + title + '\'' +
//                ", courses=" + courses +
//                ", users=" + user +
                '}';
    }
}
