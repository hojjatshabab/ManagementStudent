package ir.arcademy.blog.modules.course.entity;

import ir.arcademy.blog.modules.users.model.Users;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserTerm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title" ,length = 70)
    private String title;
    @OneToOne
    @JoinColumn(name = "userId")
    private Users users;

    @OneToMany(mappedBy = "term",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})
    private List<UserCourse> userCourses;

    public List<UserCourse> getUserCourses() {
        return userCourses;
    }

    public void setUserCourses(List<UserCourse> userCourses) {
        this.userCourses = userCourses;
    }

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

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
