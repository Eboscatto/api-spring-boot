package br.com.apispringboot.projetoApi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {
    private Long id;
    private String name;
    private String userName;

    public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id; }
    public String getName() {
        return name; }
    public void setName(String name) {
        this.name = name; }
    public String getUserName() {
        return userName; }
    public void setUserName(String userName) {
        this.userName = userName; }
}
