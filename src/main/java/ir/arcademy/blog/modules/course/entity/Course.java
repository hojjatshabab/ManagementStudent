package ir.arcademy.blog.modules.course.entity;





import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import ir.arcademy.blog.modules.users.model.Users;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="id")
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
 
    private String name;
  
    private String code;
    
    private int max; 
    
    @Column(updatable = false)
	@CreationTimestamp
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
    
    public Course() {}

    public Course(String name, String code, int max) {
        this.name = name;
        this.code=code;
        this.max=max;
        
    }
    
    @ManyToMany(mappedBy = "course")
    private List<Users> users;
    
    
    public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}


	public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    


    public String getName() {
        return name;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}





}