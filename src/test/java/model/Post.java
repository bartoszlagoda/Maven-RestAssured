package model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

// nie będzie wysyłać elementów, które są nullami
// bierzemy pod uwagę tylko te elementy, które nie są nullami
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Post {
    private Integer id;
    private String title;
    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // metoda zwróci nam prywatne pole Title
    public String getTitle() {
        return title;
    }

    // metoda ustawi nam pole title
    public void setTitle(String title) {
        this.title = title;
    }

    // metoda ustawi nam autora
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) && Objects.equals(author, post.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}
