package com.agenda.contato.Entities;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_CONTATO")
public class contato implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String fullname;
    private String occupation;
    private Date birthday;
    private String address;
    private String email;
    @Column(unique = true)
    private String number;
    private Boolean favorite;

    @ManyToOne
    @JoinColumn(name = "TYPE_ID")
    private tipo type;
    
    public contato() {

    }

    public contato(Long id, String nickname, String fullname, String occupation, Date birthday, String address, String email, String number, Boolean favorite) {
        this.id = id;
        this.nickname = nickname;
        this.fullname = fullname;
        this.occupation = occupation;
        this.birthday = birthday;
        this.address = address;
        this.email = email;
        this.number = number;
        this.favorite = favorite;
    }

    public contato(Long id, String nickname, String fullname, String occupation, Date birthday, String address, String email, String number, tipo type, Boolean favorite) {
        this.id = id;
        this.nickname = nickname;
        this.fullname = fullname;
        this.occupation = occupation;
        this.birthday = birthday;
        this.address = address;
        this.email = email;
        this.number = number;
        this.type = type;
        this.favorite = favorite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public tipo getType() {
        return type;
    }

    public void setType(tipo type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        contato other = (contato) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
