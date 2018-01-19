/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entites;

import java.sql.Date;

/**
 *
 * @author hp
 */
public class user {
    
private int id_user; 
private int cin;
private String nom ;
private String prenom ; 
private String adresse_mail;
private String adresse ;
private Date date_naissance ;
private int num_tel;
private String metier ;
private String sexe ;
private String nationalite ;
private String mdp ;
private String role ;
private String competence ;
private int annee_exp;
private String about_me  ;
private int evaluation; 

    public user(int id_user, int cin, String nom, String prenom, String adresse_mail, String adresse, Date date_naissance, int num_tel, String metier, String sexe, String nationalite, String mdp, String role, String competence, int annee_exp, String about_me, int evaluation) {
        this.id_user = id_user;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse_mail = adresse_mail;
        this.adresse = adresse;
        this.date_naissance = date_naissance;
        this.num_tel = num_tel;
        this.metier = metier;
        this.sexe = sexe;
        this.nationalite = nationalite;
        this.mdp = mdp;
        this.role = role;
        this.competence = competence;
        this.annee_exp = annee_exp;
        this.about_me = about_me;
        this.evaluation = evaluation;
    }

    public user(int id_user, int cin, String nom) {
        this.id_user = id_user;
        this.cin = cin;
        this.nom = nom;
    }

    public user(int id_user) {
        this.id_user = id_user;
    }



    public user() {
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse_mail(String adresse_mail) {
        this.adresse_mail = adresse_mail;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public void setAnnee_exp(int annee_exp) {
        this.annee_exp = annee_exp;
    }

    public void setAbout_me(String about_me) {
        this.about_me = about_me;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public int getId_user() {
        return id_user;
    }

    public int getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse_mail() {
        return adresse_mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public String getMetier() {
        return metier;
    }

    public String getSexe() {
        return sexe;
    }

    public String getNationalite() {
        return nationalite;
    }

    public String getMdp() {
        return mdp;
    }

    public String getRole() {
        return role;
    }

    public String getCompetence() {
        return competence;
    }

    public int getAnnee_exp() {
        return annee_exp;
    }

    public String getAbout_me() {
        return about_me;
    }

    public int getEvaluation() {
        return evaluation;
    }

    @Override
    public String toString() {
        return "user{" + "id_user=" + id_user + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", adresse_mail=" + adresse_mail + ", adresse=" + adresse + ", date_naissance=" + date_naissance + ", num_tel=" + num_tel + ", metier=" + metier + ", sexe=" + sexe + ", nationalite=" + nationalite + ", mdp=" + mdp + ", role=" + role + ", competence=" + competence + ", annee_exp=" + annee_exp + ", about_me=" + about_me + ", evaluation=" + evaluation + '}';
    }





}
