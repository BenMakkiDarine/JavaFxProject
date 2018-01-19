/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entites;

/**
 *
 * @author hp
 */
public class Forum {
    
    
  private int id_forum ;
  private String forum_owner ;
  private String forum_topic ;
  
  

    public Forum(int id_forum, String  forum_owner, String forum_topic) {
        this.id_forum = id_forum;
        this.forum_owner = forum_owner;
        this.forum_topic = forum_topic;
        
     
    }

    public Forum() {
    }

    public Forum(int id_forum) {
        this.id_forum = id_forum;
    }
    
    public Forum(String  forum_owner, String forum_topic) {
        this.forum_owner = forum_owner;
        this.forum_topic = forum_topic;
    }

    public Forum(int id_forum, String forum_topic) {
        this.id_forum = id_forum;
        this.forum_topic = forum_topic;
    }
    
    
    

    public int getId_forum() {
        return id_forum;
    }

    public String  getForum_owner() {
        return forum_owner;
    }

    public String getForum_topic() {
        return forum_topic;
    }

    public void setId_forum(int id_forum) {
        this.id_forum = id_forum;
    }

    public void setForum_owner(String  forum_owner) {
        this.forum_owner = forum_owner;
    }

    public void setForum_topic(String forum_topic) {
        this.forum_topic = forum_topic;
    }

    @Override
    public String toString() {
        return forum_owner  ;
    }
    

   
  
  
  
  
  
  
  
  
  
  
}
