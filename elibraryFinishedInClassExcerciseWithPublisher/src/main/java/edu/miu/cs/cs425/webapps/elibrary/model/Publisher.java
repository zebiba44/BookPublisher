package edu.miu.cs.cs425.webapps.elibrary.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer publisherId;
        private String name;

    private String phoneNumber;

    @NotNull
    @NotBlank(message ="email is required")
    private String email;

    @OneToMany(mappedBy = "publisher",cascade = CascadeType.PERSIST)

        private List<Book> booksPublished;


    public Publisher() {
    }

    public Publisher(String name, String phoneNumber, String email, List<Book> booksPublished) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.booksPublished = booksPublished;
    }

    public Publisher(String name) {
            this.name = name;
        }

        public Integer getPublisherId() {
            return publisherId;
        }

        public void setPublisherId(Integer publisherId) {
            this.publisherId = publisherId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Book> getBooksPublished() {
            return booksPublished;
        }

        public void setBooksPublished(List<Book> booksPublished) {
            this.booksPublished = booksPublished;
        }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + publisherId +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


