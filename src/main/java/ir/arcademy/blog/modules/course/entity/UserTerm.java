package ir.arcademy.blog.modules.course.entity;

import ir.arcademy.blog.modules.users.model.Users;

import javax.persistence.*;

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
