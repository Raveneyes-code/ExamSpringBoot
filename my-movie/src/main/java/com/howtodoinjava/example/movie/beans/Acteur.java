package com.howtodoinjava.example.movie.beans;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class Acteur {
    @ApiModelProperty(notes = "Name of the actor",name="name",required=true,value="test nom")
    private String nom;
    @ApiModelProperty(notes = "Surname of the actor",name="name",required=true,value="test prenom")
    private String prenom;
    @ApiModelProperty(notes = "birthdate of the actor",name="name",required=true,value="test dateDeNaissance")
    private Date dateDeNaissance;
    @ApiModelProperty(notes = "Filmographie of the actor",name="name",required=true,value="test filmographie")
    private String filmographie;
    public Acteur(String nom, String prenom, Date datenaissance, String film) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = datenaissance;
        this.filmographie = film;
    }
}