package com.example.clients_service.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
//
@Entity
@Table(name = "clients")
public class Client {

    public Long getId() {
        return this.id;
    }

    public String getSurname() {
        if(this.surname == null){
            return "no value";
        }
        return this.surname;
    }

    public String getName() {
        return this.name;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public String getEmail() {
        return this.email;
    }

    public Gender getGender() {
        return this.gender;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public enum Gender{
        MALE, FEMALE, OTHER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, length = 30)
    private String surname;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private String patronymic;
    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = true, length = 50)
    private String email;

    @Column
    private Gender gender;



    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private Set<Phone> phones;
    
}
