package com.ronnie.department.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long departmentId;

    private String name;

    private Integer age;

    private String phone;

    private String education;

    private Date gmtCreated;

    private Date gmtModified;
}
