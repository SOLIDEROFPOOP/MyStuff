package com.example.graphqlstudy;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;


    public MainController(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @QueryMapping
    Iterable<Author> authors(){
        return authorRepository.findAll();
    }
    @QueryMapping
    Optional<Author> authorById(@Argument Long id){
        return authorRepository.findById(id);
    }
    @MutationMapping
    Book addBook(@Argument BookInput book){
        Author author = authorRepository.findById(book.authorId()).orElseThrow(()-> new IllegalArgumentException("no author with this id"));
        Book b = new Book(book.title, book.publisher, author);
        return bookRepository.save(b);
    }
    @QueryMapping
    List<Pet> pets(){
        return List.of(
                new Pet("NIGGA","BLACK"),
                new Pet("FAGGOT","GAY")
        );
    }
    record BookInput(String title, String publisher, Long authorId){};
    record Pet(String name, String color){};
}
