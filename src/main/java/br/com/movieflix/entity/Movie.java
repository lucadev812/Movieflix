package br.com.movieflix.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "movie")
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
   private Long id;

    @Column(nullable = false)
   private String title;


   private String description;

   @Column(name = "release_date")
   private LocalDate releaseDate;

   private double ratting;

   @CreationTimestamp
   @Column(name = "createdAt")
   private LocalDateTime createdAt;

   @UpdateTimestamp
   @Column(name = "updated_At")
   private LocalDateTime updateAt;

   @ManyToMany
   @JoinTable(name = "movie_category",
       joinColumns = @JoinColumn(name = "movie_id"),
       inverseJoinColumns = @JoinColumn(name = "category_id")


   )
    private List<Category> categories;


   @ManyToMany
   @JoinTable(name = "movie_streaming",
           joinColumns = @JoinColumn(name = "movie_id"),
           inverseJoinColumns = @JoinColumn(name = "streaming_id")

   )
    private List<Streaming> streamings;



}
