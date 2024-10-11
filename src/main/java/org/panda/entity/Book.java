package org.panda.entity;


public class Book {
    private String title;
    private String author;
    private String releaseYear;
    private String titleTranslate;

    public Book(String title, String author, String releaseYear, String titleTranslate) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.titleTranslate = titleTranslate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitleTranslate() {
        return titleTranslate;
    }

    public void setTitleTranslate(String titleTranslate) {
        this.titleTranslate = titleTranslate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", titleTranslate='" + titleTranslate + '\'' +
                '}';
    }
}
