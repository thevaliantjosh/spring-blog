package com.codeup.springblog.models;


import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {


    //Instance Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100 )
    private String title;


    @Column(nullable = false, length = 1000)
    private String body;

    @ManyToOne
    private User owner;


    //Getters and Setters

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getBody(){
        return body;
    }

    public void setBody(String body){
        this.body = body;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    //Constructors


    public Post(){

    }
    public Post(String title, String body){
        this.title = title;
        this.body = body;
    }

    public Post(long id, String title, String body){
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, User owner){
        this.title = title;
        this.body = body;
        this.owner = owner;
    }









}//End of Post Class
