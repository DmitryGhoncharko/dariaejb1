package by.webproj.carshowroom.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name="person_id",referencedColumnName = "id")
    private Person person;
    @NotEmpty
    @Column(name = "title")
    private String title;
    @NotEmpty
    @Column(name = "author")
    private String author;
    @NotEmpty
    @Column(name = "year_of_publication")
    private int yearOfPublication;
}
