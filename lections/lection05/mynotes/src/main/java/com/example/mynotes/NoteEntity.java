package com.example.mynotes;

import jakarta.persistence.*;

@Entity // эта аннотация указывает, что класс является JPA сущностью
@Table(name = "notes") // эта аннотация позволяет нам указать имя таблицы,
                       // на которую будет отображаться наш класс
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Id и @GeneratedValue: эти аннотации указывают, что поле id является
    // идентификатором и его значение должно быть сгенерировано автоматически
    private Long id;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 2000)
    private String content;

    // @Column: эта аннотация позволяет нам указать параметры для колонки,
    // соответствующей данному полю. В данном случае, мы указываем,
    // что все поля являются обязательными (nullable = false),
    // а поле content ограничиваем 2000 символами в длину

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
