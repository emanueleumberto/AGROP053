package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false)
    private Long id;
    @Column(name = "course_name", nullable = false)
    private String courseName;

    private Integer hour;

    // Solo se voglio una relazione Bidirezionale
    @ManyToMany(mappedBy = "courses")
    private List<User> userList;

    public Course() {}

    public Course(String courseName, Integer hour) {
        this.courseName = courseName;
        this.hour = hour;
        this.userList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", hour=" + hour +
                ", userList=" + userList +
                '}';
    }
}
